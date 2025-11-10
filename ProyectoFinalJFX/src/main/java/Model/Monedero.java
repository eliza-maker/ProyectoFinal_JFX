package Model;
import java.util.ArrayList;

public class Monedero {
    protected String idMonedero;
    protected double saldo;
    protected ArrayList<Transaccion> historialTransacciones;

    public Monedero(String idMonedero, double saldo) {
        this.idMonedero = idMonedero;
        this.saldo = saldo;
        this.historialTransacciones = new ArrayList<>();
    }

    public String getIdMonedero() {
        return idMonedero;
    }

    public void setIdMonedero(String idMonedero) {
        this.idMonedero = idMonedero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Transaccion> getHistorialTransacciones() {
        return historialTransacciones;
    }

    public void setHistorialTransacciones(ArrayList<Transaccion> historialTransacciones) {
        this.historialTransacciones = historialTransacciones;
    }
}
