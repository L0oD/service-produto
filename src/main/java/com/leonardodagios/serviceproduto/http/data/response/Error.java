package com.leonardodagios.serviceproduto.http.data.response;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.springframework.lang.NonNull;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Objects;

public class Error {
    private final String codigo;
    private final String mensagem;
    private final String documentacao;

    public Error(@NonNull String codigo, @NonNull String mensagem, @NonNull String urlDocumentation) {
        this.codigo = Objects.requireNonNull(codigo);
        this.mensagem = Objects.requireNonNull(mensagem);
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String url = request.getRequestURL().toString().replace(request.getRequestURI(),"");

        documentacao = url + urlDocumentation;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getDocumentacao() {
        return documentacao;
    }
}
