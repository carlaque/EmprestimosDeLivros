package controllers;

public class ListaDevolucao extends ListaDuplamenteEncadeada<Devolucao>{

	@Override
	protected String paraString(Devolucao valor) {
		return "nome: "  ;
	}
	
	@SuppressWarnings("unchecked")
	public <T> Devolucao getEmprestimoDoCodigo(int codigo) {
		NO<T> aux = (NO<T>) this.getInicio();
		boolean percorre = true;
		Devolucao res = null;
		while(aux.getProximo() != null && percorre) {
			res = (Devolucao) aux.getDado();
			if(res.getCodigo() == codigo) percorre = false;
			aux = aux.getProximo();
		}
		
		return res;
	}

}

