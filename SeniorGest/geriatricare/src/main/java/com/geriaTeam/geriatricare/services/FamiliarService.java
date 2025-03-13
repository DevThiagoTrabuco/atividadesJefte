package com.geriaTeam.geriatricare.services;

import com.geriaTeam.geriatricare.repositories.FamiliarRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamiliarService {
    @Autowired
    private FamiliarRepositoryImpl familiarRepositoryImpl;
}
