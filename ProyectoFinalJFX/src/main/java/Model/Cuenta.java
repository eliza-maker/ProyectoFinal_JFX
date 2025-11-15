package Model;

import java.util.List;

public class Cuenta {
    private String idCuenta;
    private Cliente propietario;
    private List<Monedero> monederos;

    public Cuenta(String idCuenta, Cliente propietario) {
        this.idCuenta = idCuenta;
        this.propietario = propietario;
        this.monederos = monederos;
    }
}
