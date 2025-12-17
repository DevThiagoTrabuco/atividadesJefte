package com.senai.Geriatricare.repositories;

import com.senai.Geriatricare.models.PapelModel;
import com.senai.Geriatricare.enums.Papel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PapelRepository extends JpaRepository<PapelModel, Integer> {
    PapelModel findByPapel(Papel papel);
}
