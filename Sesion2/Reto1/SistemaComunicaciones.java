package Sesion2.Reto1;

import java.util.concurrent.Callable;

public class SistemaComunicaciones implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(1000);
        return "Comunicaciones: enlace con la estación terrestre establecido";
    }
    
}
