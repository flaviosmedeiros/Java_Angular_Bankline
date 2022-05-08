package br.com.techstudy.backlineapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.techstudy.backlineapi.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{

	public List<Movimentacao>findByIdConta(Integer idConta);
}
