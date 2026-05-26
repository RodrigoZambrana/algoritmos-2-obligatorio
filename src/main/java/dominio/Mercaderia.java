package dominio;

import interfaz.Categoria;

public class Mercaderia {

    private final String id;
    private final String codigo;
    private final String descripcion;
    private final boolean fragil;
    private final Categoria categoria;

    public Mercaderia(String id, String codigo, String descripcion, boolean fragil, Categoria categoria) {
        this.id = id;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fragil = fragil;
        this.categoria = categoria;
    }

    public String getId() {
        return id;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isFragil() {
        return fragil;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String toValorString() {
        return id + ";" + codigo + ";" + descripcion + ";" + fragil + ";" + categoria.getTexto();
    }

    @Override
    public String toString() {
        return toValorString();
    }
}
