package Model;
    import java.util.Date;

    public class TransaccionProgramada extends Transaccion {
        private Date fechaEjecucion;
        private boolean recurrente;

        public TransaccionProgramada(String idTransaccion, double monto, Date fecha, String tipo, Date fechaEjecucion, boolean recurrente) {
            super(idTransaccion, fecha, monto, tipo);
            this.fechaEjecucion = fechaEjecucion;
            this.recurrente = recurrente;
        }

        public Date getFechaEjecucion() {
            return fechaEjecucion;
        }

        public void setFechaEjecucion(Date fechaEjecucion) {
            this.fechaEjecucion = fechaEjecucion;
        }

        public boolean getRecurrente() {
            return recurrente;
        }

        public void setRecurrente(boolean recurrente) {
            this.recurrente = recurrente;
        }
    }