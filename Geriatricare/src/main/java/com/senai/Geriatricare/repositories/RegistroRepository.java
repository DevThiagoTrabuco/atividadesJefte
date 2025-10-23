package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.FuncionarioModel;
import com.senai.Geriatricare.models.RegistroModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RegistroRepository extends JpaRepository<RegistroModel, Integer> {
    List<RegistroModel> findByClienteAndEntidadeAndId(ClienteModel cliente, String entidade, int entidadeId);
    List<RegistroModel> findByClienteAndEntidade(ClienteModel cliente, String entidade);
    List<RegistroModel> findByClienteAndFuncionario(ClienteModel cliente, FuncionarioModel funcionario);
    List<RegistroModel> findByClienteAndDataHora(ClienteModel cliente, LocalDateTime dataHora);
}
