package com.geriaTeam.geriatricare.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.geriaTeam.geriatricare.applications.FamiliarApplication;
import com.geriaTeam.geriatricare.models.domain.Familiar;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@AllArgsConstructor
public class FamiliarFacade {
    @Autowired
    private FamiliarApplication familiarApplication;

    @GetMapping("")
    public List<Familiar> buscar() {
        return this.familiarApplication.getAll();}

    public Familiar buscarPorCodigo(int id) {
        return this.familiarApplication.getById(id);
    }

    public void adicionar(Familiar familiar) {
        this.familiarApplication.save(familiar);
    }

    public void atualizar(Familiar familiar) {
        this.familiarApplication.save(familiar);
    }

    public void remover(int id) {
        this.familiarApplication.delete(id);
    }
}
