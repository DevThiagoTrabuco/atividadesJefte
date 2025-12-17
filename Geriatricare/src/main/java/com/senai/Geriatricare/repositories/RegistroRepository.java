package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.FuncionarioModel;
import com.senai.Geriatricare.models.RegistroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RegistroRepository extends JpaRepository<RegistroModel, Integer> {
    List<RegistroModel> findByClienteAndEntidadeAndId(ClienteModel cliente, String entidade, int entidadeId);
    List<RegistroModel> findByClienteAndEntidade(ClienteModel cliente, String entidade);
    List<RegistroModel> findByClienteAndFuncionario(ClienteModel cliente, FuncionarioModel funcionario);
    List<RegistroModel> findByClienteAndDataHora(ClienteModel cliente, LocalDateTime dataHora);
}
