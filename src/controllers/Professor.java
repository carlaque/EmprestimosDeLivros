package controllers;

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
	public boolean verificarDisponibilidadeEmprestimo() {
		return true;
	}
	
}
