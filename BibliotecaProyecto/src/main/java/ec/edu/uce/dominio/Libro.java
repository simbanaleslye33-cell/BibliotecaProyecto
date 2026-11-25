package ec.edu.uce.dominio;

import java.util.Objects;

public class Libro {
    private String isbn;
    private String titulo;
    private String editorial;
    private int anioEdicion;
    private Ejemplar[] ejemplares;

    public Libro() {
    }

    public Libro(String isbn, String titulo, String editorial, int anioEdicion) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.editorial = editorial;
        this.anioEdicion = anioEdicion;
    }

    public Libro(String isbn, String titulo, int cantidadEjemplares) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.ejemplares = new Ejemplar[Math.max(cantidadEjemplares, 1)];
        for (int i = 0; i < ejemplares.length; i++) {
            ejemplares[i] = new Ejemplar(isbn + "-" + (i + 1), "DISPONIBLE", this);
        }
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(int anioEdicion) {
        this.anioEdicion = anioEdicion;
    }

    public Ejemplar buscarDisponible() {
        if (ejemplares == null) {
            return null;
        }
        for (Ejemplar e : ejemplares) {
            if (e != null && e.isDisponible()) {
                return e;
            }
        }
        return null;
    }

    public int contarDisponibles() {
        if (ejemplares == null) {
            return 0;
        }
        int n = 0;
        for (Ejemplar e : ejemplares) {
            if (e != null && e.isDisponible()) {
                n++;
            }
        }
        return n;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "isbn='" + isbn + '\'' +
                ", titulo='" + titulo + '\'' +
                ", editorial='" + editorial + '\'' +
                ", anioEdicion=" + anioEdicion +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Libro lib) {
            return Objects.equals(isbn, lib.isbn);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }
}