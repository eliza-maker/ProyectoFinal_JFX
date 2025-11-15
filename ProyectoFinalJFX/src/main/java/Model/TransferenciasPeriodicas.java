package Model;

import java.time.Period;
import java.util.Date;

public class TransferenciasPeriodicas extends TransaccionProgramada{
    protected Cuenta destino;

    public TransferenciasPeriodicas(double monto, Date fechaEjecucion, Period frecuencia, Cuenta destino) {
        super(monto, fechaEjecucion, frecuencia);
        this.destino = destino;
    }


    @Override
    public void ejecutar(Cuenta primaria) {

    }
}
