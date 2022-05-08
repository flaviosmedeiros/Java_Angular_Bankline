package br.com.techstudy.backlineapi.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.techstudy.backlineapi.dto.NovoCorrentista;
import br.com.techstudy.backlineapi.model.Conta;
import br.com.techstudy.backlineapi.model.Correntista;
import br.com.techstudy.backlineapi.repository.CorrentistaRepository;

@Service
public class CorrentistaService {
	
	@Autowired
	private CorrentistaRepository repository;
	
	public List<Correntista> findAll(){
		return repository.findAll();
	}
	
	public void save(NovoCorrentista novoCorrentista) {
		Correntista correntista = new Correntista();
		correntista.setCpf(novoCorrentista.getCpf());
		correntista.setNome(novoCorrentista.getNome());
		
		Conta conta = new Conta();
		conta.setSaldo(BigDecimal.ZERO);
		conta.setNumero(new Date().getTime());
		
		correntista.setConta(conta);
		repository.save(correntista);
	}
}
