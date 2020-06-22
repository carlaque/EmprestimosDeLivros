package controllers;

public class Livro {
	private int codigo;
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
	
	public int getCodigo() {
		return codigo;
	}
	
	public boolean emprestarPara(Leitor leitor) { 
		
		if(leitor.getCategoria().equals(this.categoria)) {
			this.quantidade--;
			return true;
		}
		return false;
	}
	public void devolver() { 
		this.quantidade++;
	}
	
	public void cadastrar(int codigo,String titulo, String autor, String iSBN, String categoria, int quantidade) {
		this.codigo = codigo;
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
