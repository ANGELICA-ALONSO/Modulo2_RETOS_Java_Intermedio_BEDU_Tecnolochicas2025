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

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }


        public void mostrarResumen(){
            System.out.println("Código: " + codigo + ", cantidad: " + cantidad);
        }

        

        // Metodo para procesar ordenes de tipo OrdenPersonalizada
        // Se utiliza el wildcard super para permitir la adición de elementos a la lista
        
        /*
        public static void procesarPersonalizadas(List<? super OrdenPersonalizada> ordenes, int costoAdicional){
            System.out.println("Resumen de ordenes personalizadas:");
            ordenes.forEach(orden -> {
                for (OrdenPersonalizada op : (List<OrdenPersonalizada>) orden) {
                    System.out.println("Procesando orden personalizada: " + op.getCodigo() + ", cantidad: " + op.getCantidad());
                    // Simulamos un procesamiento que incrementa la cantidad
                    int nuevaCantidad = op.getCantidad() + costoAdicional;
                    op.setCantidad(nuevaCantidad);
                    System.out.println("Nueva cantidad para " + op.getCodigo() + ": " + nuevaCantidad);  
                }
            });
        }
            */

        // Método para procesar órdenes personalizadas
            public static void procesarPersonalizadas(List<? super OrdenPersonalizada> ordenes, int costoAdicional){
            System.out.println("Resumen de ordenes personalizadas:");
            for (Object obj : ordenes) {
                if (obj instanceof OrdenPersonalizada) {
                    OrdenPersonalizada op = (OrdenPersonalizada) obj;
                    System.out.println("Procesando orden personalizada: " + op.getCodigo() + ", cantidad: " + op.getCantidad());
                    int nuevaCantidad = op.getCantidad() + costoAdicional;
                    op.setCantidad(nuevaCantidad);
                    System.out.println("Nueva cantidad para " + op.getCodigo() + ": " + nuevaCantidad);  
                }
            }
        }

        // Método estático o generico para mostrar el resumen de órdenes
        public static void mostrarOrdenes(List<? extends OrdenProduccion> ordenes){
            System.out.println("Resumen de órdenes:");
            ordenes.forEach(OrdenProduccion::mostrarResumen);

        }
    }
}