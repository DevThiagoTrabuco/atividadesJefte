package com.geriaTeam.geriatricare.services;

import com.geriaTeam.geriatricare.repositories.MedicamentosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentosService {

    @Autowired
    private MedicamentosRepository medicamentosRepository;;
}
