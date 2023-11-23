package br.com.pagamentoFood.pagamentoFood.service;

import br.com.pagamentoFood.pagamentoFood.dto.request.DadosAtualizacaoPagamento;
import br.com.pagamentoFood.pagamentoFood.dto.request.DadosCadastroPagamento;
import br.com.pagamentoFood.pagamentoFood.dto.response.DadosDetalhamentoPagamento;
import br.com.pagamentoFood.pagamentoFood.model.Pagamento;
import br.com.pagamentoFood.pagamentoFood.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    public DadosDetalhamentoPagamento cadastrar(DadosCadastroPagamento dados) {
        var pagamento = new Pagamento(dados);
        this.pagamentoRepository.save(pagamento);
        return new DadosDetalhamentoPagamento(pagamento);
    }

    public Page<DadosDetalhamentoPagamento> listarTodos(Pageable paginacao) {
        var page = this.pagamentoRepository.findAll(paginacao).map(DadosDetalhamentoPagamento::new);
        return page;
    }

    public DadosDetalhamentoPagamento buscarPorId(Long id) {
        var pagamento = this.pagamentoRepository.getReferenceById(id);
        return new DadosDetalhamentoPagamento(pagamento);
    }

    public DadosDetalhamentoPagamento atualizar(DadosAtualizacaoPagamento dados) {
        var pagamento = this.pagamentoRepository.getReferenceById(dados.id());
        pagamento.atualizarDados(dados);
        return new DadosDetalhamentoPagamento(pagamento);
    }

    public void deletar(Long id) {
        this.pagamentoRepository.deleteById(id);
    }
}
