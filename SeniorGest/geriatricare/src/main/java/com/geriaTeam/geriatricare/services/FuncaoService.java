package com.geriaTeam.geriatricare.services;


import com.geriaTeam.geriatricare.repositories.FuncaoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncaoService {

    @Autowired
    private FuncaoRepositoryImpl funcaoRepositoryImpl;
}
