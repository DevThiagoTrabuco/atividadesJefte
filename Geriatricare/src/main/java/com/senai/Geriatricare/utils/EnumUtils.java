package utils;

public class EnumUtils {
    public static <E extends Enum<E>> boolean isValidEnum(Class<E> classe, String valor) {
        if (valor == null) return false;
        for (E constante : classe.getEnumConstants()) {
            if (constante.name().equalsIgnoreCase(valor)) {
                return true;
            }
        }
        return false;
    }

    public static <E extends Enum<E>> E getEnumIgnoreCase(Class<E> classe, String valor) {
        for (E constante : classe.getEnumConstants()) {
            if (constante.name().equalsIgnoreCase(valor)) {
                return constante;
            }
        }
        throw new IllegalArgumentException("Valor inválido para o enum " + classe.getSimpleName() + ": " + valor);
    }
}
