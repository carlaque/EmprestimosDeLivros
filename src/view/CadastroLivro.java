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

import controllers.Livro;
import model.Livros;

public class CadastroLivro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtISBN;
	private JTextField txtAutor;
	private JTextField txtQuant;
	private JComboBox cmbCategoria;

	/**
	 * Create the frame.
	 */
	public CadastroLivro(Livros livros) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(12, 695, 409, 40);
		contentPane.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        setVisible(false);
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(12, 630, 409, 40);
		contentPane.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cat = cmbCategoria.getSelectedItem().toString();
				Livro livro = new Livro();
				livro.cadastrar(livros.getProximoCodigo(), txtNome.getText(), txtAutor.getText(), txtISBN.getText(), cat , 
						Integer.parseInt(txtQuant.getText()));
				try {
					livros.insereCadastro(livro);
					
					JOptionPane.showMessageDialog(null,
						    "Livro '" + txtNome.getText() + "' foi cadastrado com sucesso!",
						    "Cadastro de Aluno",
						    JOptionPane.PLAIN_MESSAGE);
					
					txtNome.setText("");
					txtAutor.setText("");
					txtISBN.setText("");
					txtQuant.setText("");
					cmbCategoria.setSelectedIndex(0);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		JLabel lblNovoLivro = new JLabel("Novo Livro");
		lblNovoLivro.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoLivro.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNovoLivro.setBounds(12, 25, 409, 20);
		contentPane.add(lblNovoLivro);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNome.setBounds(12, 70, 409, 20);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(12, 115, 409, 40);
		contentPane.add(txtNome);
		
		JLabel lblAno = new JLabel("ISBN:");
		lblAno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAno.setBounds(12, 290, 409, 20);
		contentPane.add(lblAno);
		
		txtISBN = new JTextField();
		txtISBN.setColumns(10);
		txtISBN.setBounds(12, 335, 409, 40);
		contentPane.add(txtISBN);
		
		JLabel lblEscritor = new JLabel("Escritor:");
		lblEscritor.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscritor.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEscritor.setBounds(12, 180, 409, 20);
		contentPane.add(lblEscritor);
		
		txtAutor = new JTextField();
		txtAutor.setColumns(10);
		txtAutor.setBounds(12, 225, 409, 40);
		contentPane.add(txtAutor);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCategoria.setBounds(12, 510, 409, 30);
		contentPane.add(lblCategoria);
		
		String[] categorias = { "todos", "professor" };
		cmbCategoria = new JComboBox(categorias);
		cmbCategoria.setBounds(12, 565, 409, 40);
		contentPane.add(cmbCategoria);
		
		txtQuant = new JTextField();
		txtQuant.setColumns(10);
		txtQuant.setBounds(12, 445, 409, 40);
		contentPane.add(txtQuant);
		
		JLabel lblQuant = new JLabel("Quantidade de exemplares:");
		lblQuant.setHorizontalAlignment(SwingConstants.CENTER);
		lblQuant.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblQuant.setBounds(12, 400, 409, 20);
		contentPane.add(lblQuant);
	}
}
