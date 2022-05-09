package br.com.techstudy.backlineapi.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.techstudy.backlineapi.model.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer> {
	
	public List<Movimentacao>findByIdConta(Integer idConta);
}
