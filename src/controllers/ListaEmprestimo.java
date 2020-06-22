package controllers;

public class ListaEmprestimo extends ListaDuplamenteEncadeada<Emprestimo>{

	@Override
	protected String paraString(Emprestimo valor) {
		return "nome: " ;
	}
	
	@SuppressWarnings("unchecked")
	public <T> Emprestimo getEmprestimoDoCodigo(int codigo) {
		NO<T> aux = (NO<T>) this.getInicio();
		boolean percorre = true;
		Emprestimo res = null;
		while(aux.getProximo() != null && percorre) {
			res = (Emprestimo) aux.getDado();
			if(res.getCodigo() == codigo) percorre = false;
			aux = aux.getProximo();
		}
		
		return res;
	}

}
