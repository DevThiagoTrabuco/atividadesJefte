package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ObservacaoModel;
import com.senai.Geriatricare.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObservacaoRepository extends JpaRepository<ObservacaoModel, Integer> {
    Optional<ObservacaoModel> findByClienteAndId(ClienteModel cliente, Integer id);
    List<ObservacaoModel> findByClienteAndPaciente(ClienteModel cliente, PacienteModel paciente);
}
