package Model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum RangoCliente {
    BRONCE(Arrays.asList(
            new Beneficio(1, "Sin beneficios", 0, 0)
    )),
    PLATA(Arrays.asList(
            new Beneficio(2, "10% descuento en transferencias", 500, 0.10)
    )),
    ORO(Arrays.asList(
            new Beneficio(3, "20% descuento y 1 mes sin comisión", 1000, 0.20)
    )),
    PLATINO(Arrays.asList(
            new Beneficio(4, "Bono de 50 unidades y 30% descuento", 5000, 0.30)
    ));

    private List<Beneficio> listaBeneficios;

    RangoCliente(List<Beneficio> listaBeneficios) {
        this.listaBeneficios = listaBeneficios;
    }

    public List<Beneficio> obtenerBeneficios() {
        return listaBeneficios;
    }

    public static RangoCliente actualizarRango(int puntos) {
        if (puntos <= 500) return BRONCE;
        else if (puntos <= 1000) return PLATA;
        else if (puntos <= 5000) return ORO;
        else return PLATINO;
    }
}
