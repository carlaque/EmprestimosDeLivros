package view;

import java.io.IOException;

import controllers.Aluno;
import model.Alunos;

public class Principal {
	public static void main(String[] args) throws IOException {
		Alunos a = new Alunos();
		a.carregarLista();
		Aluno al = new Aluno();
		al.cadastrar(2, "b", "b", "b", "b", "b");
		a.insereCadastro(al);
	}

}
