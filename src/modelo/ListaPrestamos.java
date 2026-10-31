package modelo;

// Lista doble (Sección B)
public class ListaPrestamos {

    private NodoDoble primero;

    public void agregarAlInicio(Prestamo prestamo) {
        NodoDoble nuevo = new NodoDoble(prestamo);
        if (primero != null) {
            nuevo.siguiente = primero;
            primero.anterior = nuevo;
        }
        primero = nuevo;
    }

    public Prestamo buscarPorTitulo(String titulo) {
        NodoDoble actual = primero;
        while (actual != null) {
            if (actual.dato.getLibro().getTitulo().equalsIgnoreCase(titulo)) {
                return actual.dato;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public String mostrar() {
        if (primero == null) {
            return "No hay préstamos.";
        }
        String texto = "";
        NodoDoble actual = primero;
        while (actual != null) {
            texto += actual.dato + "\n";
            actual = actual.siguiente;
        }
        return texto;
    }

    public boolean devolver(String titulo) {
        NodoDoble actual = primero;
        while (actual != null) {
            if (actual.dato.getLibro().getTitulo().equalsIgnoreCase(titulo)) {
                if (actual.anterior == null) {
                    primero = actual.siguiente;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                }
                if (actual.siguiente != null) {
                    actual.siguiente.anterior = actual.anterior;
                }
                return true;
            }
            actual = actual.siguiente;
        }
        return false;
    }
}
