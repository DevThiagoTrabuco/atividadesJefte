package com.geriaTeam.geriatricare.repositories.jpa;

import com.geriaTeam.geriatricare.models.CondicaoMentalModels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CondicaoMentalJPA extends JpaRepository<CondicaoMentalModels, Integer> {
}
