package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ValidarCpf;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class View extends JFrame {

	private JPanel contentPane;
	private JTextField txtCpf;
	private JTextField txtCpfFormatado;
	private JLabel lblVerificado;
	private JButton btnOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View frame = new View();
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
	public View() {
		setResizable(false);
		setTitle("Validador de CPF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 545, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCpf.setBounds(28, 85, 299, 29);
		panel.add(txtCpf);
		txtCpf.setColumns(10);

		JLabel lblNewLabel = new JLabel("CPF:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(28, 63, 63, 22);
		panel.add(lblNewLabel);

		txtCpfFormatado = new JTextField();
		txtCpfFormatado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCpfFormatado.setEditable(false);
		txtCpfFormatado.setBounds(28, 198, 299, 29);
		panel.add(txtCpfFormatado);
		txtCpfFormatado.setColumns(10);

		lblVerificado = new JLabel("");
		lblVerificado.setForeground(Color.GREEN);
		lblVerificado.setBackground(Color.WHITE);
		lblVerificado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVerificado.setBounds(351, 198, 141, 29);
		panel.add(lblVerificado);

		JButton btnConferir = new JButton("VALIDAR");
		btnConferir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ValidarCpf validarCpf = new ValidarCpf();
				StringBuilder cpf = new StringBuilder(txtCpf.getText());

				if (cpf.length() < 11 || cpf.length() > 11) {
					JOptionPane.showMessageDialog(null, "Caracteres invalidos \n-Digite apenas números \n-Sem pontuação");
				} else {

					validarCpf.cadastrarVariavel(txtCpf);
					if (validarCpf.validarCpf()) {
						lblVerificado.setText("CPF Valido");
						lblVerificado.setForeground(new Color(40, 122, 35));
					} else {
						lblVerificado.setText("CPF Invalido");
						lblVerificado.setForeground(Color.RED);
					}

					cpf.insert(3, ".");
					cpf.insert(7, ".");
					cpf.insert(11, "-");

					txtCpfFormatado.setText(cpf.toString());
				}

			}
		});
		btnConferir.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConferir.setBounds(351, 85, 141, 29);
		panel.add(btnConferir);

		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCpf.setText("");
				lblVerificado.setText("");
				txtCpfFormatado.setText("");
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnOk.setBounds(186, 270, 141, 29);
		panel.add(btnOk);

	}
}
