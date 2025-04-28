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

public class TelaCadastro extends JFrame implements ActionListener {

	JLabel lblUmUsuario;
	JLabel lblUmSenha;
	JLabel lblDoisUsuario;
	JLabel lblDoisSenha;
	JTextField txtUmUsuario;
	JPasswordField txtUmSenha;
	JTextField txtDoisUsuario;
	JPasswordField txtDoisSenha;
	JComboBox<String> comboCargo;
	JButton btnLogar;
	JButton btnCadastrar;
	JButton btnLimpar;
	String textoUmUsuario;
	String textoUmSenha;
	String textoDoisUsuario;
	String textoDoisSenha;
	String comando;
	int cont = 0;
	int i = 0;

	public TelaCadastro() {

		lblUmUsuario = new JLabel("Digite o nome do usuario: ");
		lblUmSenha = new JLabel("Digite a senha: ");
		lblDoisUsuario = new JLabel("Digite o nome do usuario: ");
		lblDoisSenha = new JLabel("Digite a senha: ");
		txtUmUsuario = new JTextField();
		txtUmSenha = new JPasswordField();
		txtDoisUsuario = new JTextField();
		txtDoisSenha = new JPasswordField();
		btnLogar = new JButton("Logar");
		btnLogar.addActionListener(this);
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(this);
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(this);
		comboCargo = new JComboBox<>(Principal.comboBoxCargo);
		comboCargo.addActionListener(this);

		Container c = getContentPane();
		c.setLayout(new GridLayout(6, 3, 5, 5));

		c.add(lblUmUsuario);
		c.add(txtUmUsuario);
		c.add(lblDoisUsuario);
		c.add(txtDoisUsuario);
		c.add(lblUmSenha);
		c.add(txtUmSenha);
		c.add(lblDoisSenha);
		c.add(txtDoisSenha);
		c.add(btnCadastrar);
		c.add(comboCargo);
		c.add(btnLogar);
		c.add(btnLimpar);

		setVisible(true);
		setTitle("View");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnLogar.setActionCommand("Logar");
		btnLimpar.setActionCommand("Limpar");
		btnCadastrar.setActionCommand("Cadastrar");

		txtUmSenha.setEnabled(false);
		txtDoisSenha.setEnabled(false);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		comando = e.getActionCommand();

		textoUmUsuario = txtUmUsuario.getText();
		textoUmSenha = txtUmSenha.getText();
		textoDoisUsuario = txtDoisUsuario.getText();
		textoDoisSenha = txtDoisSenha.getText();

		String opcaoSelecionada = (String) comboCargo.getSelectedItem();
		System.out.println("\nCadastro " + opcaoSelecionada);
		System.out.println(Principal.cdUsuario + opcaoSelecionada);

		if ("Logar".equals(comando)) {
			new TelaLogin();
			dispose();
		}

		if ("Limpar".equals(comando)) {
			txtUmUsuario.setText("");
			txtUmSenha.setText("");
			txtDoisUsuario.setText("");
			txtDoisSenha.setText("");
		}

		if ("Cadastrar".equals(comando)) {
			if (textoUmUsuario.equals("") || textoDoisUsuario.equals("")) {
				JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Campo Vazio",
						JOptionPane.INFORMATION_MESSAGE);
				System.out.println("Primeiro if");

			} else if (textoUmUsuario.equals(textoDoisUsuario)) {
				System.out.println("Segundo if");

				if (opcaoSelecionada.equals("Adiministrador") || Principal.contCadastro == 1) {

					System.out.println("Setimo if");

					if ((!Principal.cdUsuario.contains(textoUmUsuario + opcaoSelecionada))) {
						// ((Principal.cdCargo == null) ||

						txtUmSenha.setEnabled(true);
						txtDoisSenha.setEnabled(true);
						System.out.println("Terceiro if");

						if (!(textoUmSenha.equals("")) && (!(textoDoisSenha.equals("")))) {
							System.out.println("Quarto if");
							if(textoUmSenha.equals(textoDoisSenha)){ 
							
									if (Principal.contCadastro == 0) {
								System.out.println("Sexta if");

								if (textoUmSenha.equals("")) {
									JOptionPane.showMessageDialog(null, "Digite uma senha", "Erro",
											JOptionPane.INFORMATION_MESSAGE);

								} else {
									Principal.cdUsuario.add(textoUmUsuario + opcaoSelecionada);
									Principal.cdSenha.add(textoUmSenha);
									System.out.println("Primeiro else Cadastrado");
									// primeiro usuario cadastrado
									Principal.contCadastro = 1;
									System.out.println("Contando" + Principal.contCadastro);
									System.out.println("Oitavo if");
									System.out.println("Usuario cadastrado:" + Principal.cdUsuario.get(i));
									i++;
									JOptionPane.showMessageDialog(null, "Cadastro Realizado", "Sucesso",
											JOptionPane.INFORMATION_MESSAGE);
									txtUmUsuario.setText("");
									txtUmSenha.setText("");
									txtDoisUsuario.setText("");
									txtDoisSenha.setText("");
									txtUmSenha.setEnabled(false);
									txtDoisSenha.setEnabled(false);

								}
							} else if (Principal.contCadastro == 1) {

								Principal.cdUsuario.add(textoUmUsuario + opcaoSelecionada);
								Principal.cdSenha.add(textoUmSenha);
								System.out.println("Cadastrado  Segundo else ");
								// primeiro usuario cadastrado
								Principal.contCadastro = 1;
								System.out.println("Contando" + Principal.contCadastro);
								System.out.println("Nonu if");
								System.out.println("Usuario cadastrado:" + Principal.cdUsuario.get(i));
								i++;
								JOptionPane.showMessageDialog(null, "Cadastro Realizado", "Sucesso",
										JOptionPane.INFORMATION_MESSAGE);
								txtUmUsuario.setText("");
								txtUmSenha.setText("");
								txtDoisUsuario.setText("");
								txtDoisSenha.setText("");
								txtUmSenha.setEnabled(false);
								txtDoisSenha.setEnabled(false);
							}
						}else {
							JOptionPane.showMessageDialog(null, " Senhas diferentes digitadas");
							txtUmUsuario.setText("");
							txtUmSenha.setText("");
							txtDoisUsuario.setText("");
							txtDoisSenha.setText("");
							txtUmSenha.setEnabled(false);
							txtDoisSenha.setEnabled(false);
						}
							} 

					} else {
						JOptionPane.showMessageDialog(null, "Usuario já cadastrado");
						txtUmUsuario.setText("");
						txtUmSenha.setText("");
						txtDoisUsuario.setText("");
						txtDoisSenha.setText("");
						txtUmSenha.setEnabled(false);
						txtDoisSenha.setEnabled(false);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Primeiro usuario deve ser administrador", "Erro",
							JOptionPane.INFORMATION_MESSAGE);
					txtUmUsuario.setText("");
					txtUmSenha.setText("");
					txtDoisUsuario.setText("");
					txtDoisSenha.setText("");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Usuarios diferentes digitados");
				txtUmUsuario.setText("");
				txtUmSenha.setText("");
				txtDoisUsuario.setText("");
				txtDoisSenha.setText("");
				txtUmSenha.setEnabled(false);
				txtDoisSenha.setEnabled(false);
			}
		}
		
		Principal.armazenarDadosUsuarios();
		System.out.println("Contando  " + Principal.contCadastro);

	}

}
