package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controllers.Emprestimo;
import controllers.ListaEmprestimo;
import controllers.Leitor;
import controllers.Livro;
import controllers.NO;

public class Emprestimos implements IGerenciadorArquivos {
	private final String nome =  "emprestimos.csv";
	private final String path =  "./";
	private String cabecalho = "codigo; dataEmprestimo; dataLimite; codigo_leitor; codigo_livro; categoria; renovacao;\n";
	private ListaEmprestimo lista;
	private Livros livros;
	private Alunos alunos;
	private Professores professores;
	
	public Emprestimos(Livros livros, Alunos alunos, Professores professores) throws IOException {
		this.livros = livros;
		this.alunos = alunos;
		this.professores = professores;
		carregarLista();
	}
	
	@Override
	public void carregarLista() throws IOException {
		File arq = new File(path, nome);
		
		this.lista = new ListaEmprestimo();
		
		if(arq.exists()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor); 
			
			String linha = buffer.readLine();			
			while(linha != null) {
				String[] aux = linha.split(";");
				if(!aux[0].equals("codigo")) {
					Emprestimo emprestimo = new Emprestimo();
					Leitor le;
					if(aux[5].equals("todos")) { 
						le = alunos.buscaPeloCodigo(Integer.parseInt(aux[3]));
					}else {
						le = professores.buscaPeloCodigo(Integer.parseInt(aux[3]));
					}
					Livro li = livros.buscaPeloCodigo(Integer.parseInt(aux[4]));
					emprestimo.Emprestar(Integer.parseInt(aux[0]),li, le );
					lista.adicionaFinal(emprestimo);
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}else {
			createFile();
			carregarLista();
		}
		
	}
	
	public void salvarLista() throws IOException{
		limparArquivo();
		File arq = new File(path, nome);
		FileWriter writer= new FileWriter(arq, true);
		PrintWriter print = new PrintWriter(writer);
		
		while(!lista.vazia()) {
			Emprestimo a = (Emprestimo) lista.removeDoInicio();
			String conteudo = a.getCodigo() + ";"
					+ a.getDataEmprestimo() + ";"
					+ a.getDataLimite() + ";"
					+ a.getLeitor().getCodigo() + ";"
					+ a.getLivro().getCodigo() + ";"
					+ a.getLeitor().getCategoria() + ";"
					+ a.estaRenovacao() + "\n";
			
			print.write(conteudo);
		}
		
		print.flush();
		print.close();
		writer.close();
		
	}
	
	@Override
	public void limparArquivo() throws IOException {
		File arq = new File(path, nome );
		
		arq.delete();
		arq = new File(path, nome );
		FileWriter writer= new FileWriter(arq, true);
		PrintWriter print = new PrintWriter(writer);
		print.write(cabecalho);
		print.flush();
		print.close();
		writer.close();

	}

	@Override
	public void createFile() throws IOException {
		File dir = new File(path);
		File arq = new File(path, nome );
		if(dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if(!arq.exists()) {
				existe = true;
				String conteudo = cabecalho;
				FileWriter writer= new FileWriter(arq, existe);
				PrintWriter print = new PrintWriter(writer);
				print.write(conteudo);
				print.flush();
				print.close();
				writer.close();
			}
			
		}else {
			throw new IOException();
		}
		
	}

	@Override
	public <T> void insereCadastro(T dados) throws IOException {
		lista.adicionaFinal((Emprestimo) dados);
	}

	@Override
	public <T> void editarCadastro(int codigo, T dadosNovos) throws IOException {
		int posicao = getPosicaoDoCodigo(codigo);
		if(posicao > -1) {
			lista.removeDaPosicao(posicao+1);
			lista.adicionaNaPosicao((Emprestimo) dadosNovos, posicao);
		}
		else System.out.println("codigo invalido");
	}

	@Override
	public <T> void excluirCadastro(int codigo) throws IOException {
		int posicao = getPosicaoDoCodigo(codigo);
		if(posicao > -1)lista.removeDaPosicao(posicao+1);
		else System.out.println("codigo invalido");
	}
	
	@SuppressWarnings("unchecked")
	public <T> int getPosicaoDoCodigo(int codigo) {
		NO<T> aux = (NO<T>) lista.getInicio();
		int pos = -1;
		boolean percorre = true;
		while(aux.getProximo() != null && percorre) {
			Emprestimo l = (Emprestimo) aux.getDado();
			if(l.getCodigo() == codigo) percorre = false;
			aux = aux.getProximo();
			pos++;
		}
		
		return pos;
	}

	public Emprestimo buscaPeloCodigo(int codigo) {
		int pos = getPosicaoDoCodigo(codigo) ;
		return lista.buscaNaPosicao(lista.getInicio(), pos+ 1).getDado();
	}

	public int getProximoCodigo() {
		if(lista.vazia()) 
			return 0;
		else
			return lista.buscaUltimo(lista.getInicio()).getDado().getCodigo() + 1;
	}

}
