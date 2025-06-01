package utils;

import java.util.regex.Pattern;

public class Endereco {
    private static final Pattern CEP_PATTERN =
            Pattern.compile("\\d{5}-\\d{3}");

    private static final Pattern UF_PATTERN =
            Pattern.compile("^[A-Z]{2}$");

    public static boolean validaCEP(String cep) {
        return cep != null && CEP_PATTERN.matcher(cep).matches();
    }

    public static boolean validaEndereco(String rua, String numero, String bairro, String cidade, String uf) {
        return !nullOrEmpty(rua) &&
               !nullOrEmpty(numero) &&
               !nullOrEmpty(bairro) &&
               !nullOrEmpty(cidade) &&
               (uf == null || UF_PATTERN.matcher(uf).matches());
    }

    private static boolean nullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
