package Model;

public abstract class Notificacion implements Notificable{
    protected String remitente;
    protected String plantillaMensaje;

    public Notificacion(String remitente, String plantillaMensaje) {
        this.remitente = remitente;
        this.plantillaMensaje = plantillaMensaje;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getPlantillaMensaje() {
        return plantillaMensaje;
    }

    public void setPlantillaMensaje(String plantillaMensaje) {
        this.plantillaMensaje = plantillaMensaje;
    }

}
