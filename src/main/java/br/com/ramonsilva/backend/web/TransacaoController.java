package br.com.ramonsilva.backend.web;

import br.com.ramonsilva.backend.entity.Transacao;
import br.com.ramonsilva.backend.entity.TransacaoReport;
import br.com.ramonsilva.backend.service.TransacaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("transacoes")
public class TransacaoController {

    private final TransacaoService service;

    public TransacaoController(TransacaoService service) {
        this.service = service;
    }

    @GetMapping
    Iterable<Transacao> listAll() {
        return service.listTotaisTransacoesPorNomeDaLoja();
    }
}
