package utils;

import java.util.regex.Pattern;

public class Pessoa {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    private static final Pattern CPF_PATTERN =
            Pattern.compile("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");

    private static final Pattern RG_PATTERN =
            Pattern.compile("\\d{2}\\.\\d{3}\\.\\d{3}-\\d{1}");

    public static boolean validaEmail(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    public static boolean validaCPF(String cpf) {
        if (cpf == null || !CPF_PATTERN.matcher(cpf).matches()) {
            return false;
        }

        cpf = cpf.replace(".", "").replace("-", "");

        if (cpf.chars().distinct().count() == 1) return false; // Ex: 000.000.000-00

        int num = 0;
        for (int i = 0; i < 9; i++) num += (cpf.charAt(i) - '0') * (10 - i);
        int primeiraChecagem = 11 - (num % 11);
        if (primeiraChecagem >= 10) primeiraChecagem = 0;
        if (primeiraChecagem != cpf.charAt(9) - '0') return false;

        num = 0;
        for (int i = 0; i < 10; i++) num += (cpf.charAt(i) - '0') * (11 - i);
        int segundaChecagem = 11 - (num % 11);
        if (segundaChecagem >= 10) segundaChecagem = 0;
        return segundaChecagem == cpf.charAt(10) - '0';
    }

    public static boolean validaRG(String rg) {
        if (rg == null || !RG_PATTERN.matcher(rg).matches()) {
            return false;
        }

        rg = rg.replace(".", "").replace("-", "");

        if (rg.chars().distinct().count() == 1) return false; // Ex: 00.000.000-0

        int num = 0;
        for (int i = 0; i < 8; i++) num += (rg.charAt(i) - '0') * (9 - i);
        int checagem = num % 11;
        if (checagem == 10) checagem = 'X';
        else checagem += '0';

        return checagem == rg.charAt(8);
    }

    public static boolean validaNome(String nome) {
        return nome != null && !nome.trim().isEmpty() && nome.matches("^[A-Z][a-zA-Zà-úÀ-Ú\\s'-]+$");
    }

    public static boolean validaTelefone(String telefone) {
        return telefone != null && telefone.matches("\\(?\\d{2}\\)? ?9?\\d{4}-?\\d{4}");
    }

    public static boolean validaDataNascimento(String dataNascimento) {
        if (dataNascimento == null || !dataNascimento.matches("\\d{2}/\\d{2}/\\d{4}")) {
            return false;
        }
        String[] partes = dataNascimento.split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int ano = Integer.parseInt(partes[2]);

        if (ano < 1900 || ano > 2023) return false;

        if (mes < 1 || mes > 12) return false;

        int[] diasPorMes = {31, (ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0)) ? 29 : 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return dia >= 1 && dia <= diasPorMes[mes - 1];
    }

    public static boolean validaSenha(String senha) {
        if (senha == null || senha.length() < 8) return false;
        boolean temLetraMaiuscula = false;
        boolean temLetraMinuscula = false;
        boolean temNumero = false;
        boolean temCaracterEspecial = false;

        for (char c : senha.toCharArray()) {
            if (Character.isUpperCase(c)) temLetraMaiuscula = true;
            else if (Character.isLowerCase(c)) temLetraMinuscula = true;
            else if (Character.isDigit(c)) temNumero = true;
            else if ("!@#$%^&*()-_=+[]{}|;:',.<>?/".indexOf(c) >= 0) temCaracterEspecial = true;
        }

        return temLetraMaiuscula && temLetraMinuscula && temNumero && temCaracterEspecial;
    }
}
