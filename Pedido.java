public class Pedido {
    private int idPedido;
    private double distancia;
    private double peso;
    private Transporte transporte;
    private double costo;

    public Pedido(int idPedido, double distancia, double peso, Transporte transporte) {
        this.idPedido = idPedido;
        this.distancia = distancia;
        this.peso = peso;
        this.transporte = transporte;
        this.costo = transporte.calcularCosto(distancia, peso);
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Pedido [idPedido=" + idPedido + ", distancia=" + distancia + ", peso=" + peso + ", transporte=" + transporte + ", costo=" + costo + "]";
    }
}
