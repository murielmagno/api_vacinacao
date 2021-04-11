package com.zup.api_vacinacao.model.repository;

import com.zup.api_vacinacao.model.entity.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Vacinas extends JpaRepository<Vacina,Integer> {
}
