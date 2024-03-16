package com.leonardodagios.serviceproduto.event;

import org.springframework.context.ApplicationEvent;
import com.leonardodagios.serviceproduto.model.Produto;

public class ProdutoPersistEvent extends ApplicationEvent {

    private final Produto produto;

    public ProdutoPersistEvent(Object source, Produto produto) {
        super(source);
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }
}
