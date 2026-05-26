package dominio;

import interfaz.Categoria;

public class ValidadorMercaderia {

    private static final String REGEX_CODIGO = "^[A-Za-z]{2}-\\d{3}-[A-Za-z0-9]{6}$";

    private ValidadorMercaderia() {
    }

    public static boolean hayParametrosVaciosONull(String id, String codigo, String descripcion, Categoria categoria) {
        return esVacioONull(id) || esVacioONull(codigo) || esVacioONull(descripcion) || categoria == null;
    }

    public static boolean codigoTieneFormatoValido(String codigo) {
        return codigo != null && codigo.matches(REGEX_CODIGO);
    }

    private static boolean esVacioONull(String valor) {
        return valor == null || valor.trim().isEmpty();
    }
}
