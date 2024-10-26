public class Camion implements Transporte {
    private double tarifaBase;
    private double capacidadCarga;

    public Camion(double tarifaBase, double capacidadCarga) {
        this.tarifaBase = tarifaBase;
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public double calcularCosto(double distancia, double peso) {
        double costo = distancia * tarifaBase;
        if (distancia > 100) {
            costo *= 0.95; // Descuento del 5%
        }
        return costo;
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
        return "Camion [tarifaBase=" + tarifaBase + ", capacidadCarga=" + capacidadCarga + "]";
    }
}
