package controllers;

import java.util.Date;

public class Devolucao {
	private int codigo;
	private Date dataDevolucao;
	
	public void Devolver(Date data, int codigoDevolucao) {
		this.dataDevolucao = data;
		this.codigo = codigoDevolucao;
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


	public void carregarDevolucoes(int codigo, Date data) {
		this.codigo = codigo;
		this.dataDevolucao = data;
	}

	
}
