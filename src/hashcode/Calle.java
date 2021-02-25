package hashcode;

public class Calle {
    private Interseccion interseccionFin;
    private String nombre;
    private Integer duracionVerdeSemaforo;
    private Integer duracionCruzarCalle;

    public Calle(Interseccion interseccionFin,
                 String nombre,
                 Integer duracionCruzarCalle) {
        this.interseccionFin = interseccionFin;
        this.interseccionFin.anyadirCalleEntrada(this);
        this.nombre = nombre;
        this.duracionVerdeSemaforo = 0;
        this.duracionCruzarCalle = duracionCruzarCalle;
    }

    public Interseccion getInterseccionFin() {
        return interseccionFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void sumarDuracionVerdeSemaforo() {
        duracionVerdeSemaforo += 1;
    }

    public Integer getDuracionVerdeSemaforo() {
        return duracionVerdeSemaforo;
    }

    public Integer getDuracionCruzarCalle() {
        return duracionCruzarCalle;
    }
}
