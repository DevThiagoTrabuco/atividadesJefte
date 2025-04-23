package com.geriaTeam.geriatricare.generics;

import java.time.LocalDateTime;

public class Generics {

    // Método genérico para validar ID
    public static boolean validarId(int id) {
        return id > 0;
    }

    // Método genérico para validar nome
    public static boolean validarNome(String nome) {
        return nome != null && !nome.isBlank() && nome.length() <= 100;
    }

    // Método genérico para validar data de nascimento
    public static boolean validarDataNascimento(LocalDateTime nascimento) {
        return nascimento != null && nascimento.isBefore(LocalDateTime.now());
    }

    // Método genérico para validar e-mail
    public static boolean validarEmail(String email) {
        return email != null && email.contains("@") && email.length() <= 100;
    }

    // Método genérico para validar telefone
    public static boolean validarTelefone(String telefone) {
        return telefone != null && telefone.matches("\\d{10,15}");
    }

    // Método genérico para validar descricao
    public static boolean validarDescricao(String descricao) {
        return descricao != null && !descricao.isBlank() && descricao.length() <= 255;
    }

    // Método genérico para validar CPF
    public static boolean validarCpf(String cpf) {
        return cpf != null && cpf.matches("\\d{11}");
    }

    // Método genérico para validar RG
    public static boolean validarRg(String rg) {
        return rg != null && rg.matches("\\d{7,10}");
    }

    // Método genérico para validar endereço
    public static boolean validarEndereco(String endereco) {
        return endereco != null && !endereco.isBlank() && endereco.length() <= 255;
    }

    // Método genérico para validar data de entrada
    public static boolean validarDataEntrada(LocalDateTime entrada) {
        return entrada != null && entrada.isBefore(LocalDateTime.now());
    }

    // Método genérico para validar data de saída
    public static boolean validarDataSaida(LocalDateTime saida) {
        return saida != null && saida.isAfter(LocalDateTime.now());
    }

}