package br.com.pagamentoFood.pagamentoFood.dto.request;

import br.com.pagamentoFood.pagamentoFood.model.Status;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record DadosAtualizacaoPagamento(
        @NotNull
        Long id,
        @Positive
        BigDecimal valor,
        @Size(max = 100)
        String nome,
        @Size(max = 9)
        String numero,
        @Size(max = 7)
        String expiracao,
        @Size(min = 3, max = 3)
        String codigo,
        Status status,
        Long pedidoId,
        Long formaDepagamentoId

) {
}