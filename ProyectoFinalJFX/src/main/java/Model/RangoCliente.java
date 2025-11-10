package Model;
import java.util.ArrayList;
import java.util.List;

public class RangoCliente {
    protected String tipoRango;
    protected List<Beneficio> beneficios;

    public RangoCliente(String tipoRango, List<Beneficio> beneficios) {
        this.tipoRango = tipoRango;
        this.beneficios = new ArrayList<>();
    }

    public String getTipoRango() {
        return tipoRango;
    }

    public void setTipoRango(String tipoRango) {
        this.tipoRango = tipoRango;
    }

    public List<Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<Beneficio> beneficios) {
        this.beneficios = beneficios;
    }
}
