package com.leonardodagios.serviceproduto.repository;

import com.leonardodagios.serviceproduto.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
