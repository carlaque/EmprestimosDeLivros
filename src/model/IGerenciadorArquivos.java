package model;

import java.io.IOException;

public interface IGerenciadorArquivos {
	public void createFile() throws IOException;
	public void limparArquivo() throws IOException;
	public <T> void insereCadastro(T dados) throws IOException;
	public <T> void editarCadastro(int codigo, T dadosNovos) throws IOException;
	public <T> void excluirCadastro(int codigo) throws IOException;
	public void carregarLista() throws IOException;
	public void salvarLista() throws IOException;
	
}
