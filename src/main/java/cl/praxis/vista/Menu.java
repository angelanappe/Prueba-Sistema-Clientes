package cl.praxis.vista;

import cl.praxis.model.CategoriaEnum;
import cl.praxis.model.Cliente;
import cl.praxis.servicio.ArchivoServicio;
import cl.praxis.servicio.ClienteServicio;
import cl.praxis.servicio.ExportadorCsv;
import cl.praxis.servicio.ExportadorTxt;

import java.util.Scanner;

public class Menu {
    private ClienteServicio clienteServicio = new ClienteServicio();
    private ArchivoServicio archivoServicio = new ArchivoServicio(clienteServicio);
    private ExportadorCsv exportadorCsv = new ExportadorCsv();
    private ExportadorTxt exportadorTxt = new ExportadorTxt();
    private String fileName = "Clientes";
    private String fileName1 = "DBClientes.csv";
    private Scanner sc = new Scanner(System.in);

    public void iniciarMenu() {
        while(true) {
            System.out.println("--------- Menú ---------");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Agregar Cliente");
            System.out.println("3. Editar Cliente");
            System.out.println("4. Cargar Datos");
            System.out.println("5. Exportar Datos");
            System.out.println("6. Salir");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    listarClientes();
                    break;
                case 2:
                    agregarCliente();
                    break;
                case 3:
                    editarCliente();
                    break;
                case 4:
                    cargarDatos();
                    break;
                case 5:
                    exportarDatos();
                    break;
                case 6:
                    terminarPrograma();
                    return;
                default:
                    System.out.println("Ingrese una opción válida.");
            }
        }
    }

    public void listarClientes(){
        clienteServicio.listarClientes();
    }

    public void agregarCliente() {
        System.out.println("-------------Crear Cliente-------------");
        System.out.print("Ingresa RUN del Cliente: ");
        String runCliente = sc.nextLine();
        System.out.print("Ingresa Nombre del Cliente: ");
        String nombreCliente = sc.nextLine();
        System.out.print("Ingresa Apellido del Cliente: ");
        String apellidoCliente = sc.nextLine();
        System.out.print("Ingresa años como Cliente: ");
        String aniosCliente = sc.nextLine();
        Cliente cliente = new Cliente(runCliente, nombreCliente, apellidoCliente, aniosCliente, CategoriaEnum.Activo);
        clienteServicio.agregarCliente(cliente);
    }

    public void editarCliente(){
        System.out.println("-------------Editar Cliente-------------");
        System.out.println("Seleccione qué desea hacer:");
        System.out.println("1.-Cambiar el estado del Cliente");
        System.out.println("2.-Editar los datos ingresados del Cliente");
        System.out.print("Ingrese una opción: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        if (opcion == 1) {
            System.out.print("Ingrese RUN del cliente que quiere editar: ");
            String runCliente = sc.nextLine();
            Cliente cliente = clienteServicio.buscarCliente(runCliente);
            if (cliente != null) {
                System.out.println("El estado actual es: " + cliente.getNombreCategoria());
                System.out.println("1.-Si desea cambiar el estado del cliente a Inactivo.");
                System.out.println("2.-Si desea mantener el estado del cliente Activo.");
                System.out.print("Ingrese una opción: ");
                int estadoOpcion = sc.nextInt();
                sc.nextLine();

                if (estadoOpcion == 1) {
                    cliente.setNombreCategoria(CategoriaEnum.Inactivo);
                } else if (estadoOpcion == 2) {
                    cliente.setNombreCategoria(CategoriaEnum.Activo);
                } else {
                    System.out.println("La opción no es válida.");
                }
            } else {
                System.out.println("Cliente no encontrado.");
            }
        } else if (opcion == 2) {
            System.out.print("Ingrese RUN del cliente a editar: ");
            String runCliente = sc.nextLine();
            Cliente cliente = clienteServicio.buscarCliente(runCliente);
            if (cliente != null) {
                System.out.println("1.-El RUN del cliente es: " + cliente.getRunCliente());
                System.out.println("2.-El nombre del cliente es: " + cliente.getNombreCliente());
                System.out.println("3.-El apellido del cliente es: " + cliente.getApellidoCliente());
                System.out.println("4.-Los años como cliente son: " + cliente.getAniosCliente());
                System.out.print("Ingrese qué datos del cliente desea editar: ");
                int datoOpcion = sc.nextInt();
                sc.nextLine();

                switch (datoOpcion) {
                    case 1:
                        System.out.print("Ingrese nuevo RUN del cliente: ");
                        cliente.setRunCliente(sc.nextLine());
                        break;
                    case 2:
                        System.out.print("Ingrese nuevo nombre del cliente: ");
                        cliente.setNombreCliente(sc.nextLine());
                        break;
                    case 3:
                        System.out.print("Ingrese nuevo apellido del cliente: ");
                        cliente.setApellidoCliente(sc.nextLine());
                        break;
                    case 4:
                        System.out.print("Ingrese nuevos años como cliente: ");
                        cliente.setAniosCliente(sc.nextLine());
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
                System.out.println("Datos cambiados con éxito.");
            } else {
                System.out.println("Cliente no encontrado.");
            }
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private void cargarDatos() {
        System.out.println("---------Cargar Datos-----------");
        System.out.print("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv: ");
        String ruta = sc.nextLine();
        archivoServicio.cargarDatos(ruta);
    }

    private void exportarDatos() {
        System.out.println("---------Exportar Datos-----------");
        System.out.println("Seleccione el formato a exportar:");
        System.out.println("1.-Formato csv");
        System.out.println("2.-Formato txt");
        System.out.print("Ingrese una opción para exportar: ");
        int opcion = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingresa la ruta en donde desea exportar el archivo: ");
        String ruta = sc.nextLine();

        if (opcion == 1) {
            exportadorCsv.exportar(ruta, clienteServicio.getListaClientes());
        } else if (opcion == 2) {
            exportadorTxt.exportar(ruta, clienteServicio.getListaClientes());
        } else {
            System.out.println("Opción no válida.");
        }
    }

    private void terminarPrograma() {
        System.out.println("Programa terminado.");
        sc.close();
    }
}
