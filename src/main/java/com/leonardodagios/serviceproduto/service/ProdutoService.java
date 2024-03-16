package com.leonardodagios.serviceproduto.service;

import com.leonardodagios.serviceproduto.model.Produto;

public interface ProdutoService {
    Produto save(Produto produto);

    Produto one(Long id);

    void delete(Long id);

    Produto update(Produto produto);
}
