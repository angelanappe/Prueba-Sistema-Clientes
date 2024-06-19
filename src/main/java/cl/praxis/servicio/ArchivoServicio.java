package cl.praxis.servicio;

import cl.praxis.model.CategoriaEnum;
import cl.praxis.model.Cliente;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ArchivoServicio {

    private ClienteServicio clienteServicio;

    public ArchivoServicio(ClienteServicio clienteServicio) {
        this.clienteServicio = clienteServicio;
    }

    public void cargarDatos(String fileName){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                String runCliente = datos[0];
                String nombreCliente = datos[1];
                String apellidoCliente = datos[2];
                String aniosCliente = datos[3];
                CategoriaEnum nombreCategoria = CategoriaEnum.valueOf(datos[4].trim());  // trim() para eliminar espacios extra
                Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, nombreCategoria);
                clienteServicio.agregarCliente(cliente);
            }
            System.out.println("Datos cargados correctamente en la lista.");
        } catch (IOException e) {
            System.err.println("Error al cargar los datos: " + e.getMessage());
        }
    }
}