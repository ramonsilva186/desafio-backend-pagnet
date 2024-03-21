package br.com.ramonsilva.backend.service;

import br.com.ramonsilva.backend.entity.Transacao;
import br.com.ramonsilva.backend.entity.TransacaoReport;
import br.com.ramonsilva.backend.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransacaoService {
    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public Iterable<Transacao> listTotaisTransacoesPorNomeDaLoja() {
        var transacoes = repository.findAll();
        return transacoes;
    }
}
