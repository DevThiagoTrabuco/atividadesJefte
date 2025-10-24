package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModelModel;
import com.senai.Geriatricare.models.FuncionarioModel;
import com.senai.Geriatricare.models.RegistroModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RegistroRepository extends JpaRepository<RegistroModel, Integer> {
    List<RegistroModel> findByClienteAndEntidadeAndId(ClienteModelModel cliente, String entidade, int entidadeId);
    List<RegistroModel> findByClienteAndEntidade(ClienteModelModel cliente, String entidade);
    List<RegistroModel> findByClienteAndFuncionario(ClienteModelModel cliente, FuncionarioModel funcionario);
    List<RegistroModel> findByClienteAndDataHora(ClienteModelModel cliente, LocalDateTime dataHora);
}
