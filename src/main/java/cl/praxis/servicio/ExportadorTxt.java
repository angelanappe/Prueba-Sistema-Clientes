package cl.praxis.servicio;

import cl.praxis.model.Cliente;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportadorTxt extends Exportador {
    @Override
    public void exportar(String fileName, List<Cliente> listaClientes){
        try (PrintWriter wr = new PrintWriter(new FileWriter(fileName + ".txt"))){
            for (Cliente cliente : listaClientes) {
                wr.println("RUN del cliente: " + cliente.getRunCliente());
                wr.println("Nombre del cliente: " + cliente.getNombreCliente());
                wr.println("Apellido del cliente: " + cliente.getApellidoCliente());
                wr.println("Años del cliente: " + cliente.getAniosCliente());
                wr.println("Categoría del cliente: " + cliente.getNombreCategoria());
                wr.println("----------------------------------------");
            }
            System.out.println("Se exportaron los datos de cliente en formato txt, correctamente.");
        } catch (IOException e) {
            System.err.println("Error al exportar datos: " + e.getMessage());
        }
    }
}
