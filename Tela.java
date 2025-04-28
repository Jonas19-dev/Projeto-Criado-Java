package login;

import javax.swing.JOptionPane;

public class Tela {
	

	public static void main(String[] args) {
		
		String JopUsuario;
		String JopSenha;
	
			do {
			
			JopUsuario = JOptionPane.showInputDialog("Digite o usuario:");
			if(JopUsuario == null) {
				return;}
			JopSenha= JOptionPane.showInputDialog("Digite a senha:");
			if(JopSenha == null) {
				return;}
			JopUsuario = JOptionPane.showInputDialog("Digite o usuario:");
			if(JopUsuario == null) {
				return;}
			JopSenha= JOptionPane.showInputDialog("Digite a senha:");	
			if(JopSenha == null) {
				return;}
			if(!JopUsuario.equals("Admim") || !JopSenha.equals("123abc")) {
				JOptionPane.showMessageDialog(null,"Usuario ou senha incorretos");
			}
			
		}while(!JopUsuario.equals("Admim") || !JopSenha.equals("123abc"));
		
		
	}
	
	
}