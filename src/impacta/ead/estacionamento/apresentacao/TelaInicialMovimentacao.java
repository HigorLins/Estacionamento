package impacta.ead.estacionamento.apresentacao;

import javax.swing.JFrame;

import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicialMovimentacao extends JFrame implements ActionListener {
	
	private JButton btnEntrar;
	private JButton btnSaida;
	
	//TODO
	
	public static void main(String[] args) {
		TelaInicialMovimentacao tela = new TelaInicialMovimentacao();
		tela.setVisible(true);
	}
	
	
	public TelaInicialMovimentacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(450,300));
		setResizable(false);
		setTitle("Sistema de Estacionamento");
		getContentPane().setLayout(new GridLayout(0, 2, 0, 0));
		
		 btnEntrar = new JButton("");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEntrar.setIcon(new ImageIcon(TelaInicialMovimentacao.class.getResource("/recursos/getin.png")));
		btnEntrar.addActionListener(this);
		btnEntrar.setActionCommand("entrar");
		getContentPane().add(btnEntrar);
		
		btnSaida = new JButton("");
		btnSaida.setIcon(new ImageIcon(TelaInicialMovimentacao.class.getResource("/recursos/getout.png")));
		btnSaida.addActionListener(this);
		btnSaida.setActionCommand("saida");
		getContentPane().add(btnSaida);
		
		setLocationRelativeTo(null);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		String cmd= e.getActionCommand();
		JFrame tela = null;
		
		if(cmd.equals("entrar")) {
			tela= new TelaEntradaVeiculo(this);
		}else {
			tela= new TelaSaidaVeiculo(this);
		}
		tela.setVisible(true);
		this.setVisible(false);
	}
	

}
