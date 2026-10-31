package modelo;

// Lista simple (Sección A)
public class ListaLibrosNuevos {

    private NodoSimple primero;
    private int cantidad = 0;

    public boolean agregar(Libro libro) {
        if (cantidad == 20) {
            return false;
        }
        NodoSimple nuevo = new NodoSimple(libro);
        if (primero == null) {
            primero = nuevo;
        } else {
            NodoSimple actual = primero;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        cantidad++;
        return true;
    }

    public String mostrar() {
        if (primero == null) {
            return "No hay libros.";
        }
        String texto = "";
        NodoSimple actual = primero;
        while (actual != null) {
            texto += actual.dato + "\n";
            actual = actual.siguiente;
        }
        return texto;
    }

    public Libro buscarPorCodigo(String codigo) {
        NodoSimple actual = primero;
        while (actual != null) {
            if (actual.dato.getCodigo().equalsIgnoreCase(codigo)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    // Quita el último libro (LIFO)
    public Libro eliminarUltimo() {
        if (primero == null) {
            return null;
        }
        Libro eliminado;
        if (primero.siguiente == null) {
            eliminado = primero.dato;
            primero = null;
        } else {
            NodoSimple actual = primero;
            while (actual.siguiente.siguiente != null) {
                actual = actual.siguiente;
            }
            eliminado = actual.siguiente.dato;
            actual.siguiente = null;
        }
        cantidad--;
        return eliminado;
    }
}
