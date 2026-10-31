package controlador;

import modelo.Libro;
import modelo.ListaLibrosNuevos;
import modelo.ListaPrestamos;
import modelo.ListaReferencia;
import modelo.Prestamo;
import vista.VistaConsola;

public class ControladorBiblioteca {

    private VistaConsola vista = new VistaConsola();
    private ListaLibrosNuevos nuevos = new ListaLibrosNuevos();
    private ListaPrestamos prestamos = new ListaPrestamos();
    private ListaReferencia referencia = new ListaReferencia();

    public void iniciar() {
        int opcion = -1;
        while (opcion != 0) {
            vista.menuPrincipal();
            opcion = vista.leerOpcion();
            if (opcion == 1) {
                menuLibrosNuevos();
            } else if (opcion == 2) {
                menuPrestamos();
            } else if (opcion == 3) {
                menuReferencia();
            } else if (opcion != 0) {
                vista.mostrar("Opción no válida");
            }
        }
        vista.mostrar("Adiós");
    }

    // Sección A
    private void menuLibrosNuevos() {
        int opcion = -1;
        while (opcion != 0) {
            vista.menuLibrosNuevos();
            opcion = vista.leerOpcion();
            if (opcion == 1) {
                agregarNuevo();
            } else if (opcion == 2) {
                vista.mostrar(nuevos.mostrar());
            } else if (opcion == 3) {
                buscarPorCodigo();
            } else if (opcion == 4) {
                eliminarUltimo();
            } else if (opcion != 0) {
                vista.mostrar("Opción no válida");
            }
        }
    }

    private void agregarNuevo() {
        String codigo = vista.leerTexto("Código: ");
        String titulo = vista.leerTexto("Título: ");
        String autor = vista.leerTexto("Autor: ");
        if (nuevos.agregar(new Libro(codigo, titulo, autor))) {
            vista.mostrar("Libro agregado");
        } else {
            vista.mostrar("La lista está llena (20 libros)");
        }
    }

    private void buscarPorCodigo() {
        String codigo = vista.leerTexto("Código: ");
        Libro libro = nuevos.buscarPorCodigo(codigo);
        if (libro != null) {
            vista.mostrar("Encontrado: " + libro);
        } else {
            vista.mostrar("No existe ese código");
        }
    }

    private void eliminarUltimo() {
        Libro libro = nuevos.eliminarUltimo();
        if (libro != null) {
            vista.mostrar("Eliminado: " + libro);
        } else {
            vista.mostrar("No hay libros");
        }
    }

    // Sección B
    private void menuPrestamos() {
        int opcion = -1;
        while (opcion != 0) {
            vista.menuPrestamos();
            opcion = vista.leerOpcion();
            if (opcion == 1) {
                registrarPrestamo();
            } else if (opcion == 2) {
                buscarPorTitulo();
            } else if (opcion == 3) {
                vista.mostrar(prestamos.mostrar());
            } else if (opcion == 4) {
                devolverLibro();
            } else if (opcion != 0) {
                vista.mostrar("Opción no válida");
            }
        }
    }

    private void registrarPrestamo() {
        String codigo = vista.leerTexto("Código: ");
        String titulo = vista.leerTexto("Título: ");
        String autor = vista.leerTexto("Autor: ");
        String usuario = vista.leerTexto("Usuario: ");
        Libro libro = new Libro(codigo, titulo, autor);
        prestamos.agregarAlInicio(new Prestamo(libro, usuario));
        vista.mostrar("Préstamo registrado");
    }

    private void buscarPorTitulo() {
        String titulo = vista.leerTexto("Título: ");
        Prestamo prestamo = prestamos.buscarPorTitulo(titulo);
        if (prestamo != null) {
            vista.mostrar("Encontrado: " + prestamo);
        } else {
            vista.mostrar("Ese libro no está prestado");
        }
    }

    private void devolverLibro() {
        String titulo = vista.leerTexto("Título: ");
        if (prestamos.devolver(titulo)) {
            vista.mostrar("Libro devuelto");
        } else {
            vista.mostrar("Ese libro no está prestado");
        }
    }

    // Sección C
    private void menuReferencia() {
        int opcion = -1;
        while (opcion != 0) {
            vista.menuReferencia();
            opcion = vista.leerOpcion();
            if (opcion == 1) {
                agregarReferencia();
            } else if (opcion == 2) {
                mostrarSiguiente();
            } else if (opcion == 3) {
                buscarPorAutor();
            } else if (opcion == 4) {
                verificarVacia();
            } else if (opcion != 0) {
                vista.mostrar("Opción no válida");
            }
        }
    }

    private void agregarReferencia() {
        String codigo = vista.leerTexto("Código: ");
        String titulo = vista.leerTexto("Título: ");
        String autor = vista.leerTexto("Autor: ");
        referencia.agregar(new Libro(codigo, titulo, autor));
        vista.mostrar("Libro agregado");
    }

    private void mostrarSiguiente() {
        Libro libro = referencia.siguiente();
        if (libro != null) {
            vista.mostrar("Siguiente: " + libro);
        } else {
            vista.mostrar("No hay libros");
        }
    }

    private void buscarPorAutor() {
        String autor = vista.leerTexto("Autor: ");
        Libro libro = referencia.buscarPorAutor(autor);
        if (libro != null) {
            vista.mostrar("Encontrado: " + libro);
        } else {
            vista.mostrar("No hay libros de ese autor");
        }
    }

    private void verificarVacia() {
        if (referencia.estaVacia()) {
            vista.mostrar("La lista está vacía");
        } else {
            vista.mostrar("La lista tiene libros");
        }
    }
}
