 package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TelaLoginoff extends JFrame implements ActionListener {
	JLabel lblUser;
	JTextField txtUser;
	JLabel lblpass;
	JPasswordField pswPass;
	JButton btnLogin;
	JButton btnCancelar;
	JButton btnCadastro;
	Color cor = new Color(255,255,255);
	Color preto = Color.black;
	Font Fonte = new Font("Arial",Font.BOLD,15);
	Dimension dimensao = new Dimension(41,41);
	String nomeDigitado;
	String senhaDigitada;
	int acessar;
	int acessarMax;
	List<String> users = TelaCadastrooff.userList;
	List<String> pass = TelaCadastrooff.passList;
	List<String> bloq = TelaCadastrooff.bloqList;


	
	public TelaLoginoff() {
		JPanel c =  new JPanel(new GridLayout(2,2,1,1));
		JPanel bt = new JPanel(new GridLayout(1,3,1,1));
		Container principal = getContentPane();
		principal.setLayout(new BorderLayout());
		principal.add(c, BorderLayout.NORTH);
		principal.add(bt, BorderLayout.SOUTH);
		lblUser = new JLabel("Usu�rio: ");
		txtUser = new JTextField();
		lblpass = new JLabel("Senha: ");
		pswPass = new JPasswordField();
		btnLogin = new JButton("Ok");
		btnLogin.addActionListener(this);
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(v->{
			this.apagarTexto();
		});
		btnCadastro = new JButton("Cadastro");
		btnCadastro.addActionListener(this);
		c.add(lblUser);
		c.add(txtUser);
		c.add(lblpass);
		c.add(pswPass);
		bt.setLayout(new GridLayout(1,3,1,1));
		bt.add(btnLogin);
		bt.add(btnCancelar);
		bt.add(btnCadastro);
		lblUser.setBackground(cor);
		lblUser.setOpaque(true);
		txtUser.setBackground(cor);
		lblpass.setBackground(cor);
		lblpass.setOpaque(true);
		pswPass.setBackground(cor);
		btnLogin.setBackground(cor);
		btnCadastro.setBackground(cor);
		btnCancelar.setBackground(cor);
		btnLogin.setFont(Fonte);
		btnCancelar.setFont(Fonte);
		btnCadastro.setFont(Fonte);
		lblUser.setBorder(new LineBorder(preto,1));
		txtUser.setBorder(new LineBorder(preto,1));
		lblpass.setBorder(new LineBorder(preto,1));
		pswPass.setBorder(new LineBorder(preto,1));
		btnLogin.setBorder(new LineBorder(preto,1));
		btnCancelar.setBorder(new LineBorder(preto,1));
		lblUser.setPreferredSize(dimensao);
		txtUser.setPreferredSize(dimensao);
		lblpass.setPreferredSize(dimensao);
		pswPass.setPreferredSize(dimensao);
		setTitle("VIEW");
		setSize(320,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		Boolean confirmacao;
		String[] validUser = new String[2];
		String[] validPass = new String[2];
		confirmacao = false;
		
		try {
		
		while(confirmacao!=true) {
		validUser[0] = JOptionPane.showInputDialog("Digíte o nome de usuário");
		validPass[0] = JOptionPane.showInputDialog("Digíte a senha");
		validUser[1] = JOptionPane.showInputDialog("Digíte novamente o nome de usuário");
		validPass[1] = JOptionPane.showInputDialog("Digíte novamente a senha"); 
		
		if(validUser[0].isEmpty() || validPass[0].isEmpty() || validUser[1].isEmpty() || validPass[1].isEmpty()){
			JOptionPane.showMessageDialog(null,"Preencha todos os campos","Login",JOptionPane.INFORMATION_MESSAGE);
		}else
		{
			
		if(validUser[0].equals(validUser[1]) && validPass[0].equals(validPass[1])) {
				JOptionPane.showMessageDialog(null,"Dados corretos","Validação",JOptionPane.INFORMATION_MESSAGE);
				confirmacao =true;
				new TelaLoginoff();
			}else {
				JOptionPane.showMessageDialog(null,"Dados Incorretos, digíte novamente!","Validação",JOptionPane.INFORMATION_MESSAGE);
				}
			
			}
		}
	}
		
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Código Cancelado");
			return;
		}	
	}
	public void actionPerformed(ActionEvent e) {
		String botaoClicado = e.getActionCommand();
		
		if(botaoClicado == "Ok") {
			verificarOk();
		}else if(botaoClicado == "Cadastro") {
				verificarCadastro();
		}else {
			JOptionPane.showMessageDialog(null,"Opção Inválida","Validação",JOptionPane.INFORMATION_MESSAGE);
		}
		
		}
	
		public void apagarTexto() {
			txtUser.setText("");
			pswPass.setText("");
		}
	
		public void verificarOk() {
			boolean userDigitado = users.contains(txtUser.getText());
			boolean passDigitada = false;
			boolean userBloq = bloq.contains(txtUser.getText());
			int acessarMax = 3;
			int matriz = users.indexOf(txtUser.getText());
			
			try {
			
			if(txtUser.getText().isEmpty() || new String (pswPass.getPassword()).isEmpty() ) {
				JOptionPane.showMessageDialog(null,"Preencha todos os campos","Login",JOptionPane.INFORMATION_MESSAGE);
				txtUser.setText("");
				pswPass.setText("");
			}else if(pass.get(matriz).equals(new String((pswPass.getPassword())))) {
				 passDigitada = true;	
			}else
			{
				passDigitada = false;	
			}
			
			}catch(Exception e) {
				passDigitada = false;
			}
			
			if(userBloq == true) {
				JOptionPane.showMessageDialog(null,"O seu acesso está bloqueado!","Validação",JOptionPane.INFORMATION_MESSAGE);
				txtUser.setText("");
				pswPass.setText("");
			}else if(userDigitado == true && passDigitada == true) {
				JOptionPane.showMessageDialog(null,"Login Validado","Login",JOptionPane.INFORMATION_MESSAGE);
				acessar = 0;
				txtUser.setText("");
				pswPass.setText("");
			}else if(userDigitado == false) {
				JOptionPane.showMessageDialog(null,"Usuário não cadastrado, procure cadastrar e tente novamente","Login",JOptionPane.INFORMATION_MESSAGE);
				acessar = 0;
				txtUser.setText("");
				pswPass.setText("");
			}else if(userDigitado == true || passDigitada == false){
				acessar = acessar + 1;
				pswPass.setText("");
				JOptionPane.showMessageDialog(null,"Senha incorreta! Acessos restantes: " + (acessarMax - acessar),"Login", JOptionPane.INFORMATION_MESSAGE);
				if(acessar >= acessarMax) {
					TelaCadastrooff.bloqList.add(txtUser.getText());
					JOptionPane.showMessageDialog(null,"O seu acesso acabou de ser bloqueado!","Validação",JOptionPane.INFORMATION_MESSAGE);
					txtUser.setText("");
					pswPass.setText("");
					}
				}
			}
		public void verificarCadastro() {
			telaCadastro();
		}	
		
		public void telaCadastro() {
			TelaCadastrooff mostrartela = new TelaCadastrooff();
		}
		
	}



