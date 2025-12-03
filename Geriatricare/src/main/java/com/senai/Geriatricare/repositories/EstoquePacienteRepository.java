package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.EstoquePacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoquePacienteRepository extends JpaRepository<EstoquePacienteModel, Integer> {
}
