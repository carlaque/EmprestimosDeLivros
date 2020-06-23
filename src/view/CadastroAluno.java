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

import controllers.Aluno;
import model.Alunos;

public class CadastroAluno extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFldNomeAluno;
	private JTextField txtFieldRA;
	private JTextField txtFieldTelefoneAluno;
	private JTextField txtFieldEmailAluno;
	private JTextField txtFieldEnderecoAluno;
	
	/**
	 * Create the frame.
	 */
	public CadastroAluno(Alunos alunos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        setVisible(false);
			}
		});
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno a = new Aluno();
				a.cadastrar(alunos.getProximoCodigo(), txtFldNomeAluno.getText(), txtFieldEnderecoAluno.getText(), txtFieldEmailAluno.getText(),
						txtFieldTelefoneAluno.getText(), "todos", txtFieldRA.getText(), 0);
				try {
					alunos.insereCadastro(a);
					
					JOptionPane.showMessageDialog(null,
						    "Aluno " + txtFldNomeAluno.getText() + " foi cadastrado com sucesso!",
						    "Cadastro de Aluno",
						    JOptionPane.PLAIN_MESSAGE);
					txtFldNomeAluno.setText("");
					txtFieldEmailAluno.setText("");
					txtFieldEnderecoAluno.setText("");
					txtFieldRA.setText("");
					txtFieldTelefoneAluno.setText("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(12, 620, 410, 40);
		contentPane.add(btnSalvar);
		
		JLabel label = new JLabel("Nome: ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setBounds(12, 70, 410, 20);
		contentPane.add(label);
		
		txtFldNomeAluno = new JTextField();
		txtFldNomeAluno.setBounds(12, 115, 410, 40);
		contentPane.add(txtFldNomeAluno);
		txtFldNomeAluno.setColumns(10);
		
		JLabel lblRa = new JLabel("RA:");
		lblRa.setHorizontalAlignment(SwingConstants.CENTER);
		lblRa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblRa.setBounds(12, 180, 410, 20);
		contentPane.add(lblRa);
		
		txtFieldRA = new JTextField();
		txtFieldRA.setColumns(10);
		txtFieldRA.setBounds(12, 225, 410, 40);
		contentPane.add(txtFieldRA);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTelefone.setBounds(12, 290, 410, 20);
		contentPane.add(lblTelefone);
		
		txtFieldTelefoneAluno = new JTextField();
		txtFieldTelefoneAluno.setColumns(10);
		txtFieldTelefoneAluno.setBounds(12, 335, 410, 40);
		contentPane.add(txtFieldTelefoneAluno);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail.setBounds(12, 400, 410, 20);
		contentPane.add(lblEmail);
		
		txtFieldEmailAluno = new JTextField();
		txtFieldEmailAluno.setColumns(10);
		txtFieldEmailAluno.setBounds(12, 445, 410, 40);
		contentPane.add(txtFieldEmailAluno);
		
		txtFieldEnderecoAluno = new JTextField();
		txtFieldEnderecoAluno.setColumns(10);
		txtFieldEnderecoAluno.setBounds(12, 555, 410, 40);
		contentPane.add(txtFieldEnderecoAluno);
		
		JLabel lblEmail_1 = new JLabel("Endere\u00E7o:");
		lblEmail_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail_1.setBounds(12, 510, 410, 20);
		contentPane.add(lblEmail_1);
		
		JLabel lblNovoAluno = new JLabel("Novo Aluno");
		lblNovoAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoAluno.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNovoAluno.setBounds(12, 25, 410, 20);
		contentPane.add(lblNovoAluno);
	}
}
