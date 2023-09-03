package impacta.ead.estacionamento.ultilitario;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import impacta.ead.estacionamento.negocio.Movimentacao;
import impacta.ead.estacionamento.negocio.Tarifario;

/**
 * Representa uma clase de apoio as demais do sistema
 * @author Asus
 *
 */


public class EstacionamentoUtil {
	
	/**
	 * Valida a Placa com o padrao LLL-NNNN
	 * L=LETRA
	 * N=NUMERO
	 * @param placa Placa do veiculo
	 * @return True se atender o padrao e false senão
	 */
	
	public static boolean ValidarPadraoPlaca(String placa) {
		String padrao ="[A-Z][A-Z][A-Z]-\\d\\d\\d\\d";
		Pattern p= Pattern.compile(padrao);
		Matcher m= p.matcher(placa);
		
		
		
		return m.matches();
	}
	/**
	 * O calculo do valor da entrada do veiculo baseado no tarifário
	 * e na hora da entrada e saida do veiculo
	 * 
	 * altera a propria instancia do parametro
	 * 
	 * @param movimentacao
	 */
	
	public void calcularPagamento(Movimentacao movimentacao) {
		//TODO isto
		
	}
	public static String get(String propriedade) {
		Properties prop = new Properties();
		String valor= null;
		try {
			prop.load(EstacionamentoUtil.class.getResourceAsStream("/recursos/configuration.txt"));
			valor =prop.getProperty(propriedade);
		} catch (IOException e) {
			assert false: "Configuracao não carregada";
		}
		return valor;
	}
	public static String getDataAsString(LocalDateTime dataHoraEntrada) {
		return dataHoraEntrada.toString();
		
	}
	public static void calcularValorPago(Movimentacao movimentacao) {
		LocalDateTime inicio = movimentacao.getDataHoraEntrada();
		LocalDateTime fim = movimentacao.getDataHoraSaida();
		double valor = 0;
		
		long diffHoras = inicio.until(fim, ChronoUnit.HOURS);
		
		if(diffHoras > 0) {
			valor += Tarifario.VALOR_HORA;
			fim =fim.minus(1,ChronoUnit.HOURS);
		}
		long diffMinutos= inicio.until(fim,ChronoUnit.MINUTES);
		
		valor+= (diffMinutos/Tarifario.INCREMENTO_MINUTOS) * Tarifario.VALOR_INCREMENTAL;
		
		movimentacao.setValor(valor);
	}
	public static LocalDateTime getDate(String rdataEntrada) {
		return LocalDateTime.parse(rdataEntrada,
				DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	// TRANSFORMAR DATA BR
	public static String getDisplayData(LocalDateTime data) {
		return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
	}
}
