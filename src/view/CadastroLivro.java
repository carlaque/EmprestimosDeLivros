package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class CadastroLivro extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroLivro frame = new CadastroLivro();
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
	public CadastroLivro() {
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
		
		JLabel lblNovoLivro = new JLabel("Novo Livro");
		lblNovoLivro.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoLivro.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNovoLivro.setBounds(15, 16, 716, 20);
		contentPane.add(lblNovoLivro);
		
		JLabel label = new JLabel("Nome: ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 19));
		label.setBounds(15, 52, 716, 20);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(15, 88, 716, 40);
		contentPane.add(textField);
		
		JLabel lblAno = new JLabel("Ano: ");
		lblAno.setHorizontalAlignment(SwingConstants.CENTER);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblAno.setBounds(15, 144, 716, 20);
		contentPane.add(lblAno);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(15, 180, 716, 40);
		contentPane.add(textField_1);
		
		JLabel lblEscritor = new JLabel("Escritor:");
		lblEscritor.setHorizontalAlignment(SwingConstants.CENTER);
		lblEscritor.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblEscritor.setBounds(15, 236, 716, 20);
		contentPane.add(lblEscritor);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(15, 272, 716, 40);
		contentPane.add(textField_2);
		
		JLabel lblCategoria = new JLabel("Categoria:");
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblCategoria.setBounds(15, 328, 716, 30);
		contentPane.add(lblCategoria);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(15, 364, 716, 40);
		contentPane.add(comboBox);
	}
}
