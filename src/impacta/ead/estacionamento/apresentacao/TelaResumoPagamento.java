package impacta.ead.estacionamento.apresentacao;

import javax.swing.JFrame;

import impacta.ead.estacionamento.negocio.Movimentacao;
import impacta.ead.estacionamento.ultilitario.EstacionamentoUtil;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class TelaResumoPagamento extends JFrame implements ActionListener {
	private JFrame parent;
	public TelaResumoPagamento(Movimentacao movimentacao, JFrame parent) {
		this.parent =parent;
		setSize(new Dimension(430,300));
		setResizable(false);
		setTitle("Resumo de Pagamentos");
		getContentPane().setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlaca.setBounds(87, 50, 46, 14);
		getContentPane().add(lblPlaca);
		
		JLabel lblDataEntrada = new JLabel("Entrada:");
		lblDataEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataEntrada.setBounds(87, 86, 66, 14);
		getContentPane().add(lblDataEntrada);
		
		JLabel lblDataSaida = new JLabel("Saida:");
		lblDataSaida.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataSaida.setBounds(87, 126, 46, 14);
		getContentPane().add(lblDataSaida);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor.setBounds(87, 165, 46, 14);
		getContentPane().add(lblValor);
		
		String sPlaca =movimentacao.getVeiculo().getPlaca();
		JLabel lblValPlaca = new JLabel(sPlaca);
		lblValPlaca.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValPlaca.setBounds(223, 50, 100, 14);
		getContentPane().add(lblValPlaca);
		
		String sEntrada =EstacionamentoUtil.getDisplayData(movimentacao.getDataHoraEntrada());
		JLabel lblValDataEntrada = new JLabel(sEntrada);
		lblValDataEntrada.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValDataEntrada.setBounds(223, 86, 162, 14);
		getContentPane().add(lblValDataEntrada);
		
		String sSaida =EstacionamentoUtil.getDisplayData(movimentacao.getDataHoraSaida());
		JLabel lblValDataSaida = new JLabel(sSaida);
		lblValDataSaida.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValDataSaida.setBounds(223, 126, 162, 14);
		getContentPane().add(lblValDataSaida);
		
		String sValor="R$" + movimentacao.getValor();
		JLabel lblValValor = new JLabel(sValor);
		lblValValor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValValor.setBounds(223, 165, 100, 14);
		getContentPane().add(lblValValor);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		btnOk.setBounds(149, 227, 89, 23);
		getContentPane().add(btnOk);
		
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		parent.setVisible(true);
		dispose();
	}
}
