package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.Alunos;
import model.Devolucoes;
import model.Emprestimos;
import model.Livros;
import model.Professores;

public class Menu extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static Alunos alunos;
	private static Livros livros;
	private static Professores professores;
	private static Devolucoes devolucoes;
	private static Emprestimos emprestimos;
	
	
	public static void main(String[] args) throws IOException {
		livros = new Livros();
		alunos = new Alunos();
		professores = new Professores();
		devolucoes = new Devolucoes();
		emprestimos = new Emprestimos(livros, alunos, professores, devolucoes);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
					
					
					frame.addWindowListener(new WindowAdapter() {
			            @Override
			            public void windowClosing(WindowEvent e) {
			            	try {
								emprestimos.salvarLista();
								livros.salvarLista();
				        		professores.salvarLista();
				        		alunos.salvarLista();
				        		devolucoes.salvarLista();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
			        		
			                System.exit(0);
			            }
			        });
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	
	
	
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("Sistema de Emprestimos de Livros");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitulo.setBounds(25, 65, 436, 20);
		contentPane.add(lblTitulo);
		
		JButton btnDevolucao = new JButton("Efetuar Devolu\u00E7\u00E3o");
		btnDevolucao.setBounds(23, 219, 440, 40);
		contentPane.add(btnDevolucao);
		btnDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		JButton btnConsultarLivro = new JButton("Consultar Livro");
		btnConsultarLivro.setBounds(23, 289, 440, 40);
		contentPane.add(btnConsultarLivro);
		btnConsultarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnConsultarAluno = new JButton("Consultar Aluno");
		btnConsultarAluno.setBounds(23, 359, 440, 40);
		contentPane.add(btnConsultarAluno);
		btnConsultarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnConsultarProfessor = new JButton("Consultar Professor");
		btnConsultarProfessor.setBounds(23, 429, 440, 40);
		contentPane.add(btnConsultarProfessor);
		btnConsultarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnEmprestimo = new JButton("Efetuar Emprestimo");
		btnEmprestimo.setBounds(23, 149, 440, 40);
		contentPane.add(btnEmprestimo);
		btnEmprestimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
		btnCadastrarAluno.setBounds(23, 499, 440, 40);
		contentPane.add(btnCadastrarAluno);
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroAluno frame = new CadastroAluno(alunos);
				frame.setVisible(true);
				
			}
		});
		
		JButton btnCadastrarProfessor = new JButton("Cadastrar Professor");
		btnCadastrarProfessor.setBounds(23, 569, 440, 40);
		contentPane.add(btnCadastrarProfessor);
		btnCadastrarProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
		btnCadastrarLivro.setBounds(23, 639, 440, 40);
		contentPane.add(btnCadastrarLivro);
		btnCadastrarLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroLivro frame = new CadastroLivro(livros);
				frame.setVisible(true);
			}
		});
	}
}
