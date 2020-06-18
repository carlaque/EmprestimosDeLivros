package controllers;

public class Livro {
	private String titulo;
	private String autor;
	private String ISBN;
	private String categoria;
	private int quantidade;

	public String getTitulo() { return titulo;	}

	public String getAutor() { return autor; }

	public String getISBN() { return ISBN; }

	public String getCategoria() { return categoria; }

	public int getQuantidade() { return quantidade;	}
	
	public void emprestar() { 
		this.quantidade--;
	}
	public void devolver() { 
		this.quantidade++;
	}
	
	public void cadatrar(String titulo, String autor, String iSBN, String categoria, int quantidade) {
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = iSBN;
		this.quantidade = quantidade;
		this.categoria = categoria;
	}
	
	public void consultar() {
		
	}
	
	public void editar() {
		
	}
	
	public boolean verificarDisponibilidade() {
		if(quantidade > 0) return true;
		return false;
	}
	
	public void adicionarNaFilaDeEspera(Leitor leitor) {
		
	}

}
