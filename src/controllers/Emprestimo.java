package controllers;

import java.util.Calendar;
import java.util.Date;

public class Emprestimo {
	private Date dataEmprestimo;
	private Date dataLimite;
	private Leitor leitor;
	private Livro livro;
	private boolean renovacao;
	
	public Date getDataEmprestimo() { return dataEmprestimo; }

	public Date getDataLimite() { return dataLimite; }

	public Leitor getLeitor() { return leitor; }

	public Livro getLivro() { return livro; }

	public boolean isRenovacao() { return renovacao; }

	public void Emprestar(Livro livro, Leitor leitor) {
		if(leitor.verificarDisponibilidadeEmprestimo()) {			
			livro.emprestar();
			leitor.setEmprestimo();
		}else {
			System.out.println("leitor indisponivel para emprestimo");
		}
	}
	
	public void renovarEmprestimo() {
		if(!this.renovacao) { // TODO verificar a questao do leitor 
			Calendar c = Calendar.getInstance();
	        c.setTime(this.dataLimite);
	        c.add(Calendar.DATE, 1);
	        this.dataLimite = c.getTime();
			this.renovacao = true;
		}
	}
	
	public void devolverLivro() {
		Devolucao devolucao = new Devolucao();
		devolucao.Devolver(this);
	}
}
