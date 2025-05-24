package Sesion2.Reto1;

import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String> {
    public String call() throws Exception {
        Thread.sleep(2200);
        return "Control Térmico: temperatura estable (22°C)";
    }
    
}
