package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controllers.Leitor;
import controllers.ListaLeitor;
import controllers.Professor;

public class Professores implements IGerenciadorArquivos {
	private final String nome =  "professores.csv";
	private final String path =  "./";
	private String cabecalho = "codigo; nome; endereco; email; telefone; CPF; emprestimos correntes\n";
	private ListaLeitor lista;
	
	@Override
	public void carregarLista() throws IOException {
		File arq = new File(path, nome);
		this.lista = new ListaLeitor();
		
		if(arq.exists()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor); 
			
			String linha = buffer.readLine();			
			while(linha != null) {
				String[] aux = linha.split(";");
				if(!aux[0].equals("codigo")) {
					Professor professor = new Professor();
					professor.cadastrar(Integer.parseInt(aux[0]), aux[1], aux[2], aux[3], aux[4], aux[5], Integer.parseInt(aux[6]));
					lista.adicionaFinal(professor);
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

	@Override
	public void salvarLista() throws IOException {
		File arq = new File(path, nome);
		FileWriter writer= new FileWriter(arq, true);
		PrintWriter print = new PrintWriter(writer);
		while(!lista.vazia()) {
			Professor a = (Professor) lista.removeDoInicio();
			String conteudo = a.getCodigo() + ";"
					+ a.getNome() + ";"
					+ a.getEndereco() + ";"
					+ a.getEmail() + ";"
					+ a.getTelefone() + ";"
					+ a.getCpf() + ";"
					+ a.getEmprestimosCorrentes() + "\n";
			
			print.write(conteudo);
		}
		
		
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
		lista.adicionaFinal((Leitor) dados);	
	}

	@Override
	public <T> void editarCadastro(T antigo, T novo) throws IOException {
		int posicao = lista.buscarPosicaoElemento((Leitor) antigo);
		lista.removeDaPosicao(posicao);
		lista.adicionaNaPosicao((Leitor) novo, posicao);
	}


	@Override
	public <T> void excluirCadastro(T dados) throws IOException {
		int posicao = lista.buscarPosicaoElemento((Leitor) dados);
		lista.removeDaPosicao(posicao);
		
	}

	

}
