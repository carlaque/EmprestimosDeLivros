package model;

import java.io.IOException;
import java.util.Date;

public interface IGerenciadorArquivos {
	public void createFile() throws IOException;
	public void limparArquivo() throws IOException;
	public <T> void insereCadastro(T dados) throws IOException;
	public <T> void editarCadastro(int codigo, T dadosNovos) throws IOException;
	public <T> void excluirCadastro(int codigo) throws IOException;
	public void carregarLista() throws IOException;
	public void salvarLista() throws IOException;
	public <T> int getPosicaoDoCodigo(int codigo);
}
