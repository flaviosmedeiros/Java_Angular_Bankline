package br.com.techstudy.backlineapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.techstudy.backlineapi.dto.NovoCorrentista;
import br.com.techstudy.backlineapi.model.Correntista;
import br.com.techstudy.backlineapi.service.CorrentistaService;

@RestController
@RequestMapping("/correntistas")
public class CorrentistaController {	
	
	@Autowired
	private CorrentistaService service;
	
	
	@GetMapping
	public List<Correntista> findAll(){
		return service.findAll();
	}
	
	@PostMapping
	public void save(@RequestBody NovoCorrentista correntista) {
		service.save(correntista);
	}
}
