package view;

import java.io.IOException;

import controllers.Aluno;
import controllers.Emprestimo;
import controllers.Livro;
import controllers.Professor;
import model.Alunos;
import model.Devolucoes;
import model.Emprestimos;
import model.Livros;
import model.Professores;

public class Principal {
	public static void main(String[] args) throws IOException {
		Livros livros = new Livros();
		Alunos alunos = new Alunos();
		Professores professores = new Professores();
		Emprestimos emprestimos = new Emprestimos(livros, alunos, professores);
		Devolucoes devolucoes = new Devolucoes(emprestimos);
		
		String[] nomes = {"francisco", "bernado", "clarice", "guilherme", "marilia"};
		
//		for(int i =0;i < 5; i ++) {
//			Professor a = new Professor();
//			a.cadastrar(professores.getProximoCodigo(), nomes[i], "rua xxx", "email@email.com", "123456789", "todos", "1234564879", 0);
//			professores.insereCadastro(a);
//		}		
		
		Emprestimo novo = new Emprestimo();
		if(novo.Emprestar(emprestimos.getProximoCodigo(), livros.buscaPeloCodigo(1), alunos.buscaPeloCodigo(1)))
			emprestimos.insereCadastro(novo);

		
		emprestimos.salvarLista();
		livros.salvarLista();
		professores.salvarLista();
		alunos.salvarLista();
		devolucoes.salvarLista();
		
	}

}
