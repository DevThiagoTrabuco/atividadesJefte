package com.geriaTeam.geriatricare.services;

import com.geriaTeam.geriatricare.repositories.MedicamentosRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentosService {

    @Autowired
    private MedicamentosRepositoryImpl medicamentosRepositoryImpl;
}
