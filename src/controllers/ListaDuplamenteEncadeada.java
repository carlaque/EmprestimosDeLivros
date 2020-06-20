package controllers;

public class ListaDuplamenteEncadeada<T> {
	private NO<T> inicio;
	
	public ListaDuplamenteEncadeada() {
		inicio = null;
	}
	
	public boolean vazia() {
		return this.inicio == null;
	}
	public NO<T> buscaUltimo(NO<T> elemento) {
		if(elemento.getProximo()!= null)
			return buscaUltimo(elemento.getProximo());
		
		return elemento;
	}
	
	public NO<T> buscaNaPosicao(NO<T> elemento, int pos) {
		if(elemento.getProximo()!= null && pos > 1)
			return buscaNaPosicao(elemento.getProximo(), --pos);
		
		if(elemento.getProximo() == null && pos > 1)
			return null;
		
		return elemento;
	}
	
	public void adicionaInicio( T dado) {
		NO<T> novo = new NO<T>(dado);
		
		if(!vazia()) {
			novo.setProximo(this.inicio);
			inicio.setAnterior(novo);
		}
		inicio = novo;
	}

	public void adicionaFinal(T dado) {
		NO<T> novo = new NO<T>(dado);
		
		if(vazia()) {
			inicio = novo;
			novo.setAnterior(null);
			novo.setProximo(null);
		}else {
			NO<T> aux = buscaUltimo(this.inicio);
			aux.setProximo(novo);
			novo.setAnterior(aux);
			novo.setProximo(null);
		}
	}

	public void adicionaNaPosicao(T dado, int posicao) {
		if(!vazia()) {
			
			if(posicao == 0) {
				adicionaInicio(dado); 
				return ;
			}
			
			NO<T> aux = buscaNaPosicao(inicio, posicao);
			if(aux == null)
				System.out.println("Posicao invalida.");
			else {				
				NO<T> novo = new NO<T>(dado);
				novo.setProximo(aux.getProximo());
				aux.setProximo(novo);
				novo.setAnterior(aux);
			}
			
		}else System.out.println("Lista esta Vazia");
		
	}
	
	public T removeDoInicio() {
		T resposta = null;
		
		if(vazia()) { 
			System.out.println("A lista esta vazia");
			return resposta;
		}
		
		resposta = this.inicio.getDado();
		this.inicio = this.inicio.getProximo();
		if(this.inicio != null) this.inicio.setAnterior(null);
		
		return resposta;
	}
	
	public T removeDoFinal() {
		T resposta = null;
		
		if(vazia()) { 
			System.out.println("A lista esta vazia");
			return resposta;
		}
		
		if(this.inicio.getProximo() == null) {
			resposta = this.inicio.getDado();
			inicio = null;
			return resposta;
		}
		
		NO<T> aux = buscaUltimo(this.inicio);
		resposta = aux.getDado();
		aux.getAnterior().setProximo(null);
		aux.setAnterior(null);
		
		return resposta;
	}
	
	public T removeDaPosicao(int posicao) {
		T resposta = null;
		
		if(vazia()) return resposta;
		
		if(posicao == 1) return removeDoInicio();
		
		NO<T> aux = buscaNaPosicao(inicio, posicao);
		if(aux == null)
			System.out.println("Posicao invalida.");
		else {
			aux.getAnterior().setProximo(aux.getProximo());
			aux.getProximo().setAnterior(aux.getAnterior());
		}
		
		return resposta;
	}
	
	public String mostrarElementos() {
		return elementos(this.inicio, "");
	}
	
	public String elementos(NO<T> aux, String r) {
		if(aux!=null) {
			r= r + "\n" + paraString(aux.getDado());
			return elementos(aux.getProximo(), r);
		}
		return r;
	}
	
	protected String paraString(T valor) {
		return String.valueOf(valor);
	}
	
	public int removeUltimoRecursivo() {
		return removeUltimo(inicio);
	}
	
	private int removeUltimo(NO<T> no) {
		if(vazia()) return -1;
		
		NO<T> aux = no;
		if(aux.getProximo() != null) 
			return removeUltimo(aux.getProximo());
		else {
			aux.getAnterior().setProximo(null);
			return (int) aux.getDado();
		}
	}
	
	public int removePrimeiroRecursivo() {
		return removePrimeiro(inicio);
	}
	
	private int removePrimeiro(NO<T> no) {
		if(vazia()) return -1;
		
		NO<T> aux = no;
		if(aux.getAnterior() != null) 
			return removePrimeiro(aux.getAnterior());
		else {
			if(aux == inicio) {
				inicio = aux.getProximo();
			}
			aux.getProximo().setAnterior(null);
			return (int) aux.getDado();
		}
	}
}
