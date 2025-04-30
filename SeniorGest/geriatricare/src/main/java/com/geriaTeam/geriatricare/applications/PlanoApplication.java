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

import static com.geriaTeam.geriatricare.entities.enums.TipoPlanoEnums.PLANO_BASICO;

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
            //to do

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

    public static List<String> obterBeneficiosPlanoBasico() {
        List<String> beneficios = new ArrayList<>();
        beneficios.add("Consulta médica básica");
        beneficios.add("Exames laboratoriais simples");
        beneficios.add("Atendimento de urgência");
        beneficios.add("Descontos em farmácias");
        beneficios.add("Acesso a rede credenciada básica");
        beneficios.add("Atendimento telefônico 24h");
        beneficios.add("Orientação nutricional básica");
        beneficios.add("Acompanhamento de pressão arterial");
        beneficios.add("Vacinas básicas");
        beneficios.add("Check-up anual básico");

        // Adicionando mais 5 benefícios
        beneficios.add("Acesso a palestras de saúde");
        beneficios.add("Descontos em academias");
        beneficios.add("Acompanhamento psicológico inicial");
        beneficios.add("Plano odontológico básico");
        beneficios.add("Atendimento domiciliar emergencial");

        return beneficios;
    }

    public static List<String> obterBeneficiosPlanoIntermediario() {
        List<String> beneficios = obterBeneficiosPlanoBasico();

        // Adicionando mais 5 benefícios exclusivos do plano intermediário
        beneficios.add("Consultas com especialistas");
        beneficios.add("Exames de imagem avançados");
        beneficios.add("Internação em enfermaria");
        beneficios.add("Acompanhamento fisioterapêutico");
        beneficios.add("Cobertura para medicamentos específicos");

        return beneficios;
    }

    public static List<String> obterBeneficiosPlanoAvancado() {
        List<String> beneficios = obterBeneficiosPlanoIntermediario();

        // Adicionando mais 5 benefícios exclusivos do plano avançado
        beneficios.add("Internação em apartamento");
        beneficios.add("Cobertura internacional");
        beneficios.add("Acompanhamento médico VIP");
        beneficios.add("Plano odontológico avançado");
        beneficios.add("Transporte aéreo para emergências");

        return beneficios;
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

}

