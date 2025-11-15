package Model;

public class NotificacionSMS extends Notificacion {
    protected String numeroRemitente;

    public NotificacionSMS(String remitente, String plantillaMensaje, String numeroRemitente) {
        super(remitente, plantillaMensaje);
        this.numeroRemitente = numeroRemitente;
    }

    public String getNumeroRemitente() {
        return numeroRemitente;
    }

    public void setNumeroRemitente(String numeroRemitente) {
        this.numeroRemitente = numeroRemitente;
    }

    @Override
    public void enviar(String mensaje, Cliente cliente) {

    }
}
