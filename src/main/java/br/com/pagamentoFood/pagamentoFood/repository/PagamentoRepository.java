package br.com.pagamentoFood.pagamentoFood.repository;

import br.com.pagamentoFood.pagamentoFood.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
}
