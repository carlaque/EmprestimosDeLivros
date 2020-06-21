package view;

import java.io.IOException;

import controllers.Aluno;
import controllers.Professor;
import model.Alunos;
import model.Professores;

public class Principal {
	public static void main(String[] args) throws IOException {
		Alunos a = new Alunos();
		Professores p = new Professores();
		p.carregarLista();
		a.carregarLista();
		
		
//		for(int i =0;i < 5; i ++) {
//			Aluno al = new Aluno();
//			al.cadastrar(i, "b", "b", "b", "b", "b", 2);
//			a.insereCadastro(al);
//		}
		
//		Aluno novo = new Aluno();
//		novo.cadastrar(2, "asdfasfdsgdsh", "b", "b", "b", "b", 2);
//		a.editarCadastro(2, novo);
//		
		a.salvarLista();
	}

}
