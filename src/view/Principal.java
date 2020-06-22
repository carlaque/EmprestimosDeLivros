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
		
		
//			Livro l = new Livro();
//			l.cadastrar(1, "harry potter", "JK rowling", "123456789", "todos", 5);
//			
//			livros.insereCadastro(l);
//			
//			livros.salvarLista();
			
		
		Emprestimo novo = new Emprestimo();
		novo.Emprestar(livros.buscaPeloCodigo(1), alunos.buscaPeloCodigo(2));;
		emprestimos.insereCadastro(novo);
//		
		emprestimos.salvarLista();
		livros.salvarLista();
		professores.salvarLista();
		alunos.salvarLista();
		devolucoes.salvarLista();
		
	}

}
