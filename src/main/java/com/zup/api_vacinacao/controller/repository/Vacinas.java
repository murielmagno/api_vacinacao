package com.zup.api_vacinacao.controller.repository;

import com.zup.api_vacinacao.model.entity.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Vacinas extends JpaRepository<Vacina,Integer> {
}
