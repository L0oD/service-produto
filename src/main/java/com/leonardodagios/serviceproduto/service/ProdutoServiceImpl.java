package com.leonardodagios.serviceproduto.service;

import com.leonardodagios.serviceproduto.model.Produto;
import com.leonardodagios.serviceproduto.repository.ProdutoRepository;
import jakarta.persistence.NoResultException;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto inserir(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    public Produto one(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new NoResultException(String.format("Produto de código %d não encontrado", id)));
    }
}
