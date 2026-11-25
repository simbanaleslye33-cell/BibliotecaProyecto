package ec.edu.uce.dominio;

import java.time.LocalDate;

public class Prestamo {
    private String idPrestamo;
    private LocalDate fechaInicio;
    private LocalDate fechaLimite;
    private LocalDate fechaDevolucion;
    private Lector lector;
    private Ejemplar ejemplar;
    private Multa multa;

    public Prestamo() {
    }

    public Prestamo(String idPrestamo, LocalDate fechaInicio, LocalDate fechaLimite, LocalDate fechaDevolucion, Lector lector, Ejemplar ejemplar, Multa multa) {
        this.idPrestamo = idPrestamo;
        this.fechaInicio = fechaInicio;
        this.fechaLimite = fechaLimite;
        this.fechaDevolucion = fechaDevolucion;
        this.lector = lector;
        this.ejemplar = ejemplar;
        this.multa = multa;
    }

    public Prestamo(Lector lector, Ejemplar ejemplar, LocalDate fechaPrestamo) {
        this.lector = lector;
        this.ejemplar = ejemplar;
        this.fechaInicio = fechaPrestamo;
        this.fechaDevolucion = fechaPrestamo.plusDays(lector.calcularDiasPrestamo());
        if (ejemplar != null) {
            ejemplar.setDisponible(false);
        }
    }

    public String getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(String idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaLimite() {
        return fechaLimite;
    }

    public void setFechaLimite(LocalDate fechaLimite) {
        this.fechaLimite = fechaLimite;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Ejemplar getEjemplar() {
        return ejemplar;
    }

    public void setEjemplar(Ejemplar ejemplar) {
        this.ejemplar = ejemplar;
    }

    public Multa getMulta() {
        return multa;
    }

    public void setMulta(Multa multa) {
        this.multa = multa;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "idPrestamo='" + idPrestamo + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaLimite=" + fechaLimite +
                ", fechaDevolucion=" + fechaDevolucion +
                ", lector=" + (lector != null ? lector.getNombreCompleto() : "null") +
                ", ejemplar=" + (ejemplar != null ? ejemplar.getCodigoBarras() : "null") +
                ", multa=" + multa +
                '}';
    }
}