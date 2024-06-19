package cl.praxis.utilidades;

public class Utilidad {
    public static void limpiarPantalla() {
        try {
            final String os = System.getProperty("os.name");
            System.out.println(os);
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            }
            else {
                Runtime.getRuntime().exec("clear");
            }
        }
        catch (final Exception e) {
            e.printStackTrace();
        }
    }

    public static void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public static void mostrarMensajeOS(String ruta) {
        final String os = System.getProperty("os.name");
        if (os.contains("Windows")) {
            mostrarMensaje("---------Cargar Datos en Windows---------------");
            mostrarMensaje("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
            mostrarMensaje(ruta);
            mostrarMensaje("-----------------------------------------------");
        } else {
            mostrarMensaje("---------Cargar Datos en Linux o Mac-----------");
            mostrarMensaje("Ingresa la ruta en donde se encuentra el archivo DBClientes.csv:");
            mostrarMensaje(ruta);
            mostrarMensaje("-----------------------------------------------");
        }
    }
}
