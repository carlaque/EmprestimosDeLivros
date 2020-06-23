package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class CadastroAluno extends JFrame {

	private JPanel contentPane;
	private JTextField txtFldNomeAluno;
	private JTextField txtFieldRA;
	private JTextField txtFieldTelefoneAluno;
	private JTextField txtFieldEmailAluno;
	private JTextField txtFieldEnderecoAluno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAluno frame = new CadastroAluno();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastroAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 744);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Cancelar");
		btnNewButton.setBounds(15, 632, 716, 40);
		contentPane.add(btnNewButton);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSalvar.setBounds(15, 576, 716, 40);
		contentPane.add(btnSalvar);
		
		JLabel label = new JLabel("Nome: ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setBounds(15, 81, 716, 20);
		contentPane.add(label);
		
		txtFldNomeAluno = new JTextField();
		txtFldNomeAluno.setBounds(15, 117, 716, 40);
		contentPane.add(txtFldNomeAluno);
		txtFldNomeAluno.setColumns(10);
		
		JLabel lblRa = new JLabel("RA:");
		lblRa.setHorizontalAlignment(SwingConstants.CENTER);
		lblRa.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblRa.setBounds(15, 172, 716, 20);
		contentPane.add(lblRa);
		
		txtFieldRA = new JTextField();
		txtFieldRA.setColumns(10);
		txtFieldRA.setBounds(15, 208, 716, 40);
		contentPane.add(txtFieldRA);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblTelefone.setBounds(15, 264, 716, 20);
		contentPane.add(lblTelefone);
		
		txtFieldTelefoneAluno = new JTextField();
		txtFieldTelefoneAluno.setColumns(10);
		txtFieldTelefoneAluno.setBounds(15, 300, 716, 40);
		contentPane.add(txtFieldTelefoneAluno);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail.setBounds(15, 356, 716, 20);
		contentPane.add(lblEmail);
		
		txtFieldEmailAluno = new JTextField();
		txtFieldEmailAluno.setColumns(10);
		txtFieldEmailAluno.setBounds(15, 392, 716, 40);
		contentPane.add(txtFieldEmailAluno);
		
		txtFieldEnderecoAluno = new JTextField();
		txtFieldEnderecoAluno.setColumns(10);
		txtFieldEnderecoAluno.setBounds(15, 490, 716, 40);
		contentPane.add(txtFieldEnderecoAluno);
		
		JLabel lblEmail_1 = new JLabel("Endere\u00E7o:");
		lblEmail_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEmail_1.setBounds(15, 454, 716, 20);
		contentPane.add(lblEmail_1);
		
		JLabel lblNovoAluno = new JLabel("Novo Aluno");
		lblNovoAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoAluno.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNovoAluno.setBounds(15, 16, 716, 20);
		contentPane.add(lblNovoAluno);
	}
}
