package com.leonardodagios.serviceproduto.http;

import com.leonardodagios.serviceproduto.http.data.request.ProdutoPersistDto;
import com.leonardodagios.serviceproduto.http.data.response.ProdutoResponseDto;
import com.leonardodagios.serviceproduto.model.Produto;
import com.leonardodagios.serviceproduto.service.ProdutoService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("produto")
public class ProdutoControllerImpl implements ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoControllerImpl(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto inserir(@Valid @RequestBody ProdutoPersistDto dto){
        Produto produto = new Produto(dto.getDescricao(),dto.getValor());

        return  produtoService.inserir(produto);
    }
    @Override
    @GetMapping("{id}")
    @ResponseStatus()
    public Produto one(@PathVariable("id") Long id){

        return produtoService.one(id);
    }

}
