package login;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin extends JFrame implements ActionListener {

	JLabel lblUsuario;
	JLabel lblSenha;
	JTextField txtUsuario;
	JPasswordField txtSenha;
	JButton btnLogar;
	JButton btnCadastrar;
	JButton btnLimpar;
	String textoUsuario;
	String textoSenha;
	String comando;
	int tentativas = 0;

	public TelaLogin() {

		lblUsuario = new JLabel("Digite o nome do usuario: ");
		lblSenha = new JLabel("Digite a senha: ");
		txtUsuario = new JTextField();
		txtSenha = new JPasswordField();
		btnLogar = new JButton("Logar");
		btnLogar.addActionListener(this);
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(this);
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(this);

		Container c = getContentPane();
		c.setLayout(new GridLayout(5, 3, 5, 5));

		c.add(lblUsuario);
		c.add(txtUsuario);
		c.add(lblSenha);
		c.add(txtSenha);
		c.add(btnLogar);
		c.add(btnLimpar);
		c.add(btnCadastrar);

		setVisible(true);
		setTitle("View");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnLogar.setActionCommand("Logar");
		btnLimpar.setActionCommand("Cancelar");
		btnCadastrar.setActionCommand("Cadastrar");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {

		comando = e.getActionCommand();

		textoUsuario = txtUsuario.getText();
		textoSenha = txtSenha.getText();

		if ("Cadastrar".equals(comando)) {
			new TelaCadastro();
			dispose();
		}

		if (Principal.contVerificacaoLogin < 3) {
			if ("Logar".equals(comando)) {

				if (Principal.cdUsuario.contains(textoUsuario + "Adiministrador") || Principal.contLogin == 1) {

					if ((Principal.cdUsuario.contains(textoUsuario + "Adiministrador")
							|| Principal.cdUsuario.contains(textoUsuario + "Tecnico")
							|| Principal.cdUsuario.contains(textoUsuario + "Comum"))
							&& Principal.cdSenha.contains(textoSenha)) {
						JOptionPane.showMessageDialog(null, "Login validado!", "Login",
								JOptionPane.INFORMATION_MESSAGE);
						Principal.contVerificacaoLogin = 0;
						Principal.contLogin = 1;

					} else if (textoUsuario.equals("") || textoSenha.equals("")) {
						JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Campo Vazio",
								JOptionPane.INFORMATION_MESSAGE);
						Principal.contVerificacaoLogin++;
					} else {
						Principal.contVerificacaoLogin++;
						tentativas = 3 - Principal.contVerificacaoLogin;
						JOptionPane.showMessageDialog(null, "Login inválido! Restam " + tentativas + " tentativa(s).",
								"Login", JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Primeiro usuario deve ser administrador", "Erro",
							JOptionPane.INFORMATION_MESSAGE);
					Principal.contVerificacaoLogin++;
					tentativas = 3 - Principal.contVerificacaoLogin;
					JOptionPane.showMessageDialog(null, "Login inválido! Restam " + tentativas + " tentativa(s).",
							"Login", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}

		if (Principal.contVerificacaoLogin >= 3) {
			JOptionPane.showMessageDialog(null, "Usuário bloqueado após 3 tentativas!", "Login Bloqueado",
					JOptionPane.ERROR_MESSAGE);
			txtUsuario.setEnabled(false);
			txtSenha.setEnabled(false);

		} else if ("Cancelar".equals(comando)) {

		}
		txtUsuario.setText("");
		txtSenha.setText("");

	}
}
