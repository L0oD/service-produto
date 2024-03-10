package com.leonardodagios.serviceproduto.http;

import com.leonardodagios.serviceproduto.http.data.request.ProdutoPersistDto;
import com.leonardodagios.serviceproduto.http.data.response.ProdutoResponseDto;
import com.leonardodagios.serviceproduto.model.Produto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public interface ProdutoController {
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Produto inserir(@Valid @RequestBody ProdutoPersistDto dto);

    @GetMapping("{id}")
    @Operation(summary = "Retorna o Produto correspondente ao ID passado por parâmetro")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "404",
                    content = @Content(
                            mediaType = "application/json",
                            examples = @ExampleObject(
                                    value = """
                                            {
                                                "codigo": "X100",
                                                "mensagem": "Produto de código 35223 não encontrado",
                                                "documentacao": null
                                            }
                                            """
                            )
                    )
            )
    })
    Produto one(@PathVariable("id") Long id);
}
