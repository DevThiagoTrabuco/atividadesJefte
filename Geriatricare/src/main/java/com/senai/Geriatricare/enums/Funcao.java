package com.senai.Geriatricare.enums;

public enum Funcao {
    ADMINISTRATIVO("Administrativo"),
    MEDICO("Médico"),
    ENFERMEIRO("Enfermeiro"),
    TECNICO_EM_ENFERMAGEM("Técnico em Enfermagem"),
    CUIDADOR("Cuidador"),
    FISIOTERAPEUTA("Fisioterapeuta"),
    NUTRICIONISTA("Nutricionista"),
    SERVICOS_GERAIS("Serviços Gerais"),;

    private final String funcao;

    Funcao(String funcao) {
        this.funcao = funcao;
    }

    public String getFuncao() {
        return funcao;
    }
}
