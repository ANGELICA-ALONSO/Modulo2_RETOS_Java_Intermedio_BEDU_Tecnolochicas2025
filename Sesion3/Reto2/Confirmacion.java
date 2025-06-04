package Sesion3.Reto2;

public class Confirmacion {
    private final Encuesta encuesta;
    private final String sucursal;

    public Confirmacion(Encuesta encuesta, String sucursal) {
        this.encuesta = encuesta;
        this.sucursal = sucursal;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public String getSucursal() {
        return sucursal;
    }

}
