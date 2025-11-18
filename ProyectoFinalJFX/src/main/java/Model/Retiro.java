package Model;

import java.time.LocalDate;
import java.util.UUID;

public class Retiro extends Transaccion {
        private String metodoRetiro;
        private boolean autorizacion;

        public Retiro(String idTransaccion, double monto, LocalDate fecha, String metodoRetiro, boolean autorizacion, Cliente usuario) {
            super(idTransaccion, fecha, monto, usuario);
            this.metodoRetiro = metodoRetiro;
            this.autorizacion = autorizacion;
        }

        public String getMetodoRetiro() {
            return metodoRetiro;
        }

        public void setMetodoRetiro(String metodoRetiro) {
            this.metodoRetiro = metodoRetiro;
        }

        public boolean getAutorizacion() {
            return autorizacion;
        }

        public void setAutorizacion(boolean autorizacion) {
            this.autorizacion = autorizacion;
        }
    }
