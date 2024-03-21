package br.com.ramonsilva.backend.repository;

import br.com.ramonsilva.backend.entity.Transacao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TransacaoRepository extends CrudRepository<Transacao, Long> {
    // select * from transacao order by nome_da_loja asc, id desc
    List<Transacao> findAllByOrderByNomeDaLojaAscIdDesc();
}
