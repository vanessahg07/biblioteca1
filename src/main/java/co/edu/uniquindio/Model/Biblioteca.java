package co.edu.uniquindio.Model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nombre;
    private List<Bibliotecario> listaBibliotecarios;
    private List<Estudiante> listaEstudiantes;
    private List<Libro> listaLibros;
    private List<Prestamo> listaPrestamos;

    public Biblioteca() {
        this.listaBibliotecarios = new ArrayList<>();
        this.listaEstudiantes = new ArrayList<>();
        this.listaLibros = new ArrayList<>();
        this.listaPrestamos = new ArrayList<>();
    }

    // Método para crear un bibliotecario
    public void crearBibliotecario(Bibliotecario bibliotecario) {
        listaBibliotecarios.add(bibliotecario);
    }

    // Método para crear un estudiante
    public void crearEstudiante(Estudiante estudiante) {
        listaEstudiantes.add(estudiante);
    }

    // Método para crear un libro
    public void crearLibro(Libro libro) {
        listaLibros.add(libro);
    }

    // Método para consultar los datos de un libro dado su código
    public Libro consultarDatosLibro(String codigo) {
        for (Libro libro : listaLibros) {
            if (libro.getCodigo().equals(codigo)) {
                return libro;
            }
        }
        return null; // Si no encuentra el libro
    }

    // Método para consultar la cantidad de préstamos de un libro dado su título
    public int consultarLibroPrestamo(String titulo) {
        int contador = 0;
        for (Prestamo prestamo : listaPrestamos) {
            for (DetallePrestamo detalle : prestamo.getListaDetallePrestamo()) {
                if (detalle.getLibro().getTitulo().equals(titulo)) {
                    contador++;
                }
            }
        }
        return contador;
    }

    // Método para actualizar o reemplazar un libro por su código
    public void actualizarLibros(Libro nuevoLibro, String codigoAntiguo) {
        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getCodigo().equals(codigoAntiguo)) {
                listaLibros.set(i, nuevoLibro);
                return;
            }
        }
        System.out.println("Libro con código " + codigoAntiguo + " no encontrado.");
    }

    // Método para crear un préstamo
    public void crearPrestamo(Prestamo prestamo) {
        listaPrestamos.add(prestamo);
    }

    // Método para obtener el estudiante con más préstamos
    public Estudiante mostrarDatosEstMasPrestamo() {
        if (listaPrestamos.isEmpty()) {
            return null;
        }

        Estudiante estudianteConMasPrestamos = null;
        int maxPrestamos = 0;
        for (Estudiante estudiante : listaEstudiantes) {
            int prestamosEstudiante = 0;
            for (Prestamo prestamo : listaPrestamos) {
                if (prestamo.getEstudiante().getCedula().equals(estudiante.getCedula())) {
                    prestamosEstudiante++;
                }
            }
            if (prestamosEstudiante > maxPrestamos) {
                maxPrestamos = prestamosEstudiante;
                estudianteConMasPrestamos = estudiante;
            }
        }
        return estudianteConMasPrestamos;
    }

    // Método para calcular el total de dinero recaudado
    public double dineroRecaudado() {
        double total = 0;
        for (Prestamo prestamo : listaPrestamos) {
            total += prestamo.getTotal();
        }
        return total;
    }

    // Método para calcular el total a pagar a los bibliotecarios
    public double dineroPagarBibliotecarios() {
        double totalPagar = 0;
        for (Bibliotecario bibliotecario : listaBibliotecarios) {
            double totalPrestamos = 0;
            for (Prestamo prestamo : listaPrestamos) {
                if (prestamo.getBibliotecario().getCedula().equals(bibliotecario.getCedula())) {
                    totalPrestamos += prestamo.getTotal() * 0.20; // 20% del valor del préstamo
                }
            }
            int antiguedad = 2; // Ejemplo de antigüedad en años
            totalPagar += totalPrestamos + (totalPrestamos * 0.02 * antiguedad); // Bonificación 2% por año
        }
        return totalPagar;
    }
}
