package cl.praxis.servicio;

import cl.praxis.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteServicio {
    private List<Cliente> listaClientes;

    public ClienteServicio() {
        this.listaClientes = new ArrayList<>();
    }

    public void listarClientes() {
        for (Cliente cliente : listaClientes){
            System.out.println(cliente);
        }
    }

    public void agregarCliente(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("El cliente no puede ser null");
        }
        listaClientes.add(cliente);
    }

    public void editarCliente(String runCliente, Cliente clienteActualizado) {
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).getRunCliente().equals(runCliente)) {
                listaClientes.set(i, clienteActualizado);
                break;
            }
        }
    }

    public Cliente buscarCliente(String runCliente) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getRunCliente().equals(runCliente)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

}
