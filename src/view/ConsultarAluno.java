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

import controllers.Aluno;
import controllers.Emprestimo;
import controllers.Leitor;
import controllers.Livro;
import model.Alunos;
import model.Emprestimos;
import model.Livros;
import model.Professores;

public class ConsultarAluno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTelefone;
	private JTextField txtCodigoLivro;
	private JTextField txtDoc;
	private JTextField txtEmail;
	private JTextField txtEnd;
	private JTextField txtNome;
	
	/**
	 * Create the frame.
	 */
	public ConsultarAluno( Alunos alunos) {
		setBounds(100, 100, 451, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5))	;
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(12, 688, 410, 40);
		contentPane.add(btnCancelar);
		
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        setVisible(false);
			}
		});
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTelefone.setBounds(12, 272, 410, 20);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setEditable(false);
		txtTelefone.setEnabled(false);
		txtTelefone.setBounds(12, 314, 410, 40);
		contentPane.add(txtTelefone);
		txtTelefone.setColumns(10);
		
		JLabel lblCodigoLeitor = new JLabel("Codigo Livro:");
		lblCodigoLeitor.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigoLeitor.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCodigoLeitor.setBounds(12, 64, 410, 20);
		contentPane.add(lblCodigoLeitor);
		
		txtCodigoLivro = new JTextField();
		txtCodigoLivro.setColumns(10);
		txtCodigoLivro.setBounds(12, 106, 410, 40);
		contentPane.add(txtCodigoLivro);
		
		JLabel lbltitulo = new JLabel("Consultar Aluno");
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbltitulo.setBounds(12, 22, 410, 20);
		contentPane.add(lbltitulo);
		
		txtDoc = new JTextField();
		txtDoc.setEditable(false);
		txtDoc.setEnabled(false);
		txtDoc.setColumns(10);
		txtDoc.setBounds(12, 418, 410, 40);
		contentPane.add(txtDoc);
		
		JLabel lblDoc = new JLabel("RA:");
		lblDoc.setHorizontalAlignment(SwingConstants.CENTER);
		lblDoc.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblDoc.setBounds(12, 376, 410, 20);
		contentPane.add(lblDoc);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setEnabled(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(12, 522, 410, 40);
		contentPane.add(txtEmail);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail.setBounds(12, 480, 410, 20);
		contentPane.add(lblEmail);
		
		txtEnd = new JTextField();
		txtEnd.setEditable(false);
		txtEnd.setEnabled(false);
		txtEnd.setColumns(10);
		txtEnd.setBounds(12, 626, 410, 40);
		contentPane.add(txtEnd);
		
		JLabel lblEnd = new JLabel("Endere\u00E7o:");
		lblEnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnd.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEnd.setBounds(12, 584, 410, 20);
		contentPane.add(lblEnd);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setEnabled(false);
		txtNome.setColumns(10);
		txtNome.setBounds(12, 210, 410, 40);
		contentPane.add(txtNome);
		
		JLabel lblNomeLeitor = new JLabel("Nome:");
		lblNomeLeitor.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeLeitor.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNomeLeitor.setBounds(12, 168, 410, 20);
		contentPane.add(lblNomeLeitor);
		
		
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
							    "O codigo de um aluno sempre é um numero.",
							    "Consultar",
							    JOptionPane.ERROR_MESSAGE);
						txtDoc.setText("");
						txtTelefone.setText("");
						txtEmail.setText("");
						txtEnd.setText("");
						txtNome.setText("");
					}
					Aluno novo = new Aluno(); 
					novo = (Aluno) alunos.buscaPeloCodigo(cod);
					
					if(novo != null) {
						txtDoc.setText(novo.getRA());
						txtTelefone.setText(novo.getTelefone());
						txtEmail.setText(novo.getEmail() + " ");
						txtEnd.setText(novo.getEndereco());	
						txtNome.setText(novo.getNome());
					}else {
						JOptionPane.showMessageDialog(null,
							    "O codigo de aluno invalido, tente outro.",
							    "Consultar",
							    JOptionPane.ERROR_MESSAGE);
						txtDoc.setText("");
						txtTelefone.setText("");
						txtEmail.setText("");
						txtEnd.setText("");	
						txtNome.setText("");
					}
				}else {
					txtDoc.setText("");
					txtTelefone.setText("");
					txtEmail.setText("");
					txtNome.setText("");
					txtEnd.setText("");
				}
				
			}
		});
		
	}
}
