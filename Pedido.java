import java.time.LocalDate;

public class Pedido {
    private int idPedido;
    private double distancia;
    private double peso;
    private Transporte transporte;
    private double costo;
    private LocalDate fechaPedido;

    public Pedido(int idPedido, double distancia, double peso, Transporte transporte) {
        this.idPedido = idPedido;
        this.distancia = distancia;
        this.peso = peso;
        this.transporte = transporte;
        this.costo = transporte.calcularCosto(distancia, peso);
        this.fechaPedido = LocalDate.now(); // Fecha actual del pedido
    }

    public int getIdPedido() {
        return idPedido;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getPeso() {
        return peso;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public double getCosto() {
        return costo;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    @Override
    public String toString() {
        return String.format(
            "\nPedido registrado:\n" +
            "--------------------------\n" +
            "ID Pedido      : %d\n" +
            "Fecha          : %s\n" +
            "Distancia (km) : %.2f\n" +
            "Peso (kg)      : %.2f\n" +
            "Transporte     : %s\n" +
            "Costo Total    : Q%.2f\n" +
            "--------------------------",
            idPedido, fechaPedido, distancia, peso, transporte.toString(), costo
        );
    }
}
