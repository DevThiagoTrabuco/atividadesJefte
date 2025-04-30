package com.geriaTeam.geriatricare.applications;

import com.geriaTeam.geriatricare.Interfaces.PlanoRepository;
import com.geriaTeam.geriatricare.entities.*;
import com.geriaTeam.geriatricare.entities.enums.TipoPlanoEnums;
import com.geriaTeam.geriatricare.factories.PlanoFactory;
import com.geriaTeam.geriatricare.models.PlanoModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.geriaTeam.geriatricare.entities.PlanoAvancado.obterBeneficiosPlanoAvancado;
import static com.geriaTeam.geriatricare.entities.PlanoBasico.obterBeneficiosPlanoBasico;
import static com.geriaTeam.geriatricare.entities.PlanoIntermediario.obterBeneficiosPlanoIntermediario;

@Service
public class PlanoApplication {
    private PlanoRepository planoRepository;
    private static final Double PRECO_BASICO = Double.valueOf("99.90");
    private static final Double PRECO_INTERMEDIARIO = Double.valueOf("199.90");
    private static final Double PRECO_AVANCADO = Double.valueOf("299.90");


    @Autowired
    public PlanoApplication(PlanoRepository planoRepository) {
        this.planoRepository = planoRepository;
    }

    public void adicionar(PlanoModels planoModels) {
        // Adiciona planos padrão se não existirem
        if(planoRepository.buscarPorCodigo(0) == null){
            PlanoFactory planoFactory = new PlanoFactory();

            PlanoInterface planoBasico = planoFactory.criarPlano(TipoPlanoEnums.PLANO_BASICO);
            PlanoInterface planoIntermediario = planoFactory.criarPlano(TipoPlanoEnums.PLANO_INTERMEDIARIO);
            PlanoInterface planoAvancado = planoFactory.criarPlano(TipoPlanoEnums.PLANO_AVANCADO);

            //plano basico
            planoBasico.setId(0);
            planoBasico.setNome("Plano Básico");
            planoBasico.setDescricao("Plano Básico com benefícios limitados");
            planoBasico.setPeriodoMensalidade(30);
            planoBasico.setTipoPlano(TipoPlanoEnums.PLANO_BASICO);
            planoBasico.setBeneficio(obterBeneficiosPorPlano(TipoPlanoEnums.PLANO_BASICO));
            planoBasico.setPreco(obterPreco(TipoPlanoEnums.PLANO_BASICO));
            this.planoRepository.adicionar(planoBasico.toModel());
            //plano basico

            //plano intermediario
            planoIntermediario.setId(1);
            planoIntermediario.setNome("Plano Intermediário");
            planoIntermediario.setDescricao("Plano Intermediário com benefícios intermediários");
            planoIntermediario.setPeriodoMensalidade(30);
            planoIntermediario.setTipoPlano(TipoPlanoEnums.PLANO_INTERMEDIARIO);
            planoIntermediario.setBeneficio(obterBeneficiosPorPlano(TipoPlanoEnums.PLANO_INTERMEDIARIO));
            planoIntermediario.setPreco(obterPreco(TipoPlanoEnums.PLANO_INTERMEDIARIO));
            this.planoRepository.adicionar(planoIntermediario.toModel());
            //plano intermediario

            //plano avancado
            planoAvancado.setId(2);
            planoAvancado.setNome("Plano Avançado");
            planoAvancado.setDescricao("Plano Avançado com benefícios completos");
            planoAvancado.setPeriodoMensalidade(30);
            planoAvancado.setTipoPlano(TipoPlanoEnums.PLANO_AVANCADO);
            planoAvancado.setBeneficio(obterBeneficiosPorPlano(TipoPlanoEnums.PLANO_AVANCADO));
            planoAvancado.setPreco(obterPreco(TipoPlanoEnums.PLANO_AVANCADO));
            this.planoRepository.adicionar(planoAvancado.toModel());
            //plano avancado

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


    public static String obterBeneficiosPorPlano(TipoPlanoEnums tipoPlano) {
        List<String> beneficios = new ArrayList<>();

        switch (tipoPlano) {
            case PLANO_BASICO:
                beneficios.addAll(obterBeneficiosPlanoBasico());
                break;
            case PLANO_INTERMEDIARIO:
                beneficios.addAll(obterBeneficiosPlanoIntermediario());
                break;
            case PLANO_AVANCADO:
                beneficios.addAll(obterBeneficiosPlanoAvancado());
                break;
            default:
                throw new IllegalArgumentException("Tipo de plano inválido: " + tipoPlano);
        }

        return String.join(", ", beneficios);
    }

    public static double obterPreco(TipoPlanoEnums tipoPlano) {
        switch (tipoPlano) {
            case PLANO_BASICO:
                return PRECO_BASICO;
            case PLANO_INTERMEDIARIO:
                return PRECO_INTERMEDIARIO;
            case PLANO_AVANCADO:
                return PRECO_AVANCADO;
            default:
                throw new IllegalArgumentException("Tipo de plano inválido: " + tipoPlano);
        }
    }

}

