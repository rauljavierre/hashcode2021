package hashcode;

import java.util.List;

public class Recorrido {
    private List<Calle> recorrido;

    public Recorrido(List<Calle> calles) {
        this.recorrido = calles;
    }

    public List<Calle> getRecorrido() {
        return recorrido;
    }
}
