package modelo;

public class NodoDoble {

    public Prestamo dato;
    public NodoDoble anterior;
    public NodoDoble siguiente;

    public NodoDoble(Prestamo dato) {
        this.dato = dato;
    }
}
