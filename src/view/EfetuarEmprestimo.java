package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import controllers.Emprestimo;
import controllers.Leitor;
import controllers.Livro;
import model.Alunos;
import model.Emprestimos;
import model.Livros;
import model.Professores;

public class EfetuarEmprestimo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCodigoLeitor;
	private JTextField txtCodigoLivro;
	private JComboBox cmbCategoriaLeitor;
	
	/**
	 * Create the frame.
	 */
	public EfetuarEmprestimo(Emprestimos emprestimos, Livros livros, Alunos alunos, Professores professores) {
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
		
		JButton btnEmprestar = new JButton("Emprestar");
		btnEmprestar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
					int codLeitor = Integer.parseInt(txtCodigoLeitor.getText());
					int codLivro = Integer.parseInt(txtCodigoLivro.getText());
					Livro livro = livros.buscaPeloCodigo( codLivro );
					Leitor leitor = null;
					
					Emprestimo novo = new Emprestimo();
					
					
					if(cmbCategoriaLeitor.getSelectedIndex() == 0) 
						leitor = alunos.buscaPeloCodigo( 0 );					
					else if(cmbCategoriaLeitor.getSelectedIndex() == 1)
						leitor = professores.buscaPeloCodigo( codLeitor );
					
					
					
					boolean empr = novo.Emprestar(emprestimos.getProximoCodigo(), livro, leitor);
					try {
						if(empr)
							emprestimos.insereCadastro(novo);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
					if(empr) {
						JOptionPane.showMessageDialog(null,
							    "Emprestimo do livro " + livro.getTitulo() + " ao leitor " + leitor.getNome() + " foi feito com sucesso!",
							    "Emprestimo",
							    JOptionPane.PLAIN_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null,
							    "Não foi possivel realizar o emprestimo, por favor verifique o codigo do leitor e o codigo do livro.",
							    "Emprestimo",
							    JOptionPane.ERROR_MESSAGE);
					}
					
					
					
					txtCodigoLeitor.setText("");
				
			}
		});
		btnEmprestar.setBounds(12, 620, 410, 40);
		contentPane.add(btnEmprestar);
		
		JLabel lblCodigoAluno = new JLabel("Codigo Leitor: ");
		lblCodigoAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoAluno.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCodigoAluno.setBounds(12, 70, 410, 20);
		contentPane.add(lblCodigoAluno);
		
		txtCodigoLeitor = new JTextField();
		txtCodigoLeitor.setBounds(12, 115, 410, 40);
		contentPane.add(txtCodigoLeitor);
		txtCodigoLeitor.setColumns(10);
		
		JLabel lblCodigoLivro = new JLabel("Codigo Livro:");
		lblCodigoLivro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoLivro.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCodigoLivro.setBounds(12, 305, 410, 20);
		contentPane.add(lblCodigoLivro);
		
		txtCodigoLivro = new JTextField();
		txtCodigoLivro.setColumns(10);
		txtCodigoLivro.setBounds(12, 350, 410, 40);
		contentPane.add(txtCodigoLivro);
		
		JLabel lblEmprestimo = new JLabel("Efetuar Emprestimo");
		lblEmprestimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmprestimo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEmprestimo.setBounds(12, 25, 410, 20);
		contentPane.add(lblEmprestimo);
		
		
		String[] cat = {"alunos", "professor"};
		cmbCategoriaLeitor = new JComboBox(cat);
		cmbCategoriaLeitor.setBounds(12, 225, 410, 40);
		contentPane.add(cmbCategoriaLeitor);
		
		JLabel lblCategoria = new JLabel("Categoria do Leitor");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCategoria.setBounds(12, 180, 410, 20);
		contentPane.add(lblCategoria);
		
		
	}
}
