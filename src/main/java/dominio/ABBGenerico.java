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

    public T obtenerConPasos(T dato, Contador contador) {
        return obtenerConPasosRec(raiz, dato, contador);
    }

    private T obtenerConPasosRec(NodoABB<T> nodo, T dato, Contador contador) {
        if (nodo == null) {
            return null;
        }

        contador.incrementar();

        int comparacion = dato.compareTo(nodo.getDato());

        if (comparacion == 0) {
            return nodo.getDato();
        }

        if (comparacion > 0) {
            return obtenerConPasosRec(nodo.getDer(), dato, contador);
        }

        return obtenerConPasosRec(nodo.getIzq(), dato, contador);
    }

    public ListaGenerica<T> aplanarAscendente() {
        ListaGenerica<T> lista = new ListaGenerica<>();
        aplanarAscendenteRec(raiz, lista);
        return lista;
    }

    private void aplanarAscendenteRec(NodoABB<T> nodo, ListaGenerica<T> lista) {
        if (nodo != null) {
            aplanarAscendenteRec(nodo.getIzq(), lista);
            lista.agregarAlFinal(nodo.getDato());
            aplanarAscendenteRec(nodo.getDer(), lista);
        }
    }

    public ListaGenerica<T> aplanarDescendente() {
        ListaGenerica<T> lista = new ListaGenerica<>();
        aplanarDescendenteRec(raiz, lista);
        return lista;
    }

    private void aplanarDescendenteRec(NodoABB<T> nodo, ListaGenerica<T> lista) {
        if (nodo != null) {
            aplanarDescendenteRec(nodo.getDer(), lista);
            lista.agregarAlFinal(nodo.getDato());
            aplanarDescendenteRec(nodo.getIzq(), lista);
        }
    }
}
