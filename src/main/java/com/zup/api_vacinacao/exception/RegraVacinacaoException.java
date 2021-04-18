package com.zup.api_vacinacao.exception;

import org.springframework.http.HttpStatus;

public class RegraVacinacaoException extends RuntimeException{

    public RegraVacinacaoException(HttpStatus badRequest, String message) {
        super(message);
    }
}
