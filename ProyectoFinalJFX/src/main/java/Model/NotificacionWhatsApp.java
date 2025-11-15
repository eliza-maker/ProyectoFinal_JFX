package Model;

public class NotificacionWhatsApp extends Notificacion {
    protected String numeroDestino;

    public NotificacionWhatsApp(String remitente, String plantillaMensaje, String numeroDestino) {
        super(remitente, plantillaMensaje);
        this.numeroDestino = numeroDestino;
    }

    public String getNumeroDestino() {
        return numeroDestino;
    }

    public void setNumeroDestino(String numeroDestino) {
        this.numeroDestino = numeroDestino;
    }

    @Override
    public void enviar(String mensaje, Cliente cliente) {

    }
}
