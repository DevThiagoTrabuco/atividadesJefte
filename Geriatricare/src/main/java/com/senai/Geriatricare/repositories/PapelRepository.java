package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.entities.PapelEntity;
import com.senai.Geriatricare.enums.Papel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PapelRepository extends JpaRepository<PapelEntity, Integer> {
    PapelEntity findByPapel(Papel papel);
}
