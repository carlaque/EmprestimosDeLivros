package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controllers.Livro;
import controllers.ListaLivro;
import controllers.NO;

public class Livros implements IGerenciadorArquivos {
	private final String nome =  "livros.csv";
	private final String path =  "./";
	private String cabecalho = "codigo; titulo; autor; ISBN; categoria; quantidade;\n";
	private ListaLivro lista;
	
	public ListaLivro getLista(){
		return this.lista;
	}
	public Livros() throws IOException {
		carregarLista();
	}
	
	@Override
	public void carregarLista() throws IOException {
		File arq = new File(path, nome);
		this.lista = new ListaLivro();
		
		if(arq.exists()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor); 
			
			String linha = buffer.readLine();			
			while(linha != null) {
				String[] aux = linha.split(";");
				if(!aux[0].equals("codigo")) {
					Livro livro = new Livro();
					livro.cadastrar(Integer.parseInt(aux[0]), aux[1], aux[2], aux[3], aux[4], Integer.parseInt(aux[5]));
					lista.adicionaFinal(livro);
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
			Livro a = (Livro) lista.removeDoInicio();
			String conteudo = a.getCodigo() + ";"
					+ a.getTitulo() + ";"
					+ a.getAutor() + ";"
					+ a.getISBN() + ";"
					+ a.getCategoria() + ";"
					+ a.getQuantidade() + "\n";
			
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
		lista.adicionaFinal((Livro) dados);
	}

	@Override
	public <T> void editarCadastro(int codigo, T dadosNovos) throws IOException {
		int posicao = getPosicaoDoCodigo(codigo);
		if(posicao > -1) {
			lista.removeDaPosicao(posicao+1);
			lista.adicionaNaPosicao((Livro) dadosNovos, posicao);
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
		while(aux != null && percorre) {
			Livro l = (Livro) aux.getDado();
			if(l.getCodigo() == codigo) percorre = false;
			aux = aux.getProximo();
			pos++;
		}
		
		return pos;
	}

	public Livro buscaPeloCodigo(int codigo) {
		int pos = getPosicaoDoCodigo(codigo) + 1;
		if(pos > -1)
			return lista.buscaNaPosicao(lista.getInicio(), pos).getDado();
		else
			return null;
	}
	
	public int getProximoCodigo() {
		if(lista.vazia()) 
			return 0;
		else
			return lista.buscaUltimo(lista.getInicio()).getDado().getCodigo() + 1;
	}
	
	
	
}
