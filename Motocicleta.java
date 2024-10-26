public class Motocicleta implements Transporte {
    private double tarifaBase;
    private double capacidadCarga;

    public Motocicleta() {
        this.tarifaBase = 10.0;
        this.capacidadCarga = 50.0;
    }

    @Override
    public double calcularCosto(double distancia, double peso) {
        return distancia * tarifaBase;
    }

    public double getTarifaBase() {
        return tarifaBase;
    }

    public void setTarifaBase(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    public double getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        return String.format(
            "Motocicleta (Tarifa Base: Q%.2f, Capacidad de Carga: %.2f kg)", tarifaBase, capacidadCarga
        );
    }
}
