public class Interfaz {
    private Gestionador gestionador;

    public Interfaz(Gestionador gestionador) {
        this.gestionador = gestionador;
    }

    public void mostrarReporteMensual() {
        // Aquí se imprimiría el reporte mensual
        System.out.println("Reporte mensual: ");
    }

    public void solicitarDatosPedido() {
        // Aquí se solicitarían datos al usuario para registrar un pedido
        System.out.println("Ingrese los datos del pedido:");
    }

    public Gestionador getGestionador() {
        return gestionador;
    }

    public void setGestionador(Gestionador gestionador) {
        this.gestionador = gestionador;
    }

    @Override
    public String toString() {
        return "Interfaz [gestionador=" + gestionador + "]";
    }
}
