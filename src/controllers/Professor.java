package controllers;

import java.util.Date;

public class Professor extends Leitor{
	private String cpf;
	
	public String getCpf() {
		return cpf;
	}

	@Override
	public void setDocumento(String documento) {
		this.cpf = documento;
	}


	@Override
	public boolean verificarDisponibilidadeRenovacao(Date dataEmprestimo) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean verificarDisponibilidadeEmprestimo() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
