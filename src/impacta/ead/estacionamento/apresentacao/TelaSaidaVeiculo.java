package impacta.ead.estacionamento.apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import impacta.ead.estacionamento.controle.EstacionamentoController;
import impacta.ead.estacionamento.negocio.Movimentacao;

public class TelaSaidaVeiculo extends JFrame implements ActionListener{
	
	private JFrame parent;

	private JFormattedTextField txtPlaca;
	
	public TelaSaidaVeiculo(JFrame parent) {
		setResizable(false);
		setTitle("Saida de Veiculo");
		setSize(new Dimension(526, 198));
		this.parent=parent;
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.SOUTH);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(this);
		btnOk.setActionCommand("ok");
		panel.add(btnOk);
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addActionListener(this);
		btnCancel.setActionCommand("cancelar");
		panel.add(btnCancel);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(35);
		getContentPane().add(panel_1, BorderLayout.CENTER);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setForeground(new Color(0, 0, 255));
		lblPlaca.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(lblPlaca);
		
		
	
		try {
			txtPlaca = new JFormattedTextField(new MaskFormatter("UUU-####"));
		} catch (ParseException e) {
			assert false: "formato do padrao invalido";
		}
		txtPlaca.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel_1.add(txtPlaca);
		txtPlaca.setColumns(15);
		
		setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String cmd = evento.getActionCommand();
		//para a tela de pagamento
		if(cmd.equals("ok")) {
			EstacionamentoController controle = new EstacionamentoController();
			Movimentacao movimentacao= controle.processarSaida(txtPlaca.getText());
			TelaResumoPagamento telaResumo = new TelaResumoPagamento(movimentacao,parent);
			telaResumo.setVisible(true);
		}else {
			parent.setVisible(true);
		}
		dispose();
	}
		

}
