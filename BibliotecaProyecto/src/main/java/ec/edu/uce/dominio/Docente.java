package ec.edu.uce.dominio;

public class Docente extends Lector {
    private String departamentoAcademico;

    public Docente() {
        super();
    }
    public Docente(String idLector, String nombreCompleto, String correoInstitucional, boolean estaActivo, String departamentoAcademico) {
        super(idLector, nombreCompleto, correoInstitucional, estaActivo);
        this.departamentoAcademico = departamentoAcademico;
    }

    public String getDepartamentoAcademico() {
        return departamentoAcademico;
    }

    public void setDepartamentoAcademico(String departamentoAcademico) {
        this.departamentoAcademico = departamentoAcademico;
    }

    @Override
    public String toString() {
        return "Docente{" +
                "super=" + super.toString() +
                ", departamentoAcademico='" + departamentoAcademico + '\'' +
                '}';
    }
    @Override
    public int calcularDiasPrestamo(){
        return 15;
    }

    public double calcularMulta(int diasRetraso, double tarifaDiaria){
        return super.calcularMulta(diasRetraso, tarifaDiaria) /2;
    }
}

