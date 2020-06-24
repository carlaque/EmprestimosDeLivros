package controllers;

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
	private Devolucao devolucao;
	
	public int getCodigo() { return codigo; }
	
	public Date getDataEmprestimo() { return dataEmprestimo; }

	public Date getDataLimite() { return dataLimite; }

	public Leitor getLeitor() { return leitor; }

	public Livro getLivro() { return livro; }
	
	public Devolucao getDevolucao() { return devolucao; }

	public boolean estaRenovacao() { return renovacao; }

	public boolean Emprestar(int codigo, Livro livro, Leitor leitor) {
		if(livro != null && leitor != null ) {
			if(leitor.verificarDisponibilidadeEmprestimo() && livro.emprestarPara(leitor)) {
				Date data = new Date();
				Calendar c = Calendar.getInstance();
				c.setTime( data );
				c.add( Calendar.DAY_OF_MONTH , 14 );
				
				this.codigo = codigo;
				this.leitor  = leitor;
				this.livro = livro;
				this.categoria = leitor.getCategoria();
				this.dataEmprestimo = data ;
				this.dataLimite = c.getTime();
				leitor.setEmprestimo();
				return true;
			}else if (!leitor.verificarDisponibilidadeEmprestimo()) {
				System.out.println("leitor do codigo "+ leitor.getCodigo()+" esta indisponivel para emprestimo, \nporque atingiu seu limite de emprestimos.");
				return false;
			}else {
				System.out.println("leitor do codigo "+ leitor.getCodigo()+" esta indisponivel para emprestimo, \nporque nao tem permissao para retirada desse livro.");
				return false;
			}
		}else if( leitor == null)
			System.out.println("Codigo de leitor invalido");
		else 
			System.out.println("Codigo de livro invalido");
		return false;
	}
	
	public void renovarEmprestimo() {
		if(!this.renovacao ) {//|| !this.leitor.getCategoria().equals("total")) { // TODO verificar a questao do leitor 
			Calendar c = Calendar.getInstance();
	        c.setTime(this.dataLimite);
	        c.add(Calendar.DATE, 14);
	        this.dataLimite = c.getTime();
			this.renovacao = true;
		}
	}
	
	public void devolverLivro(int codigoDevolucao) {
		devolucao = new Devolucao();
		Date data = new Date();
		devolucao.Devolver(data, codigoDevolucao);
		this.livro.devolver();
		this.leitor.setDevolucao();
	}
	
	
	
	public void carregarEmprestimo(int codigo, Date dataEmprestimo, Date dataLimite, Leitor leitor, Livro livro, String categoria,
			boolean renovacao, Devolucao devolucao) {
		this.codigo = codigo;
		this.dataEmprestimo = dataEmprestimo;
		this.dataLimite = dataLimite;
		this.leitor = leitor;
		this.livro = livro;
		this.categoria = categoria;
		this.renovacao = renovacao;
		this.devolucao = devolucao;
	}

	public String getCategoria() {
		return categoria;
	}
}
