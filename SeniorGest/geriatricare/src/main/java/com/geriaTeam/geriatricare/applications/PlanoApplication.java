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

    public void adicionarPlano(PlanoModels planoModels) {
        // Adiciona planos padrão se não existirem
        if(planoRepository.buscarPlanoNome("Plano Basico") == null
                || planoRepository.buscarPlanoNome("Plano Intermediario") == null
                || planoRepository.buscarPlanoNome("Plano Avancado") == null
                || planoRepository.buscarPlanoId(0) == null
                || planoRepository.buscarPlanoId(1) == null
                || planoRepository.buscarPlanoId(2) == null) {
            PlanoFactory planoFactory = new PlanoFactory();

            PlanoInterface planoBasico = planoFactory.criarPlano(TipoPlanoEnums.PLANO_BASICO);
            PlanoInterface planoIntermediario = planoFactory.criarPlano(TipoPlanoEnums.PLANO_INTERMEDIARIO);
            PlanoInterface planoAvancado = planoFactory.criarPlano(TipoPlanoEnums.PLANO_AVANCADO);

            //plano basico
            planoBasico.setId(0);
            planoBasico.setNome("Plano Basico");
            planoBasico.setDescricao("Plano Básico com benefícios limitados");
            planoBasico.setPeriodoMensalidade(30);
            planoBasico.setTipoPlano(TipoPlanoEnums.PLANO_BASICO);
            planoBasico.setBeneficio(obterBeneficiosPorPlano(TipoPlanoEnums.PLANO_BASICO));
            planoBasico.setPreco(obterPreco(TipoPlanoEnums.PLANO_BASICO));
            this.planoRepository.adicionarPlano(planoBasico.toModel());
            //plano basico

            //plano intermediario
            planoIntermediario.setId(1);
            planoIntermediario.setNome("Plano Intermediario");
            planoIntermediario.setDescricao("Plano Intermediário com benefícios intermediários");
            planoIntermediario.setPeriodoMensalidade(30);
            planoIntermediario.setTipoPlano(TipoPlanoEnums.PLANO_INTERMEDIARIO);
            planoIntermediario.setBeneficio(obterBeneficiosPorPlano(TipoPlanoEnums.PLANO_INTERMEDIARIO));
            planoIntermediario.setPreco(obterPreco(TipoPlanoEnums.PLANO_INTERMEDIARIO));
            this.planoRepository.adicionarPlano(planoIntermediario.toModel());
            //plano intermediario

            //plano avancado
            planoAvancado.setId(2);
            planoAvancado.setNome("Plano Avancado");
            planoAvancado.setDescricao("Plano Avançado com benefícios completos");
            planoAvancado.setPeriodoMensalidade(30);
            planoAvancado.setTipoPlano(TipoPlanoEnums.PLANO_AVANCADO);
            planoAvancado.setBeneficio(obterBeneficiosPorPlano(TipoPlanoEnums.PLANO_AVANCADO));
            planoAvancado.setPreco(obterPreco(TipoPlanoEnums.PLANO_AVANCADO));
            this.planoRepository.adicionarPlano(planoAvancado.toModel());
            //plano avancado
        }
        if(planoRepository.buscarPlanoId(planoModels.getId()) == null || planoRepository.buscarPlanoNome(planoModels.getNome()) == null){
            throw new IllegalArgumentException("Plano não pode ser nulo.");
        }
        this.planoRepository.adicionarPlano(planoModels);
    }

    public void atualizarPlano(PlanoModels planoModels){
        if(planoRepository.buscarPlanoId(planoModels.getId()) == null || planoRepository.buscarPlanoNome(planoModels.getNome()) == null){
            throw new IllegalArgumentException("Plano não pode ser nulo.");
        }
        this.planoRepository.atualizarPlano(planoModels);
    }

    public void removerPlano(int codigo){
        if(codigo < 0){
            throw new IllegalArgumentException("Código do plano não pode ser negativo.");
        }
        this.planoRepository.removerPlano(codigo);
    }

    public List<PlanoModels> buscar(){
        if(this.planoRepository.buscarPlano() == null){
            throw new IllegalArgumentException("Nenhum plano encontrado.");
        }
        return this.planoRepository.buscarPlano();
    }

    public PlanoModels buscarPlanoId(int codigo){
        if(codigo < 0){
            throw new IllegalArgumentException("Código do plano não pode ser negativo.");
        }
        return this.planoRepository.buscarPlanoId(codigo);
    }

    public List <PlanoModels> buscarPlanoNome(String nome){
        if(nome == null || nome.isEmpty()){
            throw new IllegalArgumentException("Nome do plano não pode ser nulo ou vazio.");
        }
        return this.planoRepository.buscarPlanoNome(nome);
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

