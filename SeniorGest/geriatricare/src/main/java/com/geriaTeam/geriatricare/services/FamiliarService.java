package com.geriaTeam.geriatricare.services;

import com.geriaTeam.geriatricare.repositories.FamiliarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamiliarService {
    @Autowired
    private FamiliarRepository familiarRepository;
}
