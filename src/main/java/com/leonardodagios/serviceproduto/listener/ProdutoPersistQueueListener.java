package com.leonardodagios.serviceproduto.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leonardodagios.serviceproduto.event.ProdutoPersistEvent;
import com.leonardodagios.serviceproduto.model.Produto;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Order(1)
public class ProdutoPersistQueueListener implements ApplicationListener<ProdutoPersistEvent> {
    private static final Logger logger = Logger.getLogger(ProdutoPersistQueueListener.class.getName());
    private final ObjectMapper objectMapper;
    private final JmsTemplate jmsTemplate;
    public ProdutoPersistQueueListener(ObjectMapper objectMapper, JmsTemplate jmsTemplate) {
        this.objectMapper = objectMapper;
        this.jmsTemplate = jmsTemplate;
    }

    @Override

    public void onApplicationEvent(ProdutoPersistEvent event) {
        try {
            Produto produto = event.getProduto();
            String json = objectMapper.writeValueAsString(produto);
            jmsTemplate.convertAndSend("produto.persist.queue",json);
        } catch (JsonProcessingException ex) {
            logger.finer(ex.getMessage());
        }
    }

}
