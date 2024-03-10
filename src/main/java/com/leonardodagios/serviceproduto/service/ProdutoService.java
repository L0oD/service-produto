package com.leonardodagios.serviceproduto.service;

import com.leonardodagios.serviceproduto.model.Produto;

public interface ProdutoService {
    Produto inserir(Produto produto);

    Produto one(Long id);
}
