package controllers;

public class NO<T>{
	private T dado;
	private NO<T> anterior;
	private NO<T> proximo;
	
	public NO(T dado) {
		this.dado = dado;
		this.proximo = null;
		this.anterior = null;
	}

	public T getDado() {
		return dado;
	}

	public void setDado(T dado) {
		this.dado = dado;
	}

	public NO<T> getAnterior() {
		return anterior;
	}

	public void setAnterior(NO<T> anterior) {
		this.anterior = anterior;
	}

	public NO<T> getProximo() {
		return proximo;
	}

	public void setProximo(NO<T> proximo) {
		this.proximo = proximo;
	}
	

}
