package Model;

import java.time.LocalDate;
import java.util.Date;

public abstract class Transaccion {
        private String idTransaccion;
        private LocalDate fecha;
        private double monto;
        private Cliente usuario;

        public Transaccion(String idTransaccion, LocalDate fecha, double monto,Cliente usuario) {
            this.idTransaccion = idTransaccion;
            this.fecha = fecha;
            this.monto = monto;
            this.usuario=usuario;
        }

        public String getIdTransaccion() {
            return idTransaccion;
        }

        public void setIdTransaccion(String idTransaccion) {
            this.idTransaccion = idTransaccion;
        }

        public LocalDate getFecha() {
            return fecha;
        }

        public void setFecha(LocalDate fecha) {
            this.fecha = fecha;
        }

        public double getMonto() {
            return monto;
        }

        public void setMonto(double monto) {
            this.monto = monto;
        }


    public Cliente getUsuario() {
        return usuario;
    }

    public void setUsuario(Cliente usuario) {
        this.usuario = usuario;
    }
}

