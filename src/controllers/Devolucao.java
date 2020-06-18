package controllers;

import java.util.Date;

public class Devolucao {
	private Emprestimo emprestimo;
	private Date dataDevolucao;
	
	public void Devolver(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
		this.dataDevolucao = new java.util.Date();
	}
	
	public boolean devolveuNoPrazo() {
		//TODO current time = ou anterior a data limite
		return true;
	}

}
