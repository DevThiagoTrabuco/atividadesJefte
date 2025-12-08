package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ClienteModel;
import com.senai.Geriatricare.models.ContasAReceberModel;
import com.senai.Geriatricare.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContasAReceberRepository extends JpaRepository<ContasAReceberModel, Integer> {
    List<ContasAReceberModel> findByClienteAndPaciente(ClienteModel cliente, PacienteModel paciente);
}
