package controllers;

import java.util.Date;

import model.Alunos;

public abstract class Leitor{
	private static Alunos arquivo;
	
	protected int codigo;
	protected String nome;
	protected String endereco;
	protected String email;
	protected String telefone;
	protected int emprestimosCorrentes;

	
	public String getNome() { return nome; }
	
	public void setNome(String nome) { this.nome = nome; }
	
	public String getEndereco() { return endereco; }
	
	public void setEndereco(String endereco) { this.endereco = endereco; }
	
	public String getEmail() { return email; }
	
	public void setEmail(String email) { this.email = email; }
	
	public String getTelefone() { return telefone; }
	
	public void setTelefone(String telefone) { this.telefone = telefone; }
	
	public int getEmprestimosCorrentes() { 
		return emprestimosCorrentes; 
	}
	
	public void setEmprestimo() {
		this.emprestimosCorrentes++;
	}
	
	protected abstract void setDocumento(String documento);
	public abstract boolean verificarDisponibilidadeRenovacao(Date dataEmprestimo);	
	public abstract boolean verificarDisponibilidadeEmprestimo();
	
	public Leitor(){ }
	
	public void cadastrar(int codigo, String nome, String endereco, String telefone, String email, String documento) {
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.setDocumento(documento);
	}
	
		
	public void Editar() {
		// isso fica aqui mesmo???	
	}
	
	public void Consultar() {
		
	}
	
}
