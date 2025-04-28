package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.PasswordAuthentication;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class TelaCadastrooff extends JFrame implements ActionListener {	
	JLabel lblUser;
	JTextField txtUser;
	JLabel lblpass;
	JPasswordField pswPass;
	JButton btnLogar;
	JButton btnLimpar;
	JButton btnCadastrar;
	Color cor = new Color(255,255,255);
	Color preto = Color.black;
	Font Fonte = new Font("Arial",Font.BOLD,13);
	Dimension dimensao = new Dimension(41,41);
	public final static  List<String> userList = new ArrayList<String>();
	public final static  List<String> passList = new ArrayList<String>();
	public final static  List<String> bloqList = new ArrayList<String>();
	
	public  TelaCadastrooff() {
		JPanel c =  new JPanel(new GridLayout(2,2,1,1));
		JPanel bt = new JPanel(new GridLayout(1,3,1,1));
		Container principal = getContentPane();
		principal.setLayout(new BorderLayout());
		principal.add(c, BorderLayout.NORTH);
		principal.add(bt, BorderLayout.SOUTH);
		lblUser = new JLabel("Usuario: ");
		txtUser = new JTextField();
		lblpass = new JLabel("Senha: ");
		pswPass = new JPasswordField();
		btnLogar = new JButton("Logar");
		btnLogar.addActionListener(this);
		btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(v->{
			this.apagarTexto();
		});
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(this);
		c.add(lblUser);
		c.add(txtUser);
		c.add(lblpass);
		c.add(pswPass);
		bt.setLayout(new GridLayout(1,3,1,1));
		bt.add(btnLogar);
		bt.add(btnLimpar);
		bt.add(btnCadastrar);
		lblUser.setBackground(cor);
		lblUser.setOpaque(true);
		txtUser.setBackground(cor);
		lblpass.setBackground(cor);
		lblpass.setOpaque(true);
		pswPass.setBackground(cor);
		btnLogar.setBackground(cor);
		btnCadastrar.setBackground(cor);
		btnLimpar.setBackground(cor);
		btnLogar.setFont(Fonte);
		btnLimpar.setFont(Fonte);
		btnCadastrar.setFont(Fonte);
		lblUser.setBorder(new LineBorder(preto,1));
		txtUser.setBorder(new LineBorder(preto,1));
		lblpass.setBorder(new LineBorder(preto,1));
		pswPass.setBorder(new LineBorder(preto,1));
		btnLogar.setBorder(new LineBorder(preto,1));
		btnLimpar.setBorder(new LineBorder(preto,1));
		lblUser.setPreferredSize(dimensao);
		txtUser.setPreferredSize(dimensao);
		lblpass.setPreferredSize(dimensao);
		pswPass.setPreferredSize(dimensao);
		setTitle("VIEW");
		setSize(320,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
		
	
	public void actionPerformed(ActionEvent e) {
		String botaoClicado = e.getActionCommand();
		
		if(botaoClicado == "Logar") {
			logar();
		}else if(botaoClicado == "Cadastrar") {
				cadastrar();
		}else {
			JOptionPane.showMessageDialog(null,"Opção Inválida","Validação",JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void cadastrar() {
		String text = txtUser.getText();
		if(text.isEmpty() || new String (pswPass.getPassword()).isEmpty() ) {
			JOptionPane.showMessageDialog(null,"Preencha todos os campos","Cadastro",JOptionPane.INFORMATION_MESSAGE);
			txtUser.setText("");
			pswPass.setText("");
		} else if (bloqList.contains(text) == true) {
				JOptionPane.showMessageDialog(null,"O seu acesso está bloqueado!","Validação",JOptionPane.INFORMATION_MESSAGE);
				txtUser.setText("");
				pswPass.setText("");
		} else if(userList.contains(text) == true) {
				JOptionPane.showMessageDialog(null,"O usuário já possui cadastro, altere o nome do mesmo","Validação",JOptionPane.INFORMATION_MESSAGE);
				txtUser.setText("");
				pswPass.setText("");
		}else {
				userList.add(text);
				passList.add(new String(pswPass.getPassword()));
				JOptionPane.showMessageDialog(null,"Dados cadastrado","Validação",JOptionPane.INFORMATION_MESSAGE);
				txtUser.setText("");
				pswPass.setText("");
			}
		}
		
	
	public void logar() {
		TelaLoginoff telaLogin = new TelaLoginoff();
	}
	
	public void apagarTexto() {
		txtUser.setText("");
		pswPass.setText("");
	}
	
	
	


}
