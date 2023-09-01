package impacta.ead.estacionamento.apresentacao;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import impacta.ead.estacionamento.controle.EstacionamentoController;
import impacta.ead.estacionamento.controle.EstacionamentoException;
import impacta.ead.estacionamento.controle.VeiculoException;

public class TelaEntradaVeiculo extends JFrame implements ActionListener {
	

	private JFrame parent;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtCor;
	private JFormattedTextField txfPlaca;
	private JButton btnOk;
	private JButton btnCancel;
	//TODO
	
	public static void main(String[]args) {
		TelaEntradaVeiculo tela = new TelaEntradaVeiculo(null);
		tela.setVisible(true);
	}

	public TelaEntradaVeiculo(JFrame parent) {
		setResizable(false);
		setSize(400,300);
		setTitle("Entrada de Veiculo");
		// TODO Auto-generated constructor stub
		this.parent= parent;
		getContentPane().setLayout(null);
		
		JLabel lblPlaca = new JLabel("Placa:");
		lblPlaca.setBounds(72, 64, 46, 14);
		getContentPane().add(lblPlaca);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(72, 95, 46, 14);
		getContentPane().add(lblMarca);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(72, 126, 46, 14);
		getContentPane().add(lblModelo);
		
		JLabel lblCor = new JLabel("Cor");
		lblCor.setBounds(72, 157, 46, 14);
		getContentPane().add(lblCor);
		
		txtMarca = new JTextField();
		txtMarca.setBounds(169, 92, 86, 20);
		getContentPane().add(txtMarca);
		txtMarca.setColumns(10);
		
		txtModelo = new JTextField();
		txtModelo.setBounds(169, 123, 86, 20);
		getContentPane().add(txtModelo);
		txtModelo.setColumns(10);
		
		txtCor = new JTextField();
		txtCor.setBounds(169, 154, 86, 20);
		getContentPane().add(txtCor);
		txtCor.setColumns(10);
		
		btnOk = new JButton("OK");
		btnOk.setBounds(85, 227, 89, 23);
		btnOk.addActionListener(this);
		btnOk.setActionCommand("ok");
		getContentPane().add(btnOk);
		
		btnCancel = new JButton("Cancelar");
		btnCancel.setBounds(259, 227, 89, 23);
		btnCancel.addActionListener(this);
		btnCancel.setActionCommand("cancel");
		getContentPane().add(btnCancel);
		
		 try {
			txfPlaca = new JFormattedTextField(new MaskFormatter("UUU-####"));
		} catch (ParseException e) {
			assert false : "Padrão de placa errado";
		}
		txfPlaca.setColumns(10);
		txfPlaca.setBounds(169, 61, 86, 20);
		getContentPane().add(txfPlaca);
		
		setLocationRelativeTo(null);
	}

	/**
	 * Enviar dados para classe Controller
	 */
	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getActionCommand().equals("ok")) {
			EstacionamentoController controle = new EstacionamentoController();
			try {
				controle.processarEntrada(txfPlaca.getText(),txtMarca.getText(),txtModelo.getText() ,txtCor.getText());
				JOptionPane.showMessageDialog(null,"Veiculo registrado com sucesso","Entrada de Veiculo",JOptionPane.INFORMATION_MESSAGE);
			} catch (EstacionamentoException | VeiculoException e) {
				JOptionPane.showMessageDialog(null, e.getMessage(),"Falha na entrada",JOptionPane.ERROR_MESSAGE);
			}
		
			
		} 
			this.parent.setVisible(true);
			this.dispose();//FECHA A JANELA
		
	}
}
