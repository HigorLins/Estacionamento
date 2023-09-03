
package impacta.ead.estacionamento.negocio;
import impacta.ead.estacionamento.controle.EstacionamentoController;

/**
 * Representa as informações relativas a vagas do estacionamento ou status da ocupação
 * @author Asus
 *
 */
public class Vaga {

	public static int TOTAL_VAGAS=100;
	private static int vagasOcupadas=inicializarOcupadas();;
	
	private Vaga() {
		
	}
	
	/**
	 * verificar a existencia de alguma vaga livre
	 * 
	 * 
	 * @return true se houver alguma vaga e false se estiver vazia
	 */

	public static boolean temVagaLivre() {
	
		return (vagasOcupadas < TOTAL_VAGAS);
	}
	
	/**
	 * buscar o status atual das vagas do estacionamento.
	 */
	
	
	public static int inicializarOcupadas() {
		EstacionamentoController controle = new EstacionamentoController();
		return controle.inicializarOcuapadas();
	}
	
	/**
	 * retorna o numero de vagas ocupadas
	 * @return numero total de vagas ocupadas num determinado instante
	 */
	
	
	
	
	public static int ocupadas() {
		return Vaga.vagasOcupadas;
		
	
	}
	
	/**
	 * retorna o numero de vagas livres
	 */
	
	public static int livres() {
		return TOTAL_VAGAS-Vaga.vagasOcupadas;
	}
	
	/**
	 * Atualiza o numero de vagas ocupadas apos entrada do veiculo.
	 */
	
	public static void entrou() {
		Vaga.vagasOcupadas++;
	}

	public static void saiu() {
		Vaga.vagasOcupadas--;
	}
	
	
	
	
	
	
}
