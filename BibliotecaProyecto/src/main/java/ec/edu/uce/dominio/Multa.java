package ec.edu.uce.dominio;

public class Multa {
    private String idMulta;
    private int diasAtraso;
    private double valorAPagar;
    private boolean pagada;

    public Multa() {
    }

    public Multa(String idMulta, int diasAtraso, double valorAPagar, boolean pagada) {
        this.idMulta = idMulta;
        this.diasAtraso = diasAtraso;
        this.valorAPagar = valorAPagar;
        this.pagada = pagada;
    }

    public String getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(String idMulta) {
        this.idMulta = idMulta;
    }

    public int getDiasAtraso() {
        return diasAtraso;
    }

    public void setDiasAtraso(int diasAtraso) {
        this.diasAtraso = diasAtraso;
    }

    public double getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(double valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    @Override
    public String toString() {
        return "Multa{" +
                "idMulta='" + idMulta + '\'' +
                ", diasAtraso=" + diasAtraso +
                ", valorAPagar=" + valorAPagar +
                ", pagada=" + pagada +
                '}';
    }
}

