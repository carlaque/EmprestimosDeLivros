package controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Emprestimo {
	private int codigo;
	private Date dataEmprestimo;
	private Date dataLimite;
	private Leitor leitor;
	private Livro livro;
	private String categoria;
	private boolean renovacao;
	
	public int getCodigo() { return codigo; }
	
	public Date getDataEmprestimo() { return dataEmprestimo; }

	public Date getDataLimite() { return dataLimite; }

	public Leitor getLeitor() { return leitor; }

	public Livro getLivro() { return livro; }

	public boolean estaRenovacao() { return renovacao; }

	public void Emprestar(Livro livro, Leitor leitor) {
		if(leitor.verificarDisponibilidadeEmprestimo()) {
			SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy"); 
			Date data = new Date();
			Calendar c = Calendar.getInstance();
			c.setTime( data );
			c.add( Calendar.DAY_OF_MONTH , 14 );
			System.out.println( c.getTime() );
			this.codigo = 0;
			this.categoria = leitor.getCategoria();
			this.leitor  = leitor;
			this.livro = livro;
			this.categoria = leitor.getCategoria();
			this.dataEmprestimo = data ;
			this.dataLimite = c.getTime();
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
		Date data = new Date();
		devolucao.Devolver(this, data);
	}

	public String getCategoria() {
		return categoria;
	}
}
