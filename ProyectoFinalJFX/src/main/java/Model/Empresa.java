package Model;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private List<Cliente> listaClientes;
    private List<Transaccion> listaTransacciones;
    private List<Cuenta> listaCuentas;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.listaClientes = new ArrayList<>();
        this.listaTransacciones = new ArrayList<>();
        this.listaCuentas = new ArrayList<>();
    }

    public Cliente login(String documento, String contrasena){
        for(Cliente cliente : listaClientes){
            if(cliente.getIdCliente().equals(documento) && cliente.getContrasena().equals(contrasena)){
                return cliente;
            }
        }
        return null;
    }

    public void actualizarCliente(Cliente usuario){
        for(int i = 0; i < listaClientes.size(); i++){
            if(listaClientes.get(i).getIdCliente().equals(usuario.getIdCliente())){
                listaClientes.set(i, usuario);
                break;
            }
        }
    }

    public void agregarCliente(Cliente c){
        this.listaClientes.add(c);
    }

    public void agregarTransaccion(Transaccion transaccion){
        this.listaTransacciones.add(transaccion);
    }

    public void agregarCuenta(Cuenta c){
        this.listaCuentas.add(c);
    }

    public Cuenta getCuenta(String idCuenta){
        for (Cuenta cuenta : listaCuentas){
            if(cuenta.getIdCuenta().equals(idCuenta)){
                return cuenta;
            }
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public List<Transaccion> getListaTransacciones() {
        return listaTransacciones;
    }

    public void setListaTransacciones(List<Transaccion> listaTransacciones) {
        this.listaTransacciones = listaTransacciones;
    }

    public List<Cuenta> getListaCuentas() {
        return listaCuentas;
    }

    public void setListaCuentas(List<Cuenta> listaCuentas) {
        this.listaCuentas = listaCuentas;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "nombre='" + nombre + '\'' +
                ", listaClientes=" + listaClientes +
                '}';
    }
}
