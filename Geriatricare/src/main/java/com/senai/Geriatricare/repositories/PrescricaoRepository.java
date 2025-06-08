package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.ClienteEntity;
import com.senai.Geriatricare.entities.PacienteEntity;
import com.senai.Geriatricare.entities.PrescricaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescricaoRepository extends JpaRepository<PrescricaoEntity, Integer> {
    List<PrescricaoEntity> findByClienteAndPaciente(ClienteEntity cliente, PacienteEntity paciente);
}
