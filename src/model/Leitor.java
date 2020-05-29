package model;

public abstract class Leitor {
	private String nome;
	private String endereco;
	private String email;
	private int emprestimosCorrentes; 
	
	
	public void Cadastrar() {
		
	}
	
	public void Editar() {
		
	}
	
	public void Consultar() {
		
	}
	
	public boolean verificarDisponibilidadeRenovacao() {
		return true;
	}
	
	public boolean verificarDisponibilidadeEmprestimo() {
		return true;
	}

}
