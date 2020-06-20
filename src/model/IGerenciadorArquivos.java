package model;

import java.io.IOException;

public interface IGerenciadorArquivos {
	public void createFile() throws IOException;
	public void readFile(String path, String nome) throws IOException;
	public <T> void insereCadastro(T dados) throws IOException;
	public <T> void editarCadastro(T dados) throws IOException;
	public <T> void excluirCadastro(T dados) throws IOException;
	public void carregarLista() throws IOException;
	
}
