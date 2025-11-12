package Model;

import java.util.Date;

public class Deposito extends Transaccion{
        private String medioDeposito;
        private double bonoPromocional;
        private String idConfirmacion;

        public Deposito(String idTransaccion, double monto, Date fecha, String tipo, String medioDeposito, double bonoPromocional, String idConfirmacion) {
            super(idTransaccion, fecha, monto, tipo);
            this.medioDeposito = medioDeposito;
            this.bonoPromocional = bonoPromocional;
            this.idConfirmacion = idConfirmacion;
        }

        public String getMedioDeposito() {
            return medioDeposito;
        }

        public void setMedioDeposito(String medioDeposito) {
            this.medioDeposito = medioDeposito;
        }

        public double getBonoPromocional() {
            return bonoPromocional;
        }

        public void setBonoPromocional(double bonoPromocional) {
            this.bonoPromocional = bonoPromocional;
        }

        public String getIdConfirmacion() {
            return idConfirmacion;
        }

        public void setIdConfirmacion(String idConfirmacion) {
            this.idConfirmacion = idConfirmacion;
        }
    }

