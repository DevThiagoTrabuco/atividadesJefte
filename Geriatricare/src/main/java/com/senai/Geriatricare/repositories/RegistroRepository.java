package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.FuncionarioEntity;
import com.senai.Geriatricare.entities.RegistroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RegistroRepository extends JpaRepository<RegistroEntity, Integer> {
    List<RegistroEntity> findByClienteAndEntidadeAndId(ClienteEntity cliente, String entidade, int entidadeId);
    List<RegistroEntity> findByClienteAndEntidade(ClienteEntity cliente, String entidade);
    List<RegistroEntity> findByClienteAndFuncionario(ClienteEntity cliente, FuncionarioEntity funcionario);
    List<RegistroEntity> findByClienteAndDataHora(ClienteEntity cliente, LocalDateTime dataHora);
}
