package com.geriaTeam.geriatricare.entities;

import java.util.ArrayList;
import java.util.List;

public class BeneficioPlano {

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

}