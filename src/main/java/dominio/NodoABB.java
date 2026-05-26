package dominio;

public class NodoABB<T> {

    private T dato;
    private NodoABB<T> izq;
    private NodoABB<T> der;

    public NodoABB(T dato) {
        this.dato = dato;
    }

    public T getDato() {
        return dato;
    }

    public NodoABB<T> getIzq() {
        return izq;
    }

    public void setIzq(NodoABB<T> izq) {
        this.izq = izq;
    }

    public NodoABB<T> getDer() {
        return der;
    }

    public void setDer(NodoABB<T> der) {
        this.der = der;
    }
}
