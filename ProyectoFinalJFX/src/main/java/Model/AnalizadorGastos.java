package Model;
import java.util.List;

public class AnalizadorGastos {
        private List<Transaccion> listaTransacciones;
        private Cliente cliente;

        public AnalizadorGastos(List<Transaccion> listaTransacciones, Cliente cliente) {
            this.listaTransacciones = listaTransacciones;
            this.cliente = cliente;
        }

        public List<Transaccion> getListaTransacciones() {
            return listaTransacciones;
        }

        public void setListaTransacciones(List<Transaccion> listaTransacciones) {
            this.listaTransacciones = listaTransacciones;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }
    }


