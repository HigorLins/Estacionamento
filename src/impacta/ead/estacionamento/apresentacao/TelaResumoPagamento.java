package impacta.ead.estacionamento.apresentacao;

import javax.swing.JFrame;

import impacta.ead.estacionamento.negocio.Movimentacao;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class TelaResumoPagamento extends JFrame implements ActionListener {
	private JFrame parent;
	public TelaResumoPagamento(Movimentacao movimentacao, JFrame parent) {
		this.parent =parent;
		setResizable(false);
		setTitle("Resumo de Pagamentos");
		getContentPane().setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlaca.setBounds(114, 50, 46, 14);
		getContentPane().add(lblPlaca);
		
		JLabel lblDataEntrada = new JLabel("Entrada:");
		lblDataEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataEntrada.setBounds(114, 86, 66, 14);
		getContentPane().add(lblDataEntrada);
		
		JLabel lblDataSaida = new JLabel("Saida:");
		lblDataSaida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataSaida.setBounds(114, 126, 46, 14);
		getContentPane().add(lblDataSaida);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor.setBounds(114, 165, 46, 14);
		getContentPane().add(lblValor);
		
		JLabel lblValPlaca = new JLabel("[placa]");
		lblValPlaca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValPlaca.setBounds(223, 50, 100, 14);
		getContentPane().add(lblValPlaca);
		
		JLabel lblValDataEntrada = new JLabel("[data_entrada]");
		lblValDataEntrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValDataEntrada.setBounds(223, 86, 162, 14);
		getContentPane().add(lblValDataEntrada);
		
		JLabel lblValDataSaida = new JLabel("[data_saida]");
		lblValDataSaida.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValDataSaida.setBounds(223, 126, 128, 14);
		getContentPane().add(lblValDataSaida);
		
		JLabel lblValValor = new JLabel("[Valor]");
		lblValValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValValor.setBounds(223, 165, 100, 14);
		getContentPane().add(lblValValor);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBounds(160, 227, 89, 23);
		getContentPane().add(btnOk);
		
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		parent.setVisible(true);
	}
}
