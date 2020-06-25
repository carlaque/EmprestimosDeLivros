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

import controllers.Emprestimo;
import controllers.Leitor;
import controllers.Livro;
import model.Alunos;
import model.Emprestimos;
import model.Livros;
import model.Professores;

public class ConsultarLivro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNomeLivro;
	private JTextField txtCodigoLivro;
	private JTextField txtAutor;
	private JTextField txtQtd;
	private JTextField txtCategoria;
	private JTextField txtISBN;
	
	/**
	 * Create the frame.
	 */
	public ConsultarLivro( Livros livros) {
		setBounds(100, 100, 451, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5))	;
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setEnabled(false);
		btnCancelar.setBounds(12, 688, 410, 40);
		contentPane.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        setVisible(false);
			}
		});
		
		JLabel lblCodigoAluno = new JLabel("Nome Livro:");
		lblCodigoAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoAluno.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCodigoAluno.setBounds(12, 272, 410, 20);
		contentPane.add(lblCodigoAluno);
		
		txtNomeLivro = new JTextField();
		txtNomeLivro.setEnabled(false);
		txtNomeLivro.setBounds(12, 314, 410, 40);
		contentPane.add(txtNomeLivro);
		txtNomeLivro.setColumns(10);
		
		JLabel lblCodigoLivro = new JLabel("Codigo Livro:");
		lblCodigoLivro.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoLivro.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCodigoLivro.setBounds(12, 64, 410, 20);
		contentPane.add(lblCodigoLivro);
		
		txtCodigoLivro = new JTextField();
		txtCodigoLivro.setColumns(10);
		txtCodigoLivro.setBounds(12, 106, 410, 40);
		contentPane.add(txtCodigoLivro);
		
		JLabel lbltitulo = new JLabel("Consultar Livro");
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbltitulo.setBounds(12, 22, 410, 20);
		contentPane.add(lbltitulo);
		
		txtAutor = new JTextField();
		txtAutor.setEnabled(false);
		txtAutor.setColumns(10);
		txtAutor.setBounds(12, 418, 410, 40);
		contentPane.add(txtAutor);
		
		JLabel lblCodigoAluno_1 = new JLabel("Autor:");
		lblCodigoAluno_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoAluno_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCodigoAluno_1.setBounds(12, 376, 410, 20);
		contentPane.add(lblCodigoAluno_1);
		
		txtQtd = new JTextField();
		txtQtd.setEnabled(false);
		txtQtd.setColumns(10);
		txtQtd.setBounds(12, 522, 410, 40);
		contentPane.add(txtQtd);
		
		JLabel lblCodigoAluno_1_1 = new JLabel("Quantidade");
		lblCodigoAluno_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoAluno_1_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCodigoAluno_1_1.setBounds(12, 480, 410, 20);
		contentPane.add(lblCodigoAluno_1_1);
		
		txtCategoria = new JTextField();
		txtCategoria.setEnabled(false);
		txtCategoria.setColumns(10);
		txtCategoria.setBounds(12, 626, 410, 40);
		contentPane.add(txtCategoria);
		
		JLabel lblCategoria = new JLabel("Categoria");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCategoria.setBounds(12, 584, 410, 20);
		contentPane.add(lblCategoria);
		
		txtISBN = new JTextField();
		txtISBN.setEnabled(false);
		txtISBN.setColumns(10);
		txtISBN.setBounds(12, 210, 410, 40);
		contentPane.add(txtISBN);
		
		JLabel lblCodigoAluno_2 = new JLabel("ISBN:");
		lblCodigoAluno_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoAluno_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCodigoAluno_2.setBounds(12, 168, 410, 20);
		contentPane.add(lblCodigoAluno_2);
		
		
		txtCodigoLivro.addKeyListener( new KeyListener(){
			@Override
			public void keyTyped(KeyEvent e)
			{}

			@Override
			public void keyPressed(KeyEvent e) { }

			@Override
			public void keyReleased(KeyEvent e) {
				int cod = -1;
				if(!txtCodigoLivro.getText().equals("")) {
					try {
						cod = Integer.parseInt(txtCodigoLivro.getText());						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null,
							    "O codigo de um emprestimo sempre é um numero.",
							    "Consultar",
							    JOptionPane.ERROR_MESSAGE);
						txtAutor.setText("");
						txtNomeLivro.setText("");
						txtQtd.setText("");
						txtCategoria.setText("");
						txtISBN.setText("");
					}
					Livro novo = new Livro(); 
					novo = livros.buscaPeloCodigo(cod);
					
					if(novo != null) {
						txtAutor.setText(novo.getAutor());
						txtNomeLivro.setText(novo.getTitulo());
						txtQtd.setText(novo.getQuantidade() + " ");
						txtCategoria.setText(novo.getCategoria());	
						txtISBN.setText(novo.getISBN());
					}else {
						JOptionPane.showMessageDialog(null,
							    "O codigo de emprestimo invalido, tente outro.",
							    "Consultar",
							    JOptionPane.ERROR_MESSAGE);
						txtAutor.setText("");
						txtNomeLivro.setText("");
						txtQtd.setText("");
						txtCategoria.setText("");	
						txtISBN.setText("");
					}
				}else {
					txtAutor.setText("");
					txtNomeLivro.setText("");
					txtQtd.setText("");
					txtISBN.setText("");
					txtCategoria.setText("");
				}
				
			}
		});
		
	}
}
