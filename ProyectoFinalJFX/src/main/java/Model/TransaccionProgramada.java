package Model;
    import java.time.Period;
    import java.util.Date;

    public abstract class TransaccionProgramada {
        private Date fechaEjecucion;
        private double monto;
        private Period frecuencia;


        public TransaccionProgramada(double monto, Date fechaEjecucion, Period frecuencia) {
            this.fechaEjecucion = fechaEjecucion;
            this.monto = monto;
            this.frecuencia = frecuencia;
        }

        public Date getFechaEjecucion() {
            return fechaEjecucion;
        }

        public void setFechaEjecucion(Date fechaEjecucion) {
            this.fechaEjecucion = fechaEjecucion;
        }

        public double getMonto() {
            return monto;
        }

        public void setMonto(double monto) {
            this.monto = monto;
        }

        public Period getFrecuencia() {
            return frecuencia;
        }

        public void setFrecuencia(Period frecuencia) {
            this.frecuencia = frecuencia;
        }

        //Metodo para ejecutar transferencia o deposito

        public abstract void ejecutar(Cuenta cuenta);
    }