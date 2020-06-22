package controllers;

import java.util.Date;

public class Devolucao {
	private int codigo;
	private Emprestimo emprestimo;
	private Date dataDevolucao;
	
	public void Devolver(Emprestimo emprestimo, Date data) {
		this.emprestimo = emprestimo;
		this.dataDevolucao = data;
	}
	
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	
	public int getCodigo() {
		return codigo;
	}


	public boolean devolveuNoPrazo() {
		
		return true;
	}

	
}
