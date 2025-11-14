package Model;

import java.util.Date;

public class Tranferencia extends Transaccion{
    public Tranferencia(String idTransaccion, Date fecha, double monto, String tipo) {
        super(idTransaccion, fecha, monto, tipo);
    }
}
