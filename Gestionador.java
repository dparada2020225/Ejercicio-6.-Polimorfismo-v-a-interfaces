import java.util.ArrayList;
import java.util.List;

public class Gestionador{
    private List<Pedido> listaPedidos;

    public Gestionador() {
        this.listaPedidos = new ArrayList<>();
    }

    public void registrarPedido(int idPedido, double distancia, double peso, Transporte transporte) {
        Pedido nuevoPedido = new Pedido(idPedido, distancia, peso, transporte);
        listaPedidos.add(nuevoPedido);
    }

    public void generarReporteMensual() {
        // Implementación para generar reporte mensual
    }

    public void guardarPedidosCSV() {
        // Implementación para guardar pedidos en CSV
    }

    public void cargarPedidosCSV() {
        // Implementación para cargar pedidos desde CSV
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    @Override
    public String toString() {
        return "GestionadorPrincipal [listaPedidos=" + listaPedidos + "]";
    }
}
