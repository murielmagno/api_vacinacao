package com.zup.api_vacinacao.controller;

import com.zup.api_vacinacao.exception.RegraVacinacaoException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler(RegraVacinacaoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleRegraVacinacaoException (RegraVacinacaoException ex){
        String msgErro = ex.getMessage();
        return new ApiErros(msgErro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleValidacaoDeMetodoException(MethodArgumentNotValidException ex){
        List<String> erros = ex.getBindingResult().getAllErrors()
                .stream()
                .map(e -> e.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApiErros(erros);
    }
}
