package dominio;

public class NodoLista<T> {

    private final T dato;
    private NodoLista<T> sig;

    public NodoLista(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public NodoLista<T> getSig() {
        return sig;
    }

    public void setSig(NodoLista<T> sig) {
        this.sig = sig;
    }
}
