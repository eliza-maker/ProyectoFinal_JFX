package Model;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String idCliente;
    private String nombre;
    private String email;
    private int puntosTotales;
    private RangoCliente rango;
    private double saldo;
    private String contrasena;
    private boolean beneficio;

    public Cliente(String idCliente, String nombre, String email,RangoCliente rango, double saldo, String contrasena) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.email = email;
        this.puntosTotales = 0;
        this.rango = rango;
        this.saldo = saldo;
        this.contrasena = contrasena;
        this.beneficio=false;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPuntosTotales() {
        return puntosTotales;
    }

    public void setPuntosTotales(int puntosTotales) {
        this.puntosTotales = puntosTotales;
        calcularPuntosTotales();
    }

    public void calcularPuntosTotales(){
        if (this.puntosTotales > 500 && this.puntosTotales < 1000) {
            setRango(RangoCliente.PLATA);
        }else if (this.puntosTotales > 1000 && this.puntosTotales < 5000) {
            setRango(RangoCliente.ORO);
        }else if (this.puntosTotales > 5000) {
            setRango(RangoCliente.PLATINO);
        }else{
            setRango(RangoCliente.BRONCE);
        }
    }

    public RangoCliente getRango() {
        return rango;
    }

    public void setRango(RangoCliente rango) {
        this.rango = rango;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean getBeneficio() {
        return beneficio;
    }

    public void setBeneficio(boolean beneficio) {
        this.beneficio = beneficio;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente='" + idCliente + '\'' +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", puntosTotales=" + puntosTotales +
                ", rango=" + rango +
                ", saldo=" + saldo +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }

    /*
    public void realizarTransaccion(Transaccion transaccion) {
        transaccion.ejecutar();
        int puntosGanados = transaccion.calcularPuntos();
        sistemaPuntos.acumularPuntos(this, puntosGanados);
    }

    public double consultarSaldoTotal() {
        double total = 0;
        for (Monedero c : listaMonederos) {
            total += c.getSaldo();
        }
        return total;
    }

    public void consultarHistorial() {
        for (Monedero c : listaMonederos) {
            c.mostrarHistorial();
        }
    }

    public void canjearPuntos(Beneficio beneficio) {
        sistemaPuntos.canjearPuntos(this, beneficio);
    }


}
*/
}