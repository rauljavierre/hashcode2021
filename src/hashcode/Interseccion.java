package hashcode;

import java.util.ArrayList;
import java.util.List;

public class Interseccion {

    private Integer numero;
    List<Calle> callesEntrada = new ArrayList<>();

    public Interseccion(Integer numero) {
        this.numero = numero;
    }

    public Integer getNumero() {
        return numero;
    }

    public void anyadirCalleEntrada(Calle calle) {
        callesEntrada.add(calle);
    }

    public void quitarCalleEntrada(Calle calle) {
        callesEntrada.remove(calle);
    }

    public Integer getNumeroCallesEntrada() {
        return callesEntrada.size();
    }

    public List<String> schedule(Integer duracionSimulacion, Integer opcion, List<Calle> primeraCalleDeCadaCoche, List<Calle> segundaCalleDeCadaCoche, List<Calle> terceraCalleDeCadaCoche) {
        switch (opcion) {
            case 1:
                return scheduleContandoValorCalles();
            case 2:
                return scheduleTeniendoEnCuentaLaPrimeraCalleDeCadaCoche(primeraCalleDeCadaCoche);
            case 3:
                return scheduleTeniendoEnCuentaLaPrimeraCalleDeCadaCocheYLaDuracion(duracionSimulacion, primeraCalleDeCadaCoche);
            case 4:
                return foo(duracionSimulacion, primeraCalleDeCadaCoche, segundaCalleDeCadaCoche, terceraCalleDeCadaCoche);
            default:
                return schedulePocho();
        }
    }

    public List<String> foo(Integer duracionSimulacion, List<Calle> primeraCalleDeCadaCoche, List<Calle> segundaCalleDeCadaCoche, List<Calle> terceraCalleDeCadaCoche) {
        for (Calle c : terceraCalleDeCadaCoche) {
            if (callesEntrada.contains(c)) {
                callesEntrada.remove(c);
                callesEntrada.add(0, c);
            }
        }

        for (Calle c : segundaCalleDeCadaCoche) {
            if (callesEntrada.contains(c)) {
                callesEntrada.remove(c);
                callesEntrada.add(0, c);
            }
        }

        for (Calle c : primeraCalleDeCadaCoche) {
            if (callesEntrada.contains(c)) {
                callesEntrada.remove(c);
                callesEntrada.add(0, c);
            }
        }


        List<String> respuestaSchedule = new ArrayList<>();
        respuestaSchedule.add(Integer.toString(callesEntrada.size()));
        for (Calle c : callesEntrada) {
            Integer duracionVerdeSemaforo = c.getDuracionVerdeSemaforo();
            if (duracionSimulacion * 0.3 < duracionVerdeSemaforo) {
                duracionVerdeSemaforo = Math.toIntExact(Math.round(duracionSimulacion * 0.3));
            }
            respuestaSchedule.add(c.getNombre() + " " + duracionVerdeSemaforo);
        }
        return respuestaSchedule;
    }

    public List<String> scheduleTeniendoEnCuentaLaPrimeraCalleDeCadaCocheYLaDuracion(Integer duracionSimulacion, List<Calle> primeraCalleDeCadaCoche) {
        for (Calle c : primeraCalleDeCadaCoche) {
            if (callesEntrada.contains(c)) {
                callesEntrada.remove(c);
                callesEntrada.add(0, c);
            }
        }

        List<String> respuestaSchedule = new ArrayList<>();
        respuestaSchedule.add(Integer.toString(callesEntrada.size()));
        for (Calle c : callesEntrada) {
            Integer duracionVerdeSemaforo = c.getDuracionVerdeSemaforo();
            if (duracionSimulacion * 0.3 < duracionVerdeSemaforo) {
                duracionVerdeSemaforo = Math.toIntExact(Math.round(duracionSimulacion * 0.3));
            }
            respuestaSchedule.add(c.getNombre() + " " + duracionVerdeSemaforo);
        }
        return respuestaSchedule;

    }

    public List<String> scheduleTeniendoEnCuentaLaPrimeraCalleDeCadaCoche(List<Calle> primeraCalleDeCadaCoche) {
        for (Calle c : primeraCalleDeCadaCoche) {
            if (callesEntrada.contains(c)) {
                callesEntrada.remove(c);
                callesEntrada.add(0, c);
            }
        }

        return scheduleContandoValorCalles();
    }

    public List<String> scheduleContandoValorCalles() {
        List<String> respuestaSchedule = new ArrayList<>();
        respuestaSchedule.add(Integer.toString(callesEntrada.size()));
        for (Calle c : callesEntrada) {
            respuestaSchedule.add(c.getNombre() + " " + c.getDuracionVerdeSemaforo());
        }
        return respuestaSchedule;
    }

    public List<String> schedulePocho() {
        List<String> respuestaSchedule = new ArrayList<>();
        respuestaSchedule.add(Integer.toString(callesEntrada.size()));
        for (Calle c : callesEntrada) {
            respuestaSchedule.add(c.getNombre() + " " + "1");
        }
        return respuestaSchedule;
    }

}
