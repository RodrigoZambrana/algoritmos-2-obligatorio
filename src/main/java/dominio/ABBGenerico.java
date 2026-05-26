package dominio;

public class ABBGenerico<T extends Comparable<T>> {

    private NodoABB<T> raiz;

    public void insertar(T dato) {
        if (raiz == null) {
            raiz = new NodoABB<>(dato);
        } else {
            insertarRec(raiz, dato);
        }
    }

    private void insertarRec(NodoABB<T> nodo, T dato) {
        int comparacion = dato.compareTo(nodo.getDato());

        if (comparacion > 0) {
            if (nodo.getDer() == null) {
                nodo.setDer(new NodoABB<>(dato));
            } else {
                insertarRec(nodo.getDer(), dato);
            }
        } else if (comparacion < 0) {
            if (nodo.getIzq() == null) {
                nodo.setIzq(new NodoABB<>(dato));
            } else {
                insertarRec(nodo.getIzq(), dato);
            }
        }
    }

    public T obtener(T dato) {
        return obtenerRec(raiz, dato);
    }

    private T obtenerRec(NodoABB<T> nodo, T dato) {
        if (nodo == null) {
            return null;
        }

        int comparacion = dato.compareTo(nodo.getDato());

        if (comparacion == 0) {
            return nodo.getDato();
        }

        if (comparacion > 0) {
            return obtenerRec(nodo.getDer(), dato);
        }

        return obtenerRec(nodo.getIzq(), dato);
    }
}
