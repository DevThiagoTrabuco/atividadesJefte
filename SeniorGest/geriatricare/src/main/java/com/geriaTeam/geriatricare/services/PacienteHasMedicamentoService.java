package com.geriaTeam.geriatricare.services;


import com.geriaTeam.geriatricare.repositories.PacienteHasMedicamentosRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteHasMedicamentoService {

    @Autowired
    private PacienteHasMedicamentosRepositoryImpl pacienteHasMedicamentoRepositoryImpl;
}
