package controllers;

public class ListaLeitor extends ListaDuplamenteEncadeada<Leitor>{

	@Override
	protected String paraString(Leitor valor) {
		return "nome: " + valor.getNome() ;
	}

}
