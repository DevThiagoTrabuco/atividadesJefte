package com.geriaTeam.geriatricare.facade;

import com.geriaTeam.geriatricare.applications.PlanoApplication;
import com.geriaTeam.geriatricare.models.PlanoModels;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PlanoFacade {
    @Autowired
    private PlanoApplication planoApplication;

    public List<PlanoModels> buscar() {return planoApplication.buscar();}

    public PlanoModels buscarPlanoId(int codigo) {return planoApplication.buscarPlanoId(codigo);}

    public void adicionar(PlanoModels planoModels) {planoApplication.adicionar(planoModels);}

    public void atualizar(PlanoModels planoModels) {planoApplication.atualizar(planoModels);}

    public void remover(int codigo) {planoApplication.remover(codigo);}

    public List <PlanoModels> buscarPlanoNome(String nome){
        return planoApplication.buscarPlanoNome(nome);
    }
}
