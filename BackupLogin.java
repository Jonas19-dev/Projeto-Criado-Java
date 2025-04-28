/*
 * package login;
 * 
 * package login;
 * 
 * import java.awt.Container; import java.awt.GridLayout; import
 * java.awt.event.ActionEvent; import java.awt.event.ActionListener;
 * 
 * import javax.swing.JButton; import javax.swing.JFrame; import
 * javax.swing.JLabel; import javax.swing.JOptionPane; import
 * javax.swing.JPasswordField; import javax.swing.JTextField;
 * 
 * public class TelaLogin extends JFrame implements ActionListener {
 * 
 * JLabel lblUsuario; JLabel lblSenha; JTextField txtUsuario; JPasswordField
 * txtSenha; JButton btnOk; JButton btnLimpar; String textoUsuario; String
 * textoSenha; String comando; int cont = 0, tentativas = 0;
 * 
 * public TelaLogin() {
 * 
 * lblUsuario = new JLabel("Digite o nome do usuario: "); lblSenha = new
 * JLabel("Digite a senha: "); txtUsuario = new JTextField(); txtSenha = new
 * JPasswordField(); btnLogar = new JButton("Ok");
 * btnLogar.addActionListener(this); btnLimpar = new JButton("Limpar");
 * btnLimpar.addActionListener(this);
 * 
 * Container c = getContentPane(); c.setLayout(new GridLayout(5, 3, 5, 5));
 * 
 * c.add(lblUsuario); c.add(txtUsuario); c.add(lblSenha); c.add(txtSenha);
 * c.add(btnLogar); c.add(btnLimpar);
 * 
 * setVisible(true); setTitle("View"); setSize(600, 400);
 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 * 
 * btnLogar.setActionCommand("Ok"); btnLimpar.setActionCommand("Limpar");
 * 
 * }
 * 
 * public static void main(String[] args) {
 * 
 * String JopUsuario; String JopSenha;
 * 
 * do {
 * 
 * JopUsuario = JOptionPane.showInputDialog("Digite o usuario:"); if (JopUsuario
 * == null) { return; } JopSenha =
 * JOptionPane.showInputDialog("Digite a senha:"); if (JopSenha == null) {
 * return; } JopUsuario = JOptionPane.showInputDialog("Digite o usuario:"); if
 * (JopUsuario == null) { return; } JopSenha =
 * JOptionPane.showInputDialog("Digite a senha:"); if (JopSenha == null) {
 * return; } if (!JopUsuario.equals("Admim") || !JopSenha.equals("123abc")) {
 * JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos"); }
 * 
 * } while (!JopUsuario.equals("Admim") || !JopSenha.equals("123abc"));
 * 
 * new TelaLogin(); }
 * 
 * @SuppressWarnings("deprecation")
 * 
 * @Override public void actionPerformed(ActionEvent e) {
 * 
 * comando = e.getActionCommand();
 * 
 * textoUsuario = txtUsuario.getText(); textoSenha = txtSenha.getText();
 * 
 * if (cont < 3) { if ("Ok".equals(comando)) {
 * 
 * if (textoUsuario.equals("Admim") && textoSenha.equals("123abc")) {
 * JOptionPane.showMessageDialog(null, "Login validado!", "Login",
 * JOptionPane.INFORMATION_MESSAGE); cont = 0;
 * 
 * } else if (textoUsuario.equals("") || textoSenha.equals("")) {
 * JOptionPane.showMessageDialog(null, "Preencha todos os campos",
 * "Campo Vazio", JOptionPane.INFORMATION_MESSAGE); } else { cont++; tentativas
 * = 3 - cont; JOptionPane.showMessageDialog(null, "Login inválido! Restam " +
 * tentativas + " tentativa(s).", "Login", JOptionPane.INFORMATION_MESSAGE); } }
 * }
 * 
 * if (cont >= 3) { JOptionPane.showMessageDialog(null,
 * "Usuário bloqueado após 3 tentativas!", "Login Bloqueado",
 * JOptionPane.ERROR_MESSAGE); txtUsuario.setEnabled(false);
 * txtSenha.setEnabled(false);
 * 
 * } else if ("Cancelar".equals(comando)) {
 * 
 * } txtUsuario.setText(""); txtSenha.setText("");
 * 
 * } }
 */