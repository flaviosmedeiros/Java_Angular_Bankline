package br.com.techstudy.backlineapi.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.techstudy.backlineapi.dto.NovaMovimentacao;
import br.com.techstudy.backlineapi.model.Correntista;
import br.com.techstudy.backlineapi.model.Movimentacao;
import br.com.techstudy.backlineapi.model.MovimentacaoTipo;
import br.com.techstudy.backlineapi.repository.CorrentistaRepository;
import br.com.techstudy.backlineapi.repository.MovimentacaoRepository;

@Service
public class MovimentacaoService {
	
	@Autowired
	private MovimentacaoRepository repository;	
	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	
	public List<Movimentacao> findAll(){
		return repository.findAll();
	}
	
	public List<Movimentacao> findByIdConta(Integer idConta){
		return repository.findByIdConta(idConta);
	}
	
	public void save(NovaMovimentacao novaMovimentacao) {
		
		Movimentacao movimentacao = new Movimentacao();	
		
		BigDecimal valor = novaMovimentacao.getValor();
		if(novaMovimentacao.getTipo() == MovimentacaoTipo.DESPESA)
			valor = valor.negate();
			
		movimentacao.setDataHora(LocalDateTime.now());
		movimentacao.setDescricao(novaMovimentacao.getDescricao());
		movimentacao.setIdConta(novaMovimentacao.getIdConta());
		movimentacao.setTipo(novaMovimentacao.getTipo());
		movimentacao.setValor(valor);
		
		Correntista correntista = correntistaRepository.findById(novaMovimentacao.getIdConta()).orElse(null);
		if(correntista != null) {
			correntista.getConta().setSaldo(correntista.getConta().getSaldo().add(valor));
			correntistaRepository.save(correntista);
		}
		
		repository.save(movimentacao);		
	}
}
