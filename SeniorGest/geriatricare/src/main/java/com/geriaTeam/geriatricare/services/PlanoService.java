package com.geriaTeam.geriatricare.services;

import com.geriaTeam.geriatricare.repositories.PlanoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanoService {

    @Autowired
    private PlanoRepositoryImpl planoRepositoryImpl;
}
