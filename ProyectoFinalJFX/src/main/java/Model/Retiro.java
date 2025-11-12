package Model;

import java.util.Date;

    public class Retiro extends Transaccion {
        private String metodoRetiro;
        private double comision;
        private boolean autorizacion;

        public Retiro(String idTransaccion, double monto, Date fecha, String tipo, String metodoRetiro, double comision, boolean autorizacion) {
            super(idTransaccion, fecha, monto, tipo);
            this.metodoRetiro = metodoRetiro;
            this.comision = comision;
            this.autorizacion = autorizacion;
        }

        public String getMetodoRetiro() {
            return metodoRetiro;
        }

        public void setMetodoRetiro(String metodoRetiro) {
            this.metodoRetiro = metodoRetiro;
        }

        public double getComision() {
            return comision;
        }

        public void setComision(double comision) {
            this.comision = comision;
        }

        public boolean getAutorizacion() {
            return autorizacion;
        }

        public void setAutorizacion(boolean autorizacion) {
            this.autorizacion = autorizacion;
        }
    }
