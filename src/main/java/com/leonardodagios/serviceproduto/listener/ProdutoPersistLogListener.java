package com.leonardodagios.serviceproduto.listener;

import com.leonardodagios.serviceproduto.event.ProdutoPersistEvent;
import com.leonardodagios.serviceproduto.model.Produto;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class ProdutoPersistLogListener implements ApplicationListener<ProdutoPersistEvent> {
    @Override
    public void onApplicationEvent(ProdutoPersistEvent event) {
        Produto produto = event.getProduto();
        System.out.println("event = " + produto.getDescricao());
    }

}
