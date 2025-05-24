package Sesion2.Reto1;

import java.util.concurrent.Callable;

public class SistemaSoporteVital implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(2000);
        return "Soporte Vital: presión y oxígeno dentro  de los parámetros normales.";
    }

    
}
