public class Drone implements Transporte {
    private double tarifaBase;
    private double capacidadCarga;
    private double distanciaMaxima;

    public Drone() {
        this.tarifaBase = 5.0;
        this.capacidadCarga = 5.0;
        this.distanciaMaxima = 10.0;
    }

    @Override
    public double calcularCosto(double distancia, double peso) {
        if (distancia > distanciaMaxima) {
            throw new IllegalArgumentException("La distancia excede el límite permitido para drones.");
        }
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

    public double getDistanciaMaxima() {
        return distanciaMaxima;
    }

    public void setDistanciaMaxima(double distanciaMaxima) {
        this.distanciaMaxima = distanciaMaxima;
    }

    @Override
    public String toString() {
        return String.format(
            "Drone (Tarifa Base: Q%.2f, Capacidad de Carga: %.2f kg, Distancia Máxima: %.2f km)",
            tarifaBase, capacidadCarga, distanciaMaxima
        );
    }
}
