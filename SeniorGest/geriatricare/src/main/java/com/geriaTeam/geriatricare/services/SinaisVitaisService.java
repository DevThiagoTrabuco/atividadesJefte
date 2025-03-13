package com.geriaTeam.geriatricare.services;

import com.geriaTeam.geriatricare.repositories.SinaisVitaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SinaisVitaisService {

    @Autowired
    private SinaisVitaisRepository sinaisVitaisRepository;
}
