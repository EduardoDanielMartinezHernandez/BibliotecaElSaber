package modelo;

public class Prestamo {

    private Libro libro;
    private String usuario;

    public Prestamo(Libro libro, String usuario) {
        this.libro = libro;
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public String toString() {
        return libro + " | Usuario: " + usuario;
    }
}
