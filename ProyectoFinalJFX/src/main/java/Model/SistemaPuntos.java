package Model;

import java.util.List;
import java.util.Map;

public class SistemaPuntos {
    private Map<String, Integer> reglasPuntos;
    private List<String> historialPuntos;

    public SistemaPuntos(Map<String, Integer> reglasPuntos, List<String> historialPuntos) {
        this.reglasPuntos = reglasPuntos;
        this.historialPuntos = historialPuntos;
    }

    public Map<String, Integer> getReglasPuntos() {
        return reglasPuntos;
    }

    public void setReglasPuntos(Map<String, Integer> reglasPuntos) {
        this.reglasPuntos = reglasPuntos;
    }

    public List<String> getHistorialPuntos() {
        return historialPuntos;
    }

    public void setHistorialPuntos(List<String> historialPuntos) {
        this.historialPuntos = historialPuntos;
    }

    @Override
    public String toString() {
        return "SistemaPuntos{" +
                "reglasPuntos=" + reglasPuntos +
                ", historialPuntos=" + historialPuntos +
                '}';
    }
}
