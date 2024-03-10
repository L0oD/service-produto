package com.leonardodagios.serviceproduto.http.data.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ProdutoPersistDto {
    @NotEmpty
    private String descricao;
    @NotNull
    private BigDecimal valor;

    public String getDescricao() {
        return descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }
}
