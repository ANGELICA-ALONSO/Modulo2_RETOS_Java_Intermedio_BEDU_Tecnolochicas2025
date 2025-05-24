package Sesion2.Reto2;

import java.util.concurrent.locks.ReentrantLock;

public class RecursoMedico {
    private String nombre;
    private final ReentrantLock lock = new ReentrantLock();

    public String getNombre(){
        return nombre;
    }

    public void usar(String profesional, String nombre) {
        lock.lock();
        System.out.println("El recurso medico " + nombre + " esta siendo usado por el profesional " + profesional);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println("El recurso medico " + nombre + " ha terminado de ser usado por el profesional " + profesional);

    }
    
}
