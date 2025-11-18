package model;

import Model.Cliente;
import Model.RangoCliente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ClienteTest {
    @Test
    public void calcularPuntosClienteTest(){
        Cliente c2 = new Cliente("2", "Eliza","Eliza@gmail.com", RangoCliente.BRONCE, 20000,"123");
        c2.setPuntosTotales(600);

        c2.calcularPuntosTotales();

        assertTrue(c2.getRango() == RangoCliente.PLATA);

    }
}
