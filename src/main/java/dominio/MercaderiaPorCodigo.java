package dominio;

import java.util.Objects;

public class MercaderiaPorCodigo implements Comparable<MercaderiaPorCodigo> {

    private final Mercaderia mercaderia;

    public MercaderiaPorCodigo(Mercaderia mercaderia) {
        this.mercaderia = mercaderia;
    }

    public Mercaderia getMercaderia() {
        return mercaderia;
    }

    @Override
    public int compareTo(MercaderiaPorCodigo otra) {
        return this.mercaderia.getCodigo().compareTo(otra.mercaderia.getCodigo());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MercaderiaPorCodigo otra = (MercaderiaPorCodigo) o;
        return Objects.equals(this.mercaderia.getCodigo(), otra.mercaderia.getCodigo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.mercaderia.getCodigo());
    }

    @Override
    public String toString() {
        return mercaderia.toValorString();
    }
}
