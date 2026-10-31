package modelo;

// Lista circular (Sección C)
public class ListaReferencia {

    private NodoSimple primero;
    private NodoSimple ultimo;
    private NodoSimple actual;

    public boolean estaVacia() {
        return primero == null;
    }

    public void agregar(Libro libro) {
        NodoSimple nuevo = new NodoSimple(libro);
        if (primero == null) {
            primero = nuevo;
            actual = nuevo;
        } else {
            ultimo.siguiente = nuevo;
        }
        ultimo = nuevo;
        ultimo.siguiente = primero; // se cierra el círculo
    }

    // Regresa el libro actual y avanza
    public Libro siguiente() {
        if (primero == null) {
            return null;
        }
        Libro libro = actual.dato;
        actual = actual.siguiente;
        return libro;
    }

    public Libro buscarPorAutor(String autor) {
        if (primero == null) {
            return null;
        }
        return buscarRecursivo(primero, autor);
    }

    private Libro buscarRecursivo(NodoSimple nodo, String autor) {
        if (nodo.dato.getAutor().equalsIgnoreCase(autor)) {
            return nodo.dato;
        }
        if (nodo.siguiente == primero) {
            return null;
        }
        return buscarRecursivo(nodo.siguiente, autor);
    }
}
