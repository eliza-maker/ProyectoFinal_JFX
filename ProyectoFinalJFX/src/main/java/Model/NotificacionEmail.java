package Model;

public class NotificacionEmail extends Notificacion {
    protected String correoDestino;

    public NotificacionEmail(String remitente, String plantillaMensaje, String correoDestino) {
        super(remitente, plantillaMensaje);
        this.correoDestino = correoDestino;
    }

    public String getCorreoDestino() {
        return correoDestino;
    }

    public void setCorreoDestino(String correoDestino) {
        this.correoDestino = correoDestino;
    }

    @Override
    public void enviar(String mensaje, Cliente cliente) {

    }
}
