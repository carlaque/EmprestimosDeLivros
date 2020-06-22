package controllers;

import java.util.Date;

public class Aluno extends Leitor  {
	private String RA;
	
	public Aluno(){
		this.categoria = "aluno";
	}
	
	public String getRA() {
		return this.RA;
	}

	@Override
	public void setDocumento(String documento) {
		this.RA = documento;
	}

	@Override
	public boolean verificarDisponibilidadeRenovacao(Date dataEmprestimo) {
		return false;
	}

	@Override
	public boolean verificarDisponibilidadeEmprestimo() {
		if(this.emprestimosCorrentes  <= 3) return true;
		return false;
	}
	
}
