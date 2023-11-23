package br.com.pagamentoFood.pagamentoFood.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record DadosCadastroPagamento(
        @NotNull
        @Positive
        BigDecimal valor,
        @NotBlank(message = "O nome não pode estar em branco e deve ter no máximo 100 caracteres.")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres.")
        String nome,
        @NotBlank(message = "O número não pode estar em branco e deve ter exatamente 9 dígitos.")
        @Size(max = 9, min = 9, message = "O número deve ter exatamente 9 dígitos.")
        String numero,
        @NotBlank(message = "A expiração não pode estar em branco e deve ter no máximo 7 caracteres.")
        @Size(max = 7, message = "A expiração deve ter no máximo 7 caracteres.")
        String expiracao,
        @NotBlank(message = "O código não pode estar em branco e deve ter exatamente 3 caracteres.")
        @Size(min = 3, max = 3, message = "O código deve ter exatamente 3 caracteres.")
        String codigo,
        @NotNull(message = "O ID do pedido não pode ser nulo.")
        Long pedidoId,
        @NotNull(message = "O ID da forma de pagamento não pode ser nulo.")
        Long formaDePagamentoId
) {
}
