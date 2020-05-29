package model;

import java.util.Date;

public abstract class Leitor {
	protected String nome;
	protected String endereco;
	protected String email;
	protected int emprestimosCorrentes; 
	
	
	public void Cadastrar() {
		
	}
	
	public void Editar() {
		
	}
	
	public void Consultar() {
		
	}
	
	public boolean verificarDisponibilidadeRenovacao(Date dataEmprestimo) {
		return true;
	}
	
	public boolean verificarDisponibilidadeEmprestimo() {
		return true;
	}

}
