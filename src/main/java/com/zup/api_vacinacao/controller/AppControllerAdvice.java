package com.zup.api_vacinacao.controller;

import com.zup.api_vacinacao.exception.RegraVacinacaoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler(RegraVacinacaoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleRegraVacinacaoException (RegraVacinacaoException ex){
        String msgErro = ex.getMessage();
        return new ApiErros(msgErro);
    }
}
