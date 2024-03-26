package br.com.ramonsilva.backend.service;

import br.com.ramonsilva.backend.entity.TipoTransacao;
import br.com.ramonsilva.backend.entity.Transacao;
import br.com.ramonsilva.backend.entity.TransacaoReport;
import br.com.ramonsilva.backend.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Service
public class TransacaoService {
    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public List<TransacaoReport> listTotaisTransacoesPorNomeDaLoja() {
        var transacoes = repository.findAllByOrderByNomeDaLojaAscIdDesc();
        //LinkedHashMap é uma implementação de Map que mantém a ordem de inserção dos elementos diferentes de HashMap
        var reportMap = new LinkedHashMap<String, TransacaoReport>();


        transacoes.forEach(transacao -> {
            var nomeDaLoja = transacao.nomeDaLoja();
            var valor = transacao.valor();

            reportMap.compute(nomeDaLoja, (key, existingReport) -> {
                var report = (existingReport != null) ? existingReport: new TransacaoReport(key, BigDecimal.ZERO, new ArrayList<>());

                return report.addTotal(valor).addTransacao(transacao);
            });
        });

        return new ArrayList<>(reportMap.values());
    }
}
