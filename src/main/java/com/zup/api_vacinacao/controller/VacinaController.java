package com.zup.api_vacinacao.controller;

import com.zup.api_vacinacao.model.entity.Vacina;
import com.zup.api_vacinacao.controller.repository.Vacinas;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/vacinas")
public class VacinaController {

    private Vacinas vacinas;

    public VacinaController(Vacinas vacinas) {
        this.vacinas = vacinas;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vacina save(@RequestBody Vacina vacina) {
        return vacinas.save(vacina);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id, @RequestBody Vacina vacina) {
        vacinas.findById(id)
                .map(v -> {
                    vacina.setId(v.getId());
                    vacinas.save(vacina);
                    return vacina;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vacina não encontrada"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        vacinas.findById(id)
                .map(v -> {
                    vacinas.delete(v);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vacina não encontrada"));

    }

    @GetMapping("{id}")
    public Vacina getById(@PathVariable Integer id) {
        return vacinas.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Vacina não encontrada"));

    }

    @GetMapping("/listaVacinas")
    public List<Vacina> find(Vacina vacina) {
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example example = Example.of(vacina, matcher);
        return vacinas.findAll(example);
    }

}
