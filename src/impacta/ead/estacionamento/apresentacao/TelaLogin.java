package impacta.ead.estacionamento.apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;

public class TelaLogin extends JFrame implements ActionListener {
	
	private JPasswordField txtSenha;
	private JPanel panel_2;
	private JRadioButton rdbtnOperacional;
	private JRadioButton rdbtnRelatorio;
	private JButton btnOk;
	
	//TODO
	public static void main(String[] args) {
		TelaLogin tela =new TelaLogin();
		tela.setVisible(true);
	}
	
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(500,150));
		setResizable(false);
		setTitle("Login");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		btnOk.setActionCommand("ok");
		panel.add(btnOk);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblSenha = new JLabel("Senha :");
		panel_2.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setColumns(20);
		panel_2.add(txtSenha);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 255, 255));
		panel_1.add(panel_3, BorderLayout.CENTER);
		
		ButtonGroup grupo = new ButtonGroup();
		rdbtnOperacional = new JRadioButton("Operacional");
		rdbtnOperacional.setSelected(true);
		rdbtnOperacional.addActionListener(this);
		rdbtnOperacional.setActionCommand("Operacional");
		
		grupo.add(rdbtnOperacional);
		panel_3.add(rdbtnOperacional);
		
		rdbtnRelatorio = new JRadioButton("Relatório");
		panel_3.add(rdbtnRelatorio);
		rdbtnRelatorio.addActionListener(this);
		rdbtnRelatorio.setActionCommand("Relatorio");
		grupo.add(rdbtnRelatorio);
		
		panel_2.setVisible(false);
		
		setLocationRelativeTo(null);
	}
/**
 * Após selecionar o button Relatorio a senha será visivel
 * Após clicar no ok a tela "TelaInicialMovimentacao será chamada"
 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		String cmd=evento.getActionCommand();
		JFrame tela= null;
		
		if(cmd.equals("Operacional")) {
			panel_2.setVisible(false);
		}else if(cmd.equals("Relatorio")) {
			txtSenha.setText(""); //LIMPA A SENHA AO TROCA PARA OPERACIONAL
			panel_2.setVisible(true);
		}else if(cmd.equals("ok")) {
			if(rdbtnOperacional.isSelected()) {
				tela= new TelaInicialMovimentacao();
				tela.setVisible(true);
			}else {
				String senha= new String(txtSenha.getPassword());
				if(senha.equals("higor")) { // SENHA 
					tela=new TelaInicialRelatorio();
					tela.setVisible(true);
				}else {// caso a senha estiver incorreta
					JOptionPane.showMessageDialog(null, "Senha Inválida","Falha Login",JOptionPane.ERROR_MESSAGE);
					txtSenha.setText("");// LIMPA A SENHA CASO ESTIVER ERRADA
					return;
					
				}
			}
			this.dispose();
		}
		
		
	}

}