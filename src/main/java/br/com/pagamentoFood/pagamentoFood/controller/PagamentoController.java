package br.com.pagamentoFood.pagamentoFood.controller;

import br.com.pagamentoFood.pagamentoFood.dto.request.DadosAtualizacaoPagamento;
import br.com.pagamentoFood.pagamentoFood.dto.request.DadosCadastroPagamento;
import br.com.pagamentoFood.pagamentoFood.dto.response.DadosDetalhamentoPagamento;
import br.com.pagamentoFood.pagamentoFood.service.PagamentoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService pagamentoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroPagamento dados, UriComponentsBuilder uriComponentsBuilder) {
        var pagamento = this.pagamentoService.cadastrar(dados);
        var uri = uriComponentsBuilder.path("/pagamentos/{id}").buildAndExpand(pagamento.id()).toUri();
        return ResponseEntity.created(uri).body(pagamento);
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoPagamento>> listarTodos(Pageable paginacao) {
        var page = this.pagamentoService.listarTodos(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarPorId(@PathVariable Long id) {
        var paciente = this.pagamentoService.buscarPorId(id);
        return ResponseEntity.ok(paciente);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoPagamento dados) {
        var paciente = this.pagamentoService.atualizar(dados);
        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletar(@PathVariable Long id) {
        this.pagamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
