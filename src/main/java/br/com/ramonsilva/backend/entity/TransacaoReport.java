package br.com.ramonsilva.backend.entity;

import java.math.BigDecimal;
import java.util.List;

public record TransacaoReport(
        String nomeDaLoja,
        BigDecimal total,
        List<Transacao> transacoes) {
}
