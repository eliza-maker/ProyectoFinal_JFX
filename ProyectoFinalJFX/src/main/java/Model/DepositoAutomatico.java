package Model;

import java.time.Period;
import java.util.Date;

public class DepositoAutomatico extends TransaccionProgramada{
    protected String medioDeposito;

    public DepositoAutomatico(double monto, Date fechaEjecucion, Period frecuencia) {
        super(monto, fechaEjecucion, frecuencia);
    }

    @Override
    public void ejecutar(Cuenta cuenta) {

    }
}
