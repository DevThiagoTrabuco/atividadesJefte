package com.geriaTeam.geriatricare.services;

import com.geriaTeam.geriatricare.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;
}



