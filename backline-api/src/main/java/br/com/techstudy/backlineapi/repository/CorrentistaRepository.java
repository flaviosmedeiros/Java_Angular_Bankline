package br.com.techstudy.backlineapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.techstudy.backlineapi.model.Correntista;

public interface CorrentistaRepository extends JpaRepository<Correntista, Integer> {

}
