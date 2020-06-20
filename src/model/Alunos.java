package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import controllers.Aluno;
import controllers.Leitor;
import controllers.ListaLeitor;

public class Alunos implements IGerenciadorArquivos {
	private final String nome =  "leitores.csv";
	private final String path =  "./";
	private String cabecalho = "codigo; nome; endereco; email; telefone; RA;\n";
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
					Aluno aluno = new Aluno();
					aluno.cadastrar(Integer.parseInt(aux[0]), aux[1], aux[2], aux[3], aux[4], aux[5]);
					lista.adicionaFinal(aluno);
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
		
		// percorrer lista para apagar os dados antigos e inserir os novos no arquivo
		// duvida: apagar todos os dados???
		
		File arq = new File(path, nome);
		String conteudo = "";
		FileWriter writer= new FileWriter(arq, true);
		PrintWriter print = new PrintWriter(writer);
		
		print.write(conteudo);
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
	public void readFile(String path, String nome) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void insereCadastro(T dados) throws IOException {
		lista.adicionaFinal((Leitor) dados);
	}

	@Override
	public <T> void editarCadastro(T dados) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> void excluirCadastro(T dados) throws IOException {
		
		//lista.removeDaPosicao();
		
	}


}
