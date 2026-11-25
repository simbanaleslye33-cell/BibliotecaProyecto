package ec.edu.uce.dominio;

import java.util.Objects;

public class Lector {
    private String idLector;
    private String nombreCompleto;
    private String correoInstitucional;
    private boolean estaActivo;

    public Lector() {
    }

    public Lector(String idLector, String nombreCompleto, String correoInstitucional, boolean estaActivo) {
        this.idLector = idLector;
        this.nombreCompleto = nombreCompleto;
        this.correoInstitucional = correoInstitucional;
        this.estaActivo = estaActivo;
    }

    public String getIdLector() {
        return idLector;
    }

    public void setIdLector(String idLector) {
        this.idLector = idLector;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public boolean isEstaActivo() {
        return estaActivo;
    }

    public void setEstaActivo(boolean estaActivo) {
        this.estaActivo = estaActivo;
    }

    @Override
    public String toString() {
        return "Lector{" +
                "idLector='" + idLector + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", correoInstitucional='" + correoInstitucional + '\'' +
                ", estaActivo=" + estaActivo +
                '}';
    }

    public int calcularDiasPrestamo() {
        return 5;
    }

    public double calcularMulta(int diasRetraso, double tarifaDiaria) {
        return diasRetraso * tarifaDiaria;
    }

    public double calcularMulta(int diasRetraso) {
        return calcularMulta(diasRetraso, 10);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Lector lec) {
            return Objects.equals(idLector, lec.idLector);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLector);
    }
}

