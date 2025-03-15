package com.geriaTeam.geriatricare.facade;

import com.geriaTeam.geriatricare.applications.PlanoApplication;
import com.geriaTeam.geriatricare.models.domain.Plano;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PlanosFacade {
    @Autowired
    private PlanoApplication planoApplication;

    public List<Plano> buscar() {return planoApplication.buscar();}

    public Plano buscarPorCodigo(int codigo) {return planoApplication.buscarPorCodigo(codigo);}

    public void adicionar(Plano plano) {planoApplication.adicionar(plano);}

    public void atualizar(int codigo, Plano plano) {planoApplication.atualizar(codigo, plano);}

    public void remover(int codigo) {planoApplication.remover(codigo);}

}
