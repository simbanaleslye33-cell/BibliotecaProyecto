package org.example;

import ec.edu.uce.dominio.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Lector a = new Estudiante("E1", "Eimy Alvarado", "ea@uce.edu.ec", true, "MAT001");
        Lector b = new Docente("D1", "Juan Perez", "", true, "Sistemas de Informacion ");
        Lector c = new Lector("L1", "Pepe Mora", "pm@uce.edu.ec", true);
        Lector d = new Estudiante("E1", "Eimy Alvarado", "ea@uce.edu.ec", true, "MAT001");

        imprimirFicha(a);
        imprimirFicha(b);
        imprimirFicha(c);

        System.out.println((a == d) + " " + (a.equals(d)) + " " +
                (a == b) + " " + a.equals(b) + " " +
                (a.hashCode() == d.hashCode()) + " " + (a.hashCode() == b.hashCode()));
        Estudiante est = (Estudiante) a;
        System.out.println(est);

        // LIBRO Y EJEMPLAR
        Libro lib1 = new Libro("978-3-16-148410-0", "Programacion en Java", "Pearson", 2024);
        Libro lib2 = new Libro("978-0-13-468599-1", "Effective Java", "Pearson", 2018);
        Libro lib3 = new Libro("978-3-16-148410-0", "Programacion en Java", "Pearson", 2024);

        Ejemplar ej1 = new Ejemplar("CB-001", "DISPONIBLE", lib1);
        Ejemplar ej2 = new Ejemplar("CB-002", "PRESTADO", lib2);
        Ejemplar ej3 = new Ejemplar("CB-001", "DISPONIBLE", lib1);

        System.out.println(ej1);
        System.out.println(ej2);
        System.out.println((lib1 == lib3) + " " + (lib1.equals(lib3)) + " " +
                (lib1 == lib2) + " " + lib1.equals(lib2) + " " +
                (lib1.hashCode() == lib3.hashCode()) + " " + (lib1.hashCode() == lib2.hashCode()));

        System.out.println((ej1 == ej3) + " " + (ej1.equals(ej3)) + " " +
                (ej1 == ej2) + " " + ej1.equals(ej2) + " " +
                (ej1.hashCode() == ej3.hashCode()) + " " + (ej1.hashCode() == ej2.hashCode()));

        // PRUEBAS DE BIBLIOTECA (CRUD Y ARREGLO POLIMÓRFICO)
        System.out.println("\n--- PRUEBAS DE BIBLIOTECA (CRUD) ---");
        Biblioteca biblioteca = new Biblioteca(5);
        System.out.println("Agregado E1: " + biblioteca.agregarLector(a));
        System.out.println("Agregado D1: " + biblioteca.agregarLector(b));
        System.out.println("Agregado L1: " + biblioteca.agregarLector(c));
        System.out.println("Agregado E1 duplicado: " + biblioteca.agregarLector(d));

        System.out.println("Total registrados: " + biblioteca.getCantidad());
        for (Lector lec : biblioteca.listarLectores()) {
            System.out.println("- " + lec.getNombreCompleto() + " (" + lec.calcularDiasPrestamo() + " días)");
        }

        biblioteca.actualizarNombre("L1", "Pepe Mora Actualizado");
        System.out.println("Buscado L1: " + biblioteca.buscarLector("L1"));

        biblioteca.eliminarLector("D1");
        System.out.println("Total tras eliminar D1: " + biblioteca.listarLectores().length);

        // PRUEBAS DE COMPOSICIÓN (LIBRO -> EJEMPLARES) Y PRÉSTAMO
        System.out.println("\n--- PRUEBAS DE COMPOSICIÓN Y PRÉSTAMO ---");
        Libro libroComposicion = new Libro("978-84-415", "Clean Code", 3);
        System.out.println("Disponibles antes del préstamo: " + libroComposicion.contarDisponibles());

        Ejemplar disponible = libroComposicion.buscarDisponible();
        if (disponible != null) {
            Prestamo prestamo = new Prestamo(a, disponible, LocalDate.now());
            System.out.println("Préstamo realizado a: " + prestamo.getLector().getNombreCompleto());
            System.out.println("Fecha devolución (7 días estudiante): " + prestamo.getFechaDevolucion());
            System.out.println("Disponibles después del préstamo: " + libroComposicion.contarDisponibles());
        }
    }

    public static void imprimirFicha(Lector lector) {
        System.out.println(lector + "\r\n" +
                lector.calcularDiasPrestamo() + " dias," +
                lector.calcularMulta(4, 20) + "Multa, " +
                lector.calcularMulta(10) + "Multa base");
    }
}