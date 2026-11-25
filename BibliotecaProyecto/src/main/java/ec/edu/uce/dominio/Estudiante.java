package ec.edu.uce.dominio;

public class Estudiante extends Lector {
    private String codigoMatricula;

    public Estudiante() {
        super();
    }


    public Estudiante(String idLector, String nombreCompleto, String correoInstitucional, boolean estaActivo, String codigoMatricula) {
        super(idLector, nombreCompleto, correoInstitucional, estaActivo);
        this.codigoMatricula = codigoMatricula;
    }


    public String getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(String codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "super=" + super.toString() +
                ", codigoMatricula='" + codigoMatricula + '\'' +
                '}';
    }
    @Override
    public int calcularDiasPrestamo(){
        return 7;
    }
}


