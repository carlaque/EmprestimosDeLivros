package model;

import java.util.Date;

public class Aluno extends Leitor {
	private String RA;
	
	@Override
	public boolean verificarDisponibilidadeEmprestimo() {
		if(emprestimosCorrentes < 3) 
			return true;
		
		return false;
	}
	
	public boolean verificarDisponibilidadeRenovacao(Emprestimo emprestimo) {
		return false;
	}
}
