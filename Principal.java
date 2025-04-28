package login;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Principal {

	final static ArrayList<String> cdUsuario = new ArrayList<String>();
	final static ArrayList<String> cdSenha = new ArrayList<String>();
	static ArrayList<String> cdCargo = new ArrayList<String>();
	static int contCadastro = 0;
	static int contLogin = 0;
	static int contVerificacaoLogin = 0;
	public static String comboBoxCargo[] = { "Adiministrador", "Tecnico", "Comum" };
	static String arq = "C:\\Users\\Jonas\\Desktop\\DSJava\\dadosUsuarios.txt";
	public static File bancoDeDados = new File(arq);

	public static void armazenarDadosUsuarios() {

		try {

			FileWriter escreverBanco = new FileWriter(bancoDeDados);

			for (int i = 0; i < cdUsuario.size(); i++) {
				if (i != 0) {
					escreverBanco.write(";");
				}
				escreverBanco.write(cdUsuario.get(i) + ";" + cdSenha.get(i));

			}
			escreverBanco.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void carregarDadosUsuarios() {

		Path caminhoArquivo = Paths.get(arq);
		String dados;
		try {
			dados = Files.readAllLines(caminhoArquivo).get(0);
			System.out.println(dados);
			String[] separarCadastros = dados.split(";");
			for (int i = 0; i < separarCadastros.length; i += 2) {
				cdUsuario.add(separarCadastros[i]);
				cdSenha.add(separarCadastros[i + 1]);
			}

			System.out.println("Usuario: " + cdUsuario.size() + "Senha: " + cdSenha.size());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		String JopUsuario;
		String JopSenha;
		final String administradorUsuario = "aa";
		final String administradorSenha = "bb";

		try {
			if (bancoDeDados.createNewFile()) {
				System.out.println("File creado: " + bancoDeDados.getName());
			} else {
				System.out.println("File existente");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		carregarDadosUsuarios();

		
		  do {
		  
		  JopUsuario = JOptionPane.showInputDialog("Digite o usuario:"); if (JopUsuario
		  == null) { return; } JopSenha =
		  JOptionPane.showInputDialog("Digite a senha:"); if (JopSenha == null) {
		  return; } JopUsuario = JOptionPane.showInputDialog("Digite o usuario:"); if
		  (JopUsuario == null) { return; } JopSenha =
		  JOptionPane.showInputDialog("Digite a senha:"); if (JopSenha == null) {
		  return; }
		  
		  if ((!JopUsuario.equals(administradorUsuario)) ||
		  (!JopSenha.equals(administradorSenha))) { JOptionPane.showMessageDialog(null,
		  "Usuario ou senha incorretos"); }
		  
		  } while ((!JopUsuario.equals(administradorUsuario)) ||
		  (!JopSenha.equals(administradorSenha)));
		 

		new TelaCadastro();

	}

}
