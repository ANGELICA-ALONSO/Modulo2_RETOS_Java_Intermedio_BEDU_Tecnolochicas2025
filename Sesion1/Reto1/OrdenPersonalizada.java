package Sesion1.Reto1;

public class OrdenPersonalizada extends GestionOrdenes.OrdenProduccion{
    private String cliente;

    public OrdenPersonalizada(String codigo, int cantidad, String cliente) {
        super(codigo, cantidad);
        this.cliente = cliente;
    }
    
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString() + ", cliente: " + cliente;
    }
}
