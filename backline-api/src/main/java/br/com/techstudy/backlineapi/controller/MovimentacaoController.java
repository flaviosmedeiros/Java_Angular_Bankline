package br.com.techstudy.backlineapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.techstudy.backlineapi.dto.NovaMovimentacao;
import br.com.techstudy.backlineapi.model.Movimentacao;
import br.com.techstudy.backlineapi.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {	
	
	@Autowired
	private MovimentacaoService service;
	
	
	
	@GetMapping
	public List<Movimentacao> findAll(){
		return service.findAll();
	}
	@GetMapping("/{idConta}")
	public List<Movimentacao> findAll(@PathVariable("idConta") Integer idConta){
		return service.findByIdConta(idConta);
	}
	@PostMapping
	public void save(@RequestBody NovaMovimentacao movimentacao) {
		service.save(movimentacao);
	}
}
