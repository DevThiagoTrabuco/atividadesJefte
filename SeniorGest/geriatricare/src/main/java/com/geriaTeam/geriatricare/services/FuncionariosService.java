package com.geriaTeam.geriatricare.services;

import com.geriaTeam.geriatricare.repositories.FuncionariosRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionariosService {

    @Autowired
    private FuncionariosRepositoryImpl funcionarioRepositoryImpl;
}
