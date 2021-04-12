package com.zup.api_vacinacao.service;

import com.zup.api_vacinacao.exception.RegraVacinacaoException;
import com.zup.api_vacinacao.model.entity.CarteiraVacinacao;
import com.zup.api_vacinacao.model.entity.ItemCarteira;
import com.zup.api_vacinacao.model.entity.Usuario;
import com.zup.api_vacinacao.model.entity.Vacina;
import com.zup.api_vacinacao.controller.repository.Carteiras;
import com.zup.api_vacinacao.controller.repository.ItensCarteira;
import com.zup.api_vacinacao.controller.repository.Usuarios;
import com.zup.api_vacinacao.controller.repository.Vacinas;
import com.zup.api_vacinacao.controller.dto.CarteiraDTO;
import com.zup.api_vacinacao.controller.dto.ItensCarteiraDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarteiraServiceImpl implements CarteiraService {

    private Carteiras carteirasRepository;
    private Usuarios usuariosRepository;
    private Vacinas vacinasRepository;
    private ItensCarteira itensCarteiraRepository;

    public CarteiraServiceImpl(Carteiras carteiras, Usuarios usuarios, Vacinas vacinas, ItensCarteira itensCarteira) {
        this.carteirasRepository = carteiras;
        this.usuariosRepository = usuarios;
        this.vacinasRepository = vacinas;
        this.itensCarteiraRepository = itensCarteira;
    }

    @Override
    @Transactional
    public CarteiraVacinacao salvar(CarteiraDTO dto) {
        Integer idUsuario = dto.getUsuario();
        Usuario us = usuariosRepository.findById(idUsuario)
                .orElseThrow(() -> new RegraVacinacaoException("Código do usuário invalido"));

        CarteiraVacinacao carteiraVacinacao = new CarteiraVacinacao();
        carteiraVacinacao.setUsuario(us);

        List<ItemCarteira> itens = adicionarItens(carteiraVacinacao, dto.getItens());
        carteirasRepository.save(carteiraVacinacao);
        itensCarteiraRepository.saveAll(itens);
        carteiraVacinacao.setItens(itens);
        return carteiraVacinacao;
    }

    private List<ItemCarteira> adicionarItens(CarteiraVacinacao carteiraVacinacao, List<ItensCarteiraDTO> itens) {
        return itens.stream().map(dto -> {
            Integer idVacina = dto.getVacina();
            Vacina vacina = vacinasRepository.findById(idVacina)
                    .orElseThrow(() -> new RegraVacinacaoException("Codigo da vacina invalido: " + idVacina));

            ItemCarteira itemCarteira = new ItemCarteira();
            itemCarteira.setCarteira(carteiraVacinacao);
            itemCarteira.setVacina(vacina);
            itemCarteira.setData_vacinacao(LocalDate.now());
            return itemCarteira;
        }).collect(Collectors.toList());
    }
}
