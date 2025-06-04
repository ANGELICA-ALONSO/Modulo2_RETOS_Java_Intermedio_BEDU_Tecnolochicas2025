package Sesion4.Reto1;

import java.util.concurrent.CompletableFuture;

public class MovilidadApp {
    public static void main(String[] args) {
        System.out.println("Bienvendo a la aplicaciópn de movilidad urbana \n Procesando su ruta y tarifa...");

        CompletableFuture<String> rutaFuture = calcularRuta();
        CompletableFuture<Double> tarifaFuture = calcularTarifa();
        // Combinar los resultados de las dos tareas asincrónicas
        CompletableFuture<Void> reporteRutaTarifa = rutaFuture
            .thenCombine(tarifaFuture, (ruta, tarifa) -> {
                return "Ruta calculada: " + ruta + ", Tarifa: $" + tarifa;
            })
            .exceptionally(ex -> {
                System.out.println("Error al calcular la ruta o la tarifa: " + ex.getMessage());
                return "Error al calcular la ruta o la tarifa";
            })
            .thenAccept(System.out::println); //imprime el resultado combinado

        // Esperar a que se completen ambas tareas
        reporteRutaTarifa.join();
    }

    public static CompletableFuture<String> calcularRuta() {
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculando ruta...");
            // Simular un cálculo de ruta
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Ruta calculada: Calle San Borja 123";
        });
    }

    // Completar el cálculo de la tarifa
    public static CompletableFuture<Double> calcularTarifa(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Calculando tarifa...");
            // Simular un cálculo de tarifa
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 75.80;
        });
    }

    //Simular la confirmación de la ruta y tarifa
    public static void confirmarRutaYTarifa(String ruta, String tarifa) {
        System.out.println("Confirmando ruta y tarifa...");
        // Simular una confirmación
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ruta: " + ruta);
        System.out.println("Tarifa: " + tarifa);
        System.out.println("¡Gracias por usar nuestra aplicación de movilidad urbana!");
    }
}
