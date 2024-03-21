package br.com.ramonsilva.backend.repository;

import br.com.ramonsilva.backend.entity.Transacao;
import org.springframework.data.repository.CrudRepository;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
}
