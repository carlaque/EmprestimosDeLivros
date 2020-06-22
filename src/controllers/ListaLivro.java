package controllers;

public class ListaLivro extends ListaDuplamenteEncadeada<Livro>{

	@Override
	protected String paraString(Livro valor) {
		return "nome: " + valor.getTitulo() ;
	}

}
