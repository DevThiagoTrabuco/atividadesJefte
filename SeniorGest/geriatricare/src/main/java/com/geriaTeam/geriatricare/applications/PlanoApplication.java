package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PlanoRepository;
import com.geriaTeam.geriatricare.entities.*;
import com.geriaTeam.geriatricare.entities.enums.TipoPlanoEnums;
import com.geriaTeam.geriatricare.factories.PlanoFactory;
import com.geriaTeam.geriatricare.models.PlanoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanoApplication {
    private PlanoRepository planoRepository;


    @Autowired
    public PlanoApplication(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public void adicionar(PlanoModels planoModels) {
        // Verifica se o tipo de plano é válido
        TipoPlanoEnums tipoPlano = TipoPlanoEnums.valueOf(planoModels.getTipoPlano());
        if (tipoPlano == null) {
            throw new IllegalArgumentException("Tipo de plano inválido: " + planoModels.getTipoPlano());
        }
        PlanoFactory planoFactory = new PlanoFactory();
        PlanoInterface planoCriado = planoFactory.criarPlano(tipoPlano);

        // Atribui os valores do PlanoModels ao objeto criado
        if (planoCriado instanceof PlanoBasico) {
            PlanoBasico planoBasico = (PlanoBasico) planoCriado;
            planoModels.setTipoPlano(String.valueOf(tipoPlano));
            planoModels.setPreco(planoBasico.getPreco());
            planoModels.setDescricao(planoBasico.getDescricao());

        } else if (planoCriado instanceof PlanoIntermediario) {
            PlanoIntermediario planoIntermediario = (PlanoIntermediario) planoCriado;
            planoModels.setTipoPlano(String.valueOf(planoIntermediario.getTipoPlano()));
            planoModels.setPreco(planoIntermediario.getPreco());
            planoModels.setDescricao(planoIntermediario.getDescricao());
            // Adicione lógica adicional para PlanoIntermediario, se necessário
        } else if (planoCriado instanceof PlanoAvancado) {
            PlanoAvancado planoAvancado = (PlanoAvancado) planoCriado;
            planoModels.setTipoPlano(String.valueOf(planoAvancado.getTipoPlano()));
            planoModels.setPreco(planoAvancado.getPreco());
            planoModels.setDescricao(planoAvancado.getDescricao());
            // Adicione lógica adicional para PlanoAvancado, se necessário
        } else {
            throw new IllegalArgumentException("Tipo de plano não suportado: " + tipoPlano);
        }

        // Salva o plano no repositório
        this.planoRepository.adicionar(planoModels);
    }

    public void atualizar(PlanoModels planoModels){
        this.planoRepository.atualizar(planoModels);
    }

    public void remover(int codigo){
        this.planoRepository.remover(codigo);
    }

    public List<PlanoModels> buscar(){
        return this.planoRepository.buscar();
    }

    public PlanoModels buscarPorCodigo(int codigo){
        return this.planoRepository.buscarPorCodigo(codigo);
    }

}

