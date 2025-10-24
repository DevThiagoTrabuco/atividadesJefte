package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModelModel;
import com.senai.Geriatricare.models.PacienteModel;
import com.senai.Geriatricare.models.PrescricaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrescricaoRepository extends JpaRepository<PrescricaoModel, Integer> {
    List<PrescricaoModel> findByClienteAndPaciente(ClienteModelModel cliente, PacienteModel paciente);
}
