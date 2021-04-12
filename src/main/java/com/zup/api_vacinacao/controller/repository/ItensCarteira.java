package com.zup.api_vacinacao.controller.repository;

import com.zup.api_vacinacao.model.entity.ItemCarteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensCarteira extends JpaRepository<ItemCarteira,Integer> {
}
