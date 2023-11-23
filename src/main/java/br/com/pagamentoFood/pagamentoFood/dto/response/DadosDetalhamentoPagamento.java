package br.com.pagamentoFood.pagamentoFood.dto.response;

import br.com.pagamentoFood.pagamentoFood.model.Pagamento;
import br.com.pagamentoFood.pagamentoFood.model.Status;

import java.math.BigDecimal;

public record DadosDetalhamentoPagamento(Long id, BigDecimal valor, String nome, String numero, String expiracao,
                                         String codigo, Status status, Long pedidoId, Long formaDePagamentoId) {

    public DadosDetalhamentoPagamento(Pagamento pagamento) {
        this(pagamento.getId(), pagamento.getValor(), pagamento.getNome(), pagamento.getNumero(), pagamento.getExpiracao(), pagamento.getCodigo(), pagamento.getStatus(), pagamento.getPedidoId(), pagamento.getFormaDePagamentoId());
    }
}
