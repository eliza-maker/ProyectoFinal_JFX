package Model;

import java.time.LocalDate;
import java.util.Date;

public class Tranferencia extends Transaccion{
    Cliente usuarioReceptor;
    public Tranferencia(String idTransaccion, LocalDate fecha, double monto, Cliente usuario,Cliente usuarioReceptor) {
        super(idTransaccion, fecha, monto,usuario);
        this.usuarioReceptor= usuarioReceptor;
    }

}
