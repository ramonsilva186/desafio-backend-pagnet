package br.com.ramonsilva.backend.entity;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

public record Transacao(Long id,
                        Integer tipo,
                        Date data,
                        BigDecimal valor,
                        Long cpf,
                        String cartao,
                        Time hora,
                        String donoDaLoja,
                        String nomeDaLoja) {
}
