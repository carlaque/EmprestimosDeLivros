package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import controllers.Devolucao;
import controllers.Emprestimo;
import controllers.ListaDevolucao;
import controllers.NO;

public class Devolucoes implements IGerenciadorArquivos {
	private final String nome =  "devolucoes.csv";
	private final String path =  "./";
	private String cabecalho = "codigo; codigo_emprestimo; data_devolucao\n";
	private ListaDevolucao lista;
	
	public Devolucoes() throws IOException {
		carregarLista();
	}
	
	@Override
	public void carregarLista() throws IOException {
		File arq = new File(path, nome);
		this.lista = new ListaDevolucao();
		
		if(arq.exists()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor); 
			
			
			String linha = buffer.readLine();			
			while(linha != null) {
				String[] aux = linha.split(";");
				if(!aux[0].equals("codigo")) {
					Devolucao dev = new Devolucao();
					
					dev.carregarDevolucoes(Integer.parseInt(aux[0]),getData(aux[1])); 
					lista.adicionaFinal(dev);
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
		
		if(lista.vazia()) {
			return ;
		}
		
		while(!lista.vazia()) {
			Devolucao a = (Devolucao) lista.removeDoInicio();
			String conteudo = a.getCodigo() + ";"
					+ a.getDataDevolucao() + "\n";
			
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
		lista.adicionaFinal((Devolucao) dados);
	}

	@Override
	public <T> void editarCadastro(int codigo, T dadosNovos) throws IOException {
		int posicao = getPosicaoDoCodigo(codigo);
		if(posicao > -1) {
			lista.removeDaPosicao(posicao+1);
			lista.adicionaNaPosicao((Devolucao) dadosNovos, posicao);
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
			Devolucao l = (Devolucao) aux.getDado();
			if(l.getCodigo() == codigo) percorre = false;
			aux = aux.getProximo();
			pos++;
		}
		
		return pos;
	}
	
	public Devolucao buscaPeloCodigo(int codigo) {
		int pos = getPosicaoDoCodigo(codigo) ;
		return lista.buscaNaPosicao(lista.getInicio(), pos+ 1).getDado();
	}
	
	public int getProximoCodigo() {
		return lista.buscaUltimo(lista.getInicio()).getDado().getCodigo();
	}

	public Date getData(String data) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
		Date date = null;
		try {
			date = formato.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

}

