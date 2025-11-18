package model;

import Model.Cliente;
import Model.Empresa;
import Model.RangoCliente;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para probar los metodos login y actualizar de Empresa
 * @author Área de programación UQ
 * @since 2023-08
 *
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
 */


public class EmpresaTest {

    @Test
    public void LoginEmpresa(){
        Cliente cliente = new Cliente("2", "Eliza","Eliza@gmail.com", RangoCliente.BRONCE, 20000,"123");
        Empresa empresa = new Empresa("UQ");

        LinkedList<Cliente> lista = new LinkedList<>();
        lista.add(cliente);

        empresa.setListaClientes(lista);

        assertThrows(IllegalArgumentException.class,() -> empresa.login("999", "claveIncorrecta"));

    }

    @Test
    public void ActualizarClienteTest(){
        Cliente clienteOriginal = new Cliente("1", "Isa","isa@gmail.com", RangoCliente.BRONCE, 50000,"123");;

        Empresa empresa = new Empresa("Nequi");
        LinkedList<Cliente> lista = new LinkedList<>();
        lista.add(clienteOriginal);
        empresa.setListaClientes(lista);

        Cliente clienteActualizado = new Cliente("1", "Isa","isa@gmail.com", RangoCliente.PLATA, 50000,"333");

        empresa.actualizarCliente(clienteActualizado);

        assertEquals(clienteActualizado, empresa.getListaClientes().get(0));
    }

    @Test
    public void agregarClienteTest(){
        Empresa empresa = new Empresa("Nequi");
        empresa.setListaClientes(new LinkedList<>());

        Cliente cliente = new Cliente("2", "Eliza","Eliza@gmail.com", RangoCliente.BRONCE, 20000,"123");

        empresa.agregarCliente(cliente);

        assertNotNull(empresa.getListaClientes().get(0));
    }

    //AgregarClienteTest aplica para las pruebas de los demas metodos de agregar



}
