package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaModel, Integer> {
}
