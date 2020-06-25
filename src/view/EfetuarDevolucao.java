package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;

import controllers.Emprestimo;
import controllers.Leitor;
import controllers.Livro;
import model.Alunos;
import model.Devolucoes;
import model.Emprestimos;
import model.Livros;
import model.Professores;

public class EfetuarDevolucao extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoEmprestimo;
	private JTextField txtNomeLivro;
	private JTextField txtNomeLeitor;
	private JTextField txtlDataLimite;
	
	/**
	 * Create the frame.
	 */
	public EfetuarDevolucao(final Devolucoes devolucoes, final Emprestimos emprestimos) {
		setBounds(100, 100, 451, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5))	;
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(12, 685, 410, 40);
		contentPane.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        setVisible(false);
			}
		});
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
					int codEmprestimo = Integer.parseInt(txtCodigoEmprestimo.getText());
					Emprestimo novo = new Emprestimo(); 
					novo = emprestimos.buscaPeloCodigo(codEmprestimo);
					
					if(novo != null && novo.getDevolucao() == null) {						
						try {
							novo.devolverLivro(devolucoes.getProximoCodigo());
							
							devolucoes.insereCadastro(novo.getDevolucao());
							
							JOptionPane.showMessageDialog(null,
								    "Emprestimo do livro " + novo.getLivro().getTitulo() + " ao leitor " + novo.getLeitor().getNome() + " foi finalizado com sucesso!",
								    "Emprestimo",
								    JOptionPane.PLAIN_MESSAGE);
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(null,
								    "Não foi possivel finalizar o emprestimo, por favor verifique o codigo do livro.",
								    "Devolução",
								    JOptionPane.ERROR_MESSAGE);
							e1.printStackTrace();
						}
					
					}else {
						System.out.println(novo.getDevolucao().getCodigo());
						
						JOptionPane.showMessageDialog(null,
							    "Não foi possivel finalizar o emprestimo, por favor verifique o codigo do livro.",
							    "Devolução",
							    JOptionPane.ERROR_MESSAGE);
					}
					
					
					
					txtCodigoEmprestimo.setText("");
					novo = null;
				
			}
		});
		btnDevolver.setBounds(12, 620, 410, 40);
		contentPane.add(btnDevolver);
		
		JLabel lblCodigoEmprestimo = new JLabel("Codigo Emprestimo:");
		lblCodigoEmprestimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoEmprestimo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCodigoEmprestimo.setBounds(12, 71, 410, 20);
		contentPane.add(lblCodigoEmprestimo);
		
		txtCodigoEmprestimo = new JTextField();
		txtCodigoEmprestimo.setBounds(12, 117, 410, 40);
		contentPane.add(txtCodigoEmprestimo);
		txtCodigoEmprestimo.setColumns(10);
		
		JLabel lblNomeLivro = new JLabel("Nome Livro:");
		lblNomeLivro.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeLivro.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNomeLivro.setBounds(12, 295, 410, 20);
		contentPane.add(lblNomeLivro);
		
		txtNomeLivro = new JTextField();
		txtNomeLivro.setEnabled(false);
		txtNomeLivro.setEditable(false);
		txtNomeLivro.setColumns(10);
		txtNomeLivro.setBounds(12, 341, 410, 40);
		contentPane.add(txtNomeLivro);
		
		JLabel lblEmprestimo = new JLabel("Efetuar Emprestimo");
		lblEmprestimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEmprestimo.setBounds(12, 25, 410, 20);
		contentPane.add(lblEmprestimo);
		

		
		JLabel lblNomeLeitor = new JLabel("Nome Leitor:");
		lblNomeLeitor.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeLeitor.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNomeLeitor.setBounds(12, 183, 410, 20);
		contentPane.add(lblNomeLeitor);
		
		txtNomeLeitor = new JTextField();
		txtNomeLeitor.setEnabled(false);
		txtNomeLeitor.setEditable(false);
		txtNomeLeitor.setColumns(10);
		txtNomeLeitor.setBounds(15, 229, 410, 40);
		contentPane.add(txtNomeLeitor);
		
		txtlDataLimite = new JTextField();
		txtlDataLimite.setEnabled(false);
		txtlDataLimite.setEditable(false);
		txtlDataLimite.setColumns(10);
		txtlDataLimite.setBounds(12, 453, 410, 40);
		contentPane.add(txtlDataLimite);
		
		JLabel lblDataLimite = new JLabel("Data Limite:");
		lblDataLimite.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataLimite.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDataLimite.setBounds(12, 407, 410, 20);
		contentPane.add(lblDataLimite);
		
		txtCodigoEmprestimo.addKeyListener( new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e)
			{}

			@Override
			public void keyPressed(KeyEvent e) { }

			@Override
			public void keyReleased(KeyEvent e) {
				int codEmprestimo = -1;
				if(!txtCodigoEmprestimo.getText().equals("")) {
					try {
						codEmprestimo = Integer.parseInt(txtCodigoEmprestimo.getText());						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,
							    "O codigo de um emprestimo sempre é um numero.",
							    "Devolução",
							    JOptionPane.ERROR_MESSAGE);
						txtNomeLeitor.setText("");
						txtNomeLivro.setText("");
						txtlDataLimite.setText("");	
					}
					Emprestimo novo = new Emprestimo(); 
					novo = emprestimos.buscaPeloCodigo(codEmprestimo);
					
					if(novo != null) {
						txtNomeLeitor.setText(novo.getLeitor().getNome());
						txtNomeLivro.setText(novo.getLivro().getTitulo());
						txtlDataLimite.setText( emprestimos.getDataString(novo.getDataLimite()));						
					}else {
						JOptionPane.showMessageDialog(null,
							    "O codigo de emprestimo invalido, tente outro.",
							    "Devolução",
							    JOptionPane.ERROR_MESSAGE);
						txtNomeLeitor.setText("");
						txtNomeLivro.setText("");
						txtlDataLimite.setText("");	
					}
				}else {
					txtNomeLeitor.setText("");
					txtNomeLivro.setText("");
					txtlDataLimite.setText("");	
				}
				
			}
		});
	}
}
