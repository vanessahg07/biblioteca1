package co.edu.uniquindio.Model;

public class DetallePrestamo {
    private Libro libro;
    private double subTotal;
    private int cantidad;

    // Constructor
    public DetallePrestamo(Libro libro, int cantidad) {
        this.libro = libro;
        this.cantidad = cantidad;
        this.subTotal = calcularSubTotal();
    }

    // Getters y setters
    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // Métodos
    private double calcularSubTotal() {
        return libro.getPrecio() * cantidad;
    }
}

