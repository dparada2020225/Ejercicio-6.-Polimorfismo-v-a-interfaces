public class Motocicleta implements Transporte {
    private double tarifaBase;
    private double capacidadCarga;

    public Motocicleta(double tarifaBase, double capacidadCarga) {
        this.tarifaBase = tarifaBase;
        this.capacidadCarga = capacidadCarga;
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
        return "Motocicleta [tarifaBase=" + tarifaBase + ", capacidadCarga=" + capacidadCarga + "]";
    }
}
