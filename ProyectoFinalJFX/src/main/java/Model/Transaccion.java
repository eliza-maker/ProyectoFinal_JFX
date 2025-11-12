package Model;

import java.util.Date;

public abstract class Transaccion {
        protected String idTransaccion;
        protected Date fecha;
        protected double monto;
        protected String tipo;

        public Transaccion(String idTransaccion, Date fecha, double monto, String tipo) {
            this.idTransaccion = idTransaccion;
            this.fecha = fecha;
            this.monto = monto;
            this.tipo = tipo;
        }

        public String getIdTransaccion() {
            return idTransaccion;
        }

        public void setIdTransaccion(String idTransaccion) {
            this.idTransaccion = idTransaccion;
        }

        public Date getFecha() {
            return fecha;
        }

        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }

        public double getMonto() {
            return monto;
        }

        public void setMonto(double monto) {
            this.monto = monto;
        }

        public String getTipo() {
            return tipo;
        }

        public void setTipo(String tipo) {
            this.tipo = tipo;
        }
    }

