package Model;

public class Beneficio {
    private int idBeneficio;
    private String descripcion;
    private int puntosRequeridos;
    private double descuento;

    public Beneficio(int idBeneficio, String descripcion, int puntosRequeridos, double descuento) {
        this.idBeneficio = idBeneficio;
        this.descripcion = descripcion;
        this.puntosRequeridos = puntosRequeridos;
        this.descuento = descuento;
    }

    public int getIdBeneficio() {
        return idBeneficio;
    }

    public int getPuntosRequeridos() {
        return puntosRequeridos;
    }

    public double getDescuento() {
        return descuento;
    }

    public String getDescripcion() {
        return descripcion; }


    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public void setPuntosRequeridos(int puntosRequeridos) {
        this.puntosRequeridos = puntosRequeridos;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setIdBeneficio(int idBeneficio) {
        this.idBeneficio = idBeneficio;
    }

    public void aplicarBeneficio() {
        System.out.println("Aplicando beneficio: " + descripcion +
                " (Descuento: " + descuento + ")");
    }

    @Override
    public String toString() {
        return "Beneficio{" +
                "idBeneficio=" + idBeneficio +
                ", descripcion='" + descripcion + '\'' +
                ", puntosRequeridos=" + puntosRequeridos +
                ", descuento=" + descuento +
                '}';
    }
}
