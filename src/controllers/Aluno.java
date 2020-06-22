package controllers;

public class Aluno extends Leitor  {
	private String RA;
	
	
	public String getRA() {
		return this.RA;
	}

	@Override
	public void setDocumento(String documento) {
		this.RA = documento;
	}

	@Override
	public boolean verificarDisponibilidadeEmprestimo() {
		if(this.emprestimosCorrentes  <= 3) return true;
		else return false;
	}
	
}
