package Sesion1.Reto1;

import java.util.List;

public class GestionOrdenes {
    static abstract class OrdenProduccion{
        private final String codigo;
        protected int cantidad;
        public OrdenProduccion(String codigo, int cantidad) {
            this.codigo = codigo;
            this.cantidad = cantidad;
        }

        public String getCodigo() {
            return codigo;
        }

        public int getCantidad() {
            return cantidad;
        }
        public int setCantidad(int cantidad) {
            this.cantidad = cantidad;
            return cantidad;
        }

        public void mostrarResumen(){
            System.out.println("Código: " + codigo + ", cantidad: " + cantidad);
        }

        // Método estático o generico para mostrar el resumen de órdenes
        public static void mostrarOrdenes(List<? extends OrdenProduccion> ordenes){
            System.out.println("Resumen de órdenes:");
            ordenes.forEach(OrdenProduccion::mostrarResumen);
            
        }

        // Metodo para procesar ordenes de tipo OrdenPersonalizada
        // Se utiliza el wildcard super para permitir la adición de elementos a la lista
        public static void procesarPersonalizadas(List<? super OrdenPersonalizada> ordenes, int cantidad){
            System.out.println("Resumen de ordenes personalizadas:");
            ordenes.forEach(orden -> {
                if (orden instanceof OrdenPersonalizada) {
                    OrdenPersonalizada op = (OrdenPersonalizada) orden;
                    op.cantidad += cantidad;
                    System.out.println("Código: " + op.getCodigo() + ", cantidad: " + op.getCantidad());
                    
                }
            });
        }
    }
}