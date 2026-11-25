package ec.edu.uce.dominio;

import java.util.Arrays;

public class Biblioteca {
    private Lector[] lectores;
    private int cantidad;

    public Biblioteca() {
        this(5);
    }

    public Biblioteca(int tamano) {
        this.lectores = new Lector[tamano];
        this.cantidad = 0;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getCapacidad() {
        return lectores.length;
    }

    // CREATE
    public boolean agregarLector(Lector lector) {
        if (lector == null || lector.getIdLector() == null || lector.getIdLector().isBlank()) {
            return false;
        }
        if (cantidad >= lectores.length) {
            return false;
        }
        if (buscarLector(lector.getIdLector()) != null) {
            return false;
        }
        lectores[cantidad] = lector;
        cantidad++;
        return true;
    }

    // READ (uno)
    public Lector buscarLector(String idLector) {
        if (idLector == null) {
            return null;
        }
        for (int i = 0; i < cantidad; i++) {
            if (lectores[i] != null && idLector.equals(lectores[i].getIdLector())) {
                return lectores[i];
            }
        }
        return null;
    }

    // READ (todos)
    public Lector[] listarLectores() {
        return Arrays.copyOf(lectores, cantidad);
    }

    // UPDATE
    public boolean actualizarLector(String idLector, Lector lectorActualizado) {
        if (idLector == null || lectorActualizado == null) {
            return false;
        }
        for (int i = 0; i < cantidad; i++) {
            if (lectores[i] != null && idLector.equals(lectores[i].getIdLector())) {
                lectores[i] = lectorActualizado;
                return true;
            }
        }
        return false;
    }

    public boolean actualizarNombre(String idLector, String nuevoNombre) {
        Lector lector = buscarLector(idLector);
        if (lector == null) {
            return false;
        }
        lector.setNombreCompleto(nuevoNombre);
        return true;
    }

    // DELETE
    public boolean eliminarLector(String idLector) {
        if (idLector == null) {
            return false;
        }
        for (int i = 0; i < cantidad; i++) {
            if (lectores[i] != null && idLector.equals(lectores[i].getIdLector())) {
                for (int j = i; j < cantidad - 1; j++) {
                    lectores[j] = lectores[j + 1];
                }
                lectores[cantidad - 1] = null;
                cantidad--;
                return true;
            }
        }
        return false;
    }
}