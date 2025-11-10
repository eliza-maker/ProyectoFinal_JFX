package Model;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    protected String idCliente;
    protected String nombre;
    protected String email;
    protected int puntosTotales;
    protected RangoCliente rango;
    protected List<Monedero> listaMonederos;

    public Cliente(String idCliente, String nombre, String email, int puntosTotales, RangoCliente rango) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.email = email;
        this.puntosTotales = puntosTotales;
        this.rango = rango;
        this.listaMonederos = new ArrayList<>();

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

    public RangoCliente getRango() {
        return rango;
    }

    public void setRango(RangoCliente rango) {
        this.rango = rango;
    }

    public List<Monedero> getListaMonederos() {
        return listaMonederos;
    }

    public void setListaMonederos(List<Monedero> listaMonederos) {
        this.listaMonederos = listaMonederos;
    }
}
