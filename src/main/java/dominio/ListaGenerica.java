package dominio;

public class ListaGenerica<T> {

    private NodoLista<T> primero;
    private NodoLista<T> ultimo;

    public void agregarAlFinal(T dato) {
        NodoLista<T> nuevo = new NodoLista<>(dato);

        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSig(nuevo);
            ultimo = nuevo;
        }
    }

    public String serializarConSeparador(String separador) {
        String retorno = "";
        NodoLista<T> actual = primero;

        while (actual != null) {
            if (!retorno.isEmpty()) {
                retorno += separador;
            }
            retorno += actual.getDato().toString();
            actual = actual.getSig();
        }

        return retorno;
    }
}
