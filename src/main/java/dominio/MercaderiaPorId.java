package dominio;

import java.util.Objects;

public class MercaderiaPorId implements Comparable<MercaderiaPorId> {

    private final Mercaderia mercaderia;

    public MercaderiaPorId(Mercaderia mercaderia) {
        this.mercaderia = mercaderia;
    }

    public Mercaderia getMercaderia() {
        return mercaderia;
    }

    @Override
    public int compareTo(MercaderiaPorId otra) {
        return this.mercaderia.getId().compareTo(otra.mercaderia.getId());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MercaderiaPorId otra = (MercaderiaPorId) o;
        return Objects.equals(this.mercaderia.getId(), otra.mercaderia.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.mercaderia.getId());
    }

    @Override
    public String toString() {
        return mercaderia.toValorString();
    }
}
