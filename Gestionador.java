import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gestionador {
    private List<Pedido> listaPedidos;
    private static final String CSV_FILE = "pedidos.csv";

    public Gestionador() {
        this.listaPedidos = new ArrayList<>();
        cargarPedidosCSV();
    }

    public void registrarPedido(int idPedido, double distancia, double peso) {
        Transporte transporte;
        if (peso <= 5 && distancia <= 10) {
            transporte = new Drone();
        } else if (peso <= 50) {
            transporte = new Motocicleta();
        } else {
            transporte = new Camion();
        }

        Pedido nuevoPedido = new Pedido(idPedido, distancia, peso, transporte);
        listaPedidos.add(nuevoPedido);
        System.out.println(nuevoPedido); 
        guardarPedidoEnCSV(nuevoPedido); 
    }

    public void generarReporteMensual(int mes, int anio) {
        double totalCamion = 0, totalMotocicleta = 0, totalDrone = 0;
        int countCamion = 0, countMotocicleta = 0, countDrone = 0;

        for (Pedido pedido : listaPedidos) {
            if (pedido.getFechaPedido().getMonthValue() == mes && pedido.getFechaPedido().getYear() == anio) {
                if (pedido.getTransporte() instanceof Camion) {
                    totalCamion += pedido.getCosto();
                    countCamion++;
                } else if (pedido.getTransporte() instanceof Motocicleta) {
                    totalMotocicleta += pedido.getCosto();
                    countMotocicleta++;
                } else if (pedido.getTransporte() instanceof Drone) {
                    totalDrone += pedido.getCosto();
                    countDrone++;
                }
            }
        }

        System.out.println("\n===== Reporte Mensual =====");
        System.out.printf("Mes/Año: %02d/%d\n", mes, anio);
        System.out.printf("Camiones      : %d pedidos, Total: Q%.2f\n", countCamion, totalCamion);
        System.out.printf("Motocicletas  : %d pedidos, Total: Q%.2f\n", countMotocicleta, totalMotocicleta);
        System.out.printf("Drones        : %d pedidos, Total: Q%.2f\n", countDrone, totalDrone);
        System.out.println("===========================");
    }

    private void guardarPedidoEnCSV(Pedido pedido) {
        boolean fileExists = new File(CSV_FILE).exists();

        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE, true))) {
            if (!fileExists) {
                writer.println("ID,Distancia,Peso,Tipo de Transporte,Costo,Tarifa Base,Capacidad de Carga,Distancia Máxima,Fecha");
            }

            String tipoTransporte = pedido.getTransporte().getClass().getSimpleName();
            double tarifaBase = pedido.getTransporte() instanceof Camion ? 20.0 :
                                pedido.getTransporte() instanceof Motocicleta ? 10.0 : 5.0;
            double capacidadCarga = pedido.getTransporte() instanceof Camion ? 10000.0 :
                                    pedido.getTransporte() instanceof Motocicleta ? 50.0 : 5.0;
            double distanciaMaxima = pedido.getTransporte() instanceof Drone ? 10.0 : 0.0;

            writer.printf("%d,%.2f,%.2f,%s,%.2f,%.2f,%.2f,%.2f,%s\n",
                    pedido.getIdPedido(), pedido.getDistancia(), pedido.getPeso(),
                    tipoTransporte, pedido.getCosto(), tarifaBase, capacidadCarga, distanciaMaxima, pedido.getFechaPedido());
        } catch (IOException e) {
            System.out.println("Error al guardar el pedido en el archivo CSV.");
        }
    }

    public void cargarPedidosCSV() {
        File file = new File(CSV_FILE);
        if (!file.exists()) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE))) {
                writer.println("ID,Distancia,Peso,Tipo de Transporte,Costo,Tarifa Base,Capacidad de Carga,Distancia Máxima,Fecha");
                System.out.println("Archivo CSV creado con encabezados.");
            } catch (IOException e) {
                System.out.println("Error al crear el archivo CSV.");
            }
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
                String line = reader.readLine(); 
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    int id = Integer.parseInt(data[0]);
                    double distancia = Double.parseDouble(data[1]);
                    double peso = Double.parseDouble(data[2]);
                    String tipoTransporte = data[3];
                    double costo = Double.parseDouble(data[4]);
                    LocalDate fechaPedido = LocalDate.parse(data[8]);

                    Transporte transporte;
                    if (tipoTransporte.equals("Drone")) {
                        transporte = new Drone();
                    } else if (tipoTransporte.equals("Motocicleta")) {
                        transporte = new Motocicleta();
                    } else {
                        transporte = new Camion();
                    }

                    Pedido pedido = new Pedido(id, distancia, peso, transporte);
                    listaPedidos.add(pedido);
                }
                System.out.println("Pedidos cargados desde el archivo CSV.");
            } catch (IOException e) {
                System.out.println("Error al cargar los pedidos desde CSV.");
            }
        }
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }
}
