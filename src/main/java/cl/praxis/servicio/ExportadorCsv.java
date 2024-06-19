package cl.praxis.servicio;

import cl.praxis.model.Cliente;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ExportadorCsv extends Exportador {
    @Override
    public void exportar(String fileName, List<Cliente> listaClientes) {
        try (PrintWriter wr = new PrintWriter(new FileWriter(fileName + ".csv"))) {
            for (Cliente cliente : listaClientes){
                wr.println(cliente.getRunCliente() + "," + cliente.getNombreCliente() + "," +
                        cliente.getApellidoCliente() + "," + cliente.getAniosCliente() + "," + cliente.getNombreCategoria());
            }
            System.out.println("Se exportaron los datos de cliente en formato csv, correctamente.");
        } catch (IOException e) {
            System.err.println("Error al exportar datos: " + e.getMessage());
        }
    }
}
