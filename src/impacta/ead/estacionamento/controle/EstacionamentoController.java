package impacta.ead.estacionamento.controle;

import java.time.LocalDateTime;
import java.util.List;

import impacta.ead.estacionamento.negocio.Movimentacao;
import impacta.ead.estacionamento.negocio.Vaga;
import impacta.ead.estacionamento.negocio.Veiculo;
import impacta.ead.estacionamento.persistencia.DAOEstacionamento;
import impacta.ead.estacionamento.ultilitario.EstacionamentoUtil;

public class EstacionamentoController {

	public void processarEntrada(String placa,String marca,String modelo,String cor) throws EstacionamentoException, VeiculoException {
		//VERIFICAR SEO ESTACIONAMENTO ESTÁ LOTADO
		if(!Vaga.temVagaLivre()) {
			throw new EstacionamentoException("Estacionamento lotado!");
		}
		//VERIFICAR O PADRÃO DE STRING DA PLACA
		if(!EstacionamentoUtil.ValidarPadraoPlaca(placa)) {
			throw new VeiculoException("Placa informada inválida!");
		}
		//CRIAR UMA INSTANCIA DO VEICULO
		Veiculo veiculo = new Veiculo(placa,marca,modelo,cor);
		
		//CRIAR A MOVIMENTAÇÃO VINCULANDO O VEICULO E COM DATA DE ENTRADA CORRENTE
		Movimentacao movimentacao =new Movimentacao(veiculo,LocalDateTime.now());
		
		//REGISTRAR NA BASE DADOS A INFORMACAO
		DAOEstacionamento dao= new DAOEstacionamento();
		dao.criar(movimentacao);
		//ATUALIZAR O NUMERO DE VAGAS OCUPADAS
		Vaga.entrou();

	}
	public Movimentacao processarSaida(String placa) {
		//TODO SUS
		return null;
	}
	public List<Movimentacao> emitirRelatorio(LocalDateTime data){
		//TODO
		return null;
	}
	public int inicializarOcuapadas() {
		DAOEstacionamento dao = new DAOEstacionamento();
		return dao.getOcupadas();
	}
	
	
}
