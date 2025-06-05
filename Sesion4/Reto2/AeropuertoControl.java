package Sesion4.Reto2;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class AeropuertoControl {
    private static Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de control de aeropuerto");

        CompletableFuture<Boolean> pistaFuture = verificarPista();
        CompletableFuture<Boolean> climaFuture = verificarClima();
        CompletableFuture<Boolean> traficoFuture = verificarTraficoAereo();
        CompletableFuture<Boolean> personalTierraFuture = verificarPersonalTierra();
        CompletableFuture<Void> allFutures = CompletableFuture.allOf(pistaFuture, climaFuture, traficoFuture, personalTierraFuture);
        allFutures.thenRun(() -> {
            boolean pistaLibre = pistaFuture.join();
            boolean climaAdecuado = climaFuture.join();
            boolean traficoAereoLibre = traficoFuture.join();
            boolean personalTierraDisponible = personalTierraFuture.join();

            if (pistaLibre && climaAdecuado && traficoAereoLibre && personalTierraDisponible) {
                System.out.println("- Aterrizaje AUTORIZADO: todas las condiciones son óptimas.");
            } else {
                System.out.println("🛑 - Aterrizaje DENEGADO: condiciones no óptimas.");
            }
        }).exceptionally(ex -> {
            System.err.println("Error en la verificación: " + ex.getMessage());
            return null;
        });

        // Esperar a que todas las verificaciones se completen
        allFutures.join();
        System.out.println("Proceso de verificación finalizado.");
    }

    
    
    public static CompletableFuture<Boolean> verificarPista(){
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // Simula un retraso de 2 segundos
                boolean exitoAleatorio = random.nextDouble() < 0.8; // Simula un 80% de probabilidad de éxito
                if (exitoAleatorio) {
                    System.out.println("Pista verificada correctamente.");
                    return true; // Retorna verdadero si la pista está libre
                } else {
                    System.out.println("Falla en la verificación de la pista.");
                    return false; // Retorna falso si la pista no está libre
                }
                
            } catch (InterruptedException e) {
                System.err.println("Error al verificar la pista: " + e.getMessage());
                return false; // Retorna falso en caso de error
            }
        });
    }

    public static CompletableFuture<Boolean> verificarClima(){
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000); // Simula un retraso de 2 segundos
                boolean exitoAleratorio = random.nextDouble() < 0.85;
                if (exitoAleratorio){
                    System.out.println("Clima verificado correctamente.");
                    return true;
                } else {
                    System.out.println("Falla en la verificación del clima.");
                    return false;
                }
            } catch (InterruptedException e) {
                System.err.println("Error al verificar el clima: " + e.getMessage());
                return false;
            }
        });
    }

    public static CompletableFuture<Boolean> verificarTraficoAereo() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
                boolean exitoAleatorio = random.nextDouble() < 0.90;
                if (exitoAleatorio) {
                    System.out.println("Tráfico aéreo verificado correctamente.");
                return true;
                } else {
                    System.out.println("Falla en la verificación del tráfico aéreo.");
                    return false;
                }
    
            } catch (InterruptedException e) {
                System.out.println("Error al verificar el tráfico aéreo: " + e.getMessage());
                return false;
            }
        });
    }

    public static CompletableFuture<Boolean> verificarPersonalTierra(){
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                boolean exitoAleatorio = random.nextDouble() < 0.95;
                if (exitoAleatorio) {
                    System.out.println("Personal de tierra verificado correctamente.");
                return true;
                } else {
                    System.out.println("Falla en la verificación del personal de tierra.");
                    return false;
                }
                
            } catch (InterruptedException e){
                System.out.println("Error al verificar el personal de tierra: " + e.getMessage());
                return false;

            }
        });

    }
}
