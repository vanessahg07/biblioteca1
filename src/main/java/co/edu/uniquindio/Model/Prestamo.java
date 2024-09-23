package co.edu.uniquindio.Model;

import java.time.LocalDate;
import java.util.List;

public class Prestamo {
    private String codigo;
    private LocalDate fechaPrestamo;
    private LocalDate fechaEntrega;
    private double total;
    private Bibliotecario bibliotecario;  // Relación con Bibliotecario
    private Estudiante estudiante;        // Relación con Estudiante
    private List<DetallePrestamo> listaDetallePrestamo;

    public Prestamo(String codigo, LocalDate fechaPrestamo, Bibliotecario bibliotecario, Estudiante estudiante) {
        this.codigo = codigo;
        this.fechaPrestamo = fechaPrestamo;
        this.bibliotecario = bibliotecario;
        this.estudiante = estudiante;
    }

    // Getters y Setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }

    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public List<DetallePrestamo> getListaDetallePrestamo() {
        return listaDetallePrestamo;
    }

    public void setListaDetallePrestamo(List<DetallePrestamo> listaDetallePrestamo) {
        this.listaDetallePrestamo = listaDetallePrestamo;
    }

    Object getEstudiante() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    Object getEstudiante() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}