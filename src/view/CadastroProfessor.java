package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controllers.Professor;
import model.Professores;

public class CadastroProfessor extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	
	/**
	 * Create the frame.
	 */
	public CadastroProfessor(final Professores professores) {
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
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Professor a = new Professor();
				a.cadastrar(professores.getProximoCodigo(), txtNome.getText(), txtEndereco.getText(), txtEmail.getText(),
						txtTelefone.getText(), "todos", txtCpf.getText(), 0);
				try {
					professores.insereCadastro(a);
					
					JOptionPane.showMessageDialog(null,
						    "Professor " + txtNome.getText() + " foi cadastrado com sucesso!",
						    "Cadastro de Professor",
						    JOptionPane.PLAIN_MESSAGE);
					txtNome.setText("");
					txtEmail.setText("");
					txtEndereco.setText("");
					txtCpf.setText("");
					txtTelefone.setText("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(12, 620, 410, 40);
		contentPane.add(btnSalvar);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNome.setBounds(12, 70, 410, 20);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setBounds(12, 115, 410, 40);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCpf.setBounds(12, 180, 410, 20);
		contentPane.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(12, 225, 410, 40);
		contentPane.add(txtCpf);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTelefone.setBounds(12, 290, 410, 20);
		contentPane.add(lblTelefone);
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		txtTelefone.setBounds(12, 335, 410, 40);
		contentPane.add(txtTelefone);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail.setBounds(12, 400, 410, 20);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(12, 445, 410, 40);
		contentPane.add(txtEmail);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(12, 555, 410, 40);
		contentPane.add(txtEndereco);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndereco.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEndereco.setBounds(12, 510, 410, 20);
		contentPane.add(lblEndereco);
		
		JLabel lblNovoProfessor = new JLabel("Novo Professor");
		lblNovoProfessor.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoProfessor.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNovoProfessor.setBounds(12, 25, 410, 20);
		contentPane.add(lblNovoProfessor);
	}
}
