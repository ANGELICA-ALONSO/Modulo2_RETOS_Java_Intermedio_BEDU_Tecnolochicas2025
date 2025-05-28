package Sesion1.Reto1;

public class OrdenPersonalizada extends GestionOrdenes.OrdenProduccion{
    private String cliente;

    public OrdenPersonalizada(String codigo, int cantidad, String cliente) {
        super(codigo, cantidad);
        this.cliente = cliente;
    }

    public int getCantidad(){
        return super.getCantidad();
    }

    public void setCantidad(int cantidad) {
        super.setCantidad(cantidad);
    }


}
