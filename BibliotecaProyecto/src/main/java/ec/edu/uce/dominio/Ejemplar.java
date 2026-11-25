package ec.edu.uce.dominio;

import java.util.Objects;

public class Ejemplar {
    private String codigoBarras;
    private String estado;
    private Libro libro;

    public Ejemplar() {
    }

    public Ejemplar(String codigoBarras, String estado, Libro libro) {
        this.codigoBarras = codigoBarras;
        this.estado = estado;
        this.libro = libro;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public boolean isDisponible() {
        return "DISPONIBLE".equalsIgnoreCase(this.estado);
    }

    public void setDisponible(boolean disponible) {
        this.estado = disponible ? "DISPONIBLE" : "PRESTADO";
    }

    @Override
    public String toString() {
        return "Ejemplar{" +
                "codigoBarras='" + codigoBarras + '\'' +
                ", estado='" + estado + '\'' +
                ", libro=" + (libro != null ? libro.getTitulo() : "null") +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Ejemplar ej) {
            return Objects.equals(codigoBarras, ej.codigoBarras);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoBarras);
    }
}