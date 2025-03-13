package com.geriaTeam.geriatricare.services;

import com.geriaTeam.geriatricare.repositories.PacienteHasPlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PacienteHasPlanoService {

    @Autowired
    private PacienteHasPlanoRepository pacienteHasPlanoRepository;
}
