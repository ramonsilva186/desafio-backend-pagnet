package br.com.ramonsilva.backend.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public record Transacao(@Id Long id,
                        Integer tipo,
                        Date data,
                        BigDecimal valor,
                        Long cpf,
                        String cartao,
                        Time hora,
                        @Column("DONO_LOJA") String donoDaLoja,
                        @Column("NOME_LOJA") String nomeDaLoja) {


    public Transacao withValor(BigDecimal valor) {
        return new Transacao(id, tipo, data, valor, cpf, cartao, hora, donoDaLoja, nomeDaLoja);
    }

    public Transacao withData(String data) throws ParseException {
        var dateFormat = new SimpleDateFormat("yyyyMMdd");
        var date = dateFormat.parse(data);

        return new Transacao(id, tipo, new Date(date.getTime()), valor, cpf, cartao, hora, donoDaLoja, nomeDaLoja);

    }

    public Transacao withHora(String hora) throws ParseException {
        var timeFormat = new SimpleDateFormat("HHmmss");
        var time = timeFormat.parse(hora);

        return new Transacao(id, tipo, data, valor, cpf, cartao, new Time(time.getTime()), donoDaLoja, nomeDaLoja);
    }
}
