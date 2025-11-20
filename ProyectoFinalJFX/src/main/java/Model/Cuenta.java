package Model;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String idCuenta;
    private Cliente propietario;
    private List<Monedero> monederos;

    public Cuenta(String idCuenta, Cliente propietario) {
        this.idCuenta = idCuenta;
        this.propietario = propietario;
        this.monederos = new ArrayList<>();
    }

    public void actualizarMonedero(Monedero monedero){
        for (int i = 0; i < monederos.size(); i++){
            if(monederos.get(i).getIdMonedero().equals(monedero.getIdMonedero())){
                monederos.set(i, monedero);
                break;
            }
        }
    }

    public void agregarMonedero(Monedero monedero){
        this.monederos.add(monedero);
    }

    public Monedero getMoneder(String idMonedero){
        for (Monedero monedero : monederos){
            if(monedero.getIdMonedero().equals(idMonedero)){
                return monedero;
            }
        }
        return null;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Cliente getPropietario() {
        return propietario;
    }

    public void setPropietario(Cliente propietario) {
        this.propietario = propietario;
    }

    public List<Monedero> getMonederos() {
        return monederos;
    }

    public void setMonederos(List<Monedero> monederos) {
        this.monederos = monederos;
    }
}
