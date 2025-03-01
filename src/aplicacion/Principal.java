package aplicacion;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import mates.Matematicas;
public class Principal {
    public static void main(String[] args) {
        System.out.println("Ejercicio 12: Expresiones Lambda en Java");
        System.out.println("Una expresión lambda en Java es una función anónima que permite definir un comportamiento sin necesidad de declarar una clase o método explícito.");
        System.out.println("Se usa en Streams, Interfaces funcionales y Programación funcional.");

        System.out.println("\nEjercicio 13");
        double resultadoIntegral = Matematicas.integral.apply(0.0).apply(1.0).apply(0.1).apply(x -> Math.exp(Math.pow(x, 2)));
        System.out.println("Resultado: " + resultadoIntegral);

        System.out.println("\nEjercicio 14: Generación de Streams");
        Matematicas.generarStreams();

        List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5);
        int sumaLista = Matematicas.sumaLista(listaNumeros);
        System.out.println("\nEjercicio 15: Suma de la lista " + listaNumeros + " es " + sumaLista);

        System.out.println("\nEjercicio 16: Integral de e^(x^2) con Streams");
        double resultadoIntegralStreams = Matematicas.integralConStreams(0, 1, 0.1, x -> Math.exp(Math.pow(x, 2)));
        System.out.println("Resultado: " + resultadoIntegralStreams);

        System.out.println("\nEjercicio 17: Manejo de personas con Streams");
        Matematicas.Personas grupo = new Matematicas.Personas();
        grupo.annadirPersona(new Matematicas.Persona("Juan", LocalDate.of(1990, 5, 10)));
        grupo.annadirPersona(new Matematicas.Persona("Ana", LocalDate.of(2000, 8, 21)));
        grupo.annadirPersona(new Matematicas.Persona("Carlos", LocalDate.of(1985, 3, 15)));

        Matematicas.Persona masJoven = grupo.elMasJoven();
        System.out.println("La persona más joven es: " + (masJoven != null ? masJoven.nombre : "No hay datos"));
        System.out.println("Suma de edades: " + grupo.calcularSumaEdades());
        System.out.println("Edad mínima: " + grupo.calcularEdadMinima());
        System.out.println("Edad media: " + grupo.calcularMediaDeEdad());
    }
}
