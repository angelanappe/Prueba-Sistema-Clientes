package cl.praxis;

import cl.praxis.model.CategoriaEnum;
import cl.praxis.model.Cliente;
import cl.praxis.servicio.ClienteServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ClienteServicioTest {
    private ClienteServicio clienteServicio;

    @BeforeEach
    void setUp() {
        clienteServicio = new ClienteServicio();
    }

    @Test
    void agregarClientesTest() {
        Cliente cliente = new Cliente("12.123.412-2", "Nicolas", "Cake", "7 años", CategoriaEnum.Activo);
        clienteServicio.agregarCliente(cliente);

        assertEquals(1, clienteServicio.getListaClientes().size());
        assertEquals(cliente, clienteServicio.getListaClientes().get(0));
    }

    @Test
    void agregarClienteNullTest() {
        Cliente cliente = null;
        assertThrows(IllegalArgumentException.class, () -> clienteServicio.agregarCliente(cliente));
        assertEquals(0, clienteServicio.getListaClientes().size());
    }
}
