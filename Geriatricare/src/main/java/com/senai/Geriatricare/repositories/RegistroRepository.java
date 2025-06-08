package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.RegistroEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface RegistroRepository extends JpaRepository<RegistroEntity, Integer> {
    List<RegistroEntity> findByEntidadeAndId(int clienteId, String entidade, int entidadeId);
    List<RegistroEntity> findByEntidade(int clienteId, String entidade);
    List<RegistroEntity> findByFuncionario(int clienteId, int funcionarioId);
    List<RegistroEntity> findByDate(int clienteId, LocalDateTime date_time);
}
