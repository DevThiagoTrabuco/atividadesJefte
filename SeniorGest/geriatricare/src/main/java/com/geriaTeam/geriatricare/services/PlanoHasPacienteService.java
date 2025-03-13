package com.geriaTeam.geriatricare.services;


import com.geriaTeam.geriatricare.repositories.PlanoHasPacienteRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoHasPacienteService {

    @Autowired
    private PlanoHasPacienteRepositoryImpl planoHasPacienteRepositoryImpl;
}
