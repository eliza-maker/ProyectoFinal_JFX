package Model;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    protected String idCliente;
    protected String nombre;
    protected String email;
    protected int puntosTotales;
    protected RangoCliente rango;
    protected SistemaPuntos sistemaPuntos;
    protected List<Monedero> listaMonederos;
    protected Notificable notificador;


    public Cliente(String idCliente, String nombre, String email,RangoCliente rango) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.email = email;
        this.puntosTotales = puntosTotales;
        this.rango = rango;
        this.sistemaPuntos=sistemaPuntos;
        this.listaMonederos = new ArrayList<>();
        this.notificador = notificador;

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
    }

    public Notificable getNotificador() {return notificador;}

    public void setNotificador(Notificable notificador) {this.notificador = notificador;}

    public RangoCliente getRango() {
        return rango;
    }

    public void setRango(RangoCliente rango) {
        this.rango = rango;
    }

    public SistemaPuntos getSistemaPuntos() {
        return sistemaPuntos;
    }

    public void setSistemaPuntos(SistemaPuntos sistemaPuntos) {
        this.sistemaPuntos = sistemaPuntos;
    }

    public List<Monedero> getListaMonederos() {
        return listaMonederos;
    }

    public void setListaMonederos(List<Monedero> listaMonederos) {
        this.listaMonederos = listaMonederos;
    }}




    /* public void agregarMonedero(Monedero monedero) {
        listaMonederos.add(monedero);
    }

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