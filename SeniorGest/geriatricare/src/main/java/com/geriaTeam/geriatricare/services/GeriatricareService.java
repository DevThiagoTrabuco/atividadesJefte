package com.geriaTeam.geriatricare.services;

import com.geriaTeam.geriatricare.repositories.GeriatricareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeriatricareService {

    @Autowired
    private GeriatricareRepository geriatricareRepository;
}
