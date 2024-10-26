import java.util.Scanner;

public class Interfaz {
    private Gestionador gestionador;

    public Interfaz(Gestionador gestionador) {
        this.gestionador = gestionador;
    }

    public static void main(String[] args) {
        Gestionador gestionador = new Gestionador();
        Interfaz interfaz = new Interfaz(gestionador);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n===== Menú =====");
            System.out.println("1. Registrar Pedido");
            System.out.println("2. Generar Reporte Mensual");
            System.out.println("3. Guardar Pedidos en CSV");
            System.out.println("4. Cargar Pedidos desde CSV");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    interfaz.registrarPedido(scanner);
                    break;
                case 2:
                    System.out.print("Ingrese el mes (1-12): ");
                    int mes = scanner.nextInt();
                    System.out.print("Ingrese el año (yyyy): ");
                    int anio = scanner.nextInt();
                    gestionador.generarReporteMensual(mes, anio);
                    break;
                case 3:
                    System.out.println("Pedidos guardados automáticamente en el archivo CSV.");
                    break;
                case 4:
                    gestionador.cargarPedidosCSV();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);

        scanner.close();
    }

    public void registrarPedido(Scanner scanner) {
        System.out.print("Ingrese el ID del pedido: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese la distancia (km): ");
        double distancia = scanner.nextDouble();
        System.out.print("Ingrese el peso (kg): ");
        double peso = scanner.nextDouble();

        gestionador.registrarPedido(id, distancia, peso);
    }
}
