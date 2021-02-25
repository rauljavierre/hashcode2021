package hashcode;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.lang.String;

public class Main {

    public static Map<Integer, Interseccion> interseccionMap = new HashMap<>();
    public static Map<String, Calle> callesMap = new HashMap<>();
    public static List<String> nombresCalles = new ArrayList<>();
    public static List<Coche> cochesList = new ArrayList<>();

    public static Integer duracionSimulacion;

    public static List<Calle> primeraCalleDeCadaCoche = new ArrayList<>();
    public static List<Calle> segundaCalleDeCadaCoche = new ArrayList<>();
    public static List<Calle> terceraCalleDeCadaCoche = new ArrayList<>();


    // Working directory: hashcode 2021 (root directory)

    /*
        args[0]: input filename
        args[1]: output filename
    */
    public static void main(String[] args) throws IOException {
        String inputFile = "f.txt";
        String outputFile = "f.txt";

        obtenerInterseccionesCallesYCoches(inputFile);

        List<String> output = new ArrayList<>();

        output.add(Integer.toString(interseccionMap.size()));
        for(Interseccion i : interseccionMap.values()) {
            output.add(Integer.toString(i.getNumero()));
            output.addAll(i.schedule(0, 3, primeraCalleDeCadaCoche, segundaCalleDeCadaCoche, terceraCalleDeCadaCoche));
        }

        FileUtils.writeLines(output, outputFile);
    }

    public static void obtenerInterseccionesCallesYCoches(String inputFile) throws FileNotFoundException {
        List<String> lines = FileUtils.readLines(inputFile);
        List<String> primeraLinea = Arrays.asList(lines.get(0).split(" "));
        duracionSimulacion = Integer.parseInt(primeraLinea.get(0));

        Integer numeroIntersecciones = Integer.parseInt(primeraLinea.get(1));
        obtenerIntersecciones(lines, numeroIntersecciones);

        Integer numeroCalles = Integer.parseInt(primeraLinea.get(2));
        obtenerCalles(lines, numeroCalles);

        obtenerCoches(lines, numeroCalles);


        for(String c : nombresCalles) {
            if (callesMap.get(c).getDuracionVerdeSemaforo() == 0) {
                for(int i = 0; i < numeroIntersecciones; i++) {
                    interseccionMap.get(i).quitarCalleEntrada(callesMap.get(c));
                }
                callesMap.remove(c);
            }
        }

        for(int i = 0; i < numeroIntersecciones; i++) {
            if (interseccionMap.get(i).getNumeroCallesEntrada() == 0) {
                interseccionMap.remove(i);
            }
        }


    }

    public static void obtenerIntersecciones(List<String> lines, Integer numeroIntersecciones){
        for (int i = 0; i < numeroIntersecciones; i++) {
            Interseccion interseccion = new Interseccion(i);
            interseccionMap.put(i, interseccion);
        }
    }

    public static void obtenerCalles(List<String> lines, Integer numeroCalles){
        for (int i = 1; i < numeroCalles + 1; i++) {
            List<String> auxLine = Arrays.asList(lines.get(i).split(" "));
            String interseccionFin = auxLine.get(1);
            String nombre = auxLine.get(2);
            Integer duracionCruzarCalle = Integer.parseInt(auxLine.get(3));
            callesMap.put(nombre, new Calle(interseccionMap.get(Integer.parseInt(interseccionFin)), nombre,duracionCruzarCalle));
            nombresCalles.add(nombre);
        }
    }

    public static void obtenerCoches(List<String> lines, Integer numeroCalles) {
        for (int i = numeroCalles + 1; i < lines.size(); i++) {
            List<String> auxLine = Arrays.asList(lines.get(i).split(" "));

            List<Calle> listaCalles = new ArrayList<>();

            for (int j = 1; j < Integer.parseInt(auxLine.get(0)); j++) {
                Calle c = callesMap.get(auxLine.get(j));
                c.sumarDuracionVerdeSemaforo();
                listaCalles.add(c);
                if (j == 1 && !primeraCalleDeCadaCoche.contains(c)) {
                    primeraCalleDeCadaCoche.add(c);
                }
                if (j == 2 && !primeraCalleDeCadaCoche.contains(c)) {
                    segundaCalleDeCadaCoche.add(c);
                }
                if (j == 3 && !primeraCalleDeCadaCoche.contains(c)) {
                    terceraCalleDeCadaCoche.add(c);
                }
            }

            cochesList.add(new Coche(new Recorrido(listaCalles)));
        }
    }
}
