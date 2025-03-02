package aplicacion;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import mates.Matematicas;

public class Principal {
    public static void main(String[] args) {
        System.out.println("\nEjercicio 13");
        double resultadoIntegral = Matematicas.integral.apply(0.0).apply(1.0).apply(0.1).apply(x -> Math.exp(Math.pow(x, 2)));
        System.out.println("Resultado: " + resultadoIntegral);

        System.out.println("\nEjercicio 14: Generación de Streams");
        Matematicas mat = new Matematicas();
        List<Integer> listaNumeros = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> lista2 = Arrays.asList(6, 7, 8, 9, 10);

        System.out.println("Lista de números: " + listaNumeros);
        System.out.println("Lista 2: " + lista2);

        System.out.println("\nEjercicios del 1 al 12");
        System.out.println("1. Suma: " + Matematicas.suma(10));
        System.out.println("2. Factorial: " + Matematicas.factorial(5));
        System.out.println("3. Potencia: " + Matematicas.potencia(2, 3));
        System.out.println("4. Suma Lista: " + Matematicas.sumaLista(new java.util.ArrayList<>(listaNumeros)));
        System.out.println("5. Media Aritmética: " + Matematicas.mediaAritm(new java.util.ArrayList<>(listaNumeros)));
        System.out.println("6. Desviación Típica: " + Matematicas.desviacionT(new java.util.ArrayList<>(listaNumeros)));
        System.out.println("7. Suma de pares hasta 10: " + Matematicas.sumaPar(10));
        System.out.println("8. Suma de pares en lista: " + Matematicas.sumaParLista(new java.util.ArrayList<>(listaNumeros)));
        System.out.println("9. Lista de pares: " + Matematicas.listaPares(new java.util.ArrayList<>(listaNumeros)));
        System.out.println("10. Lista de pares hasta 10: " + Matematicas.listaDeSoloPar(10));
        System.out.println("11. Producto escalar: " + Matematicas.productoEscalar(new java.util.ArrayList<>(listaNumeros), new java.util.ArrayList<>(lista2)));
        System.out.println("12. Fibonacci (posición 10): " + Matematicas.fibo(10));

        System.out.println("\nEjercicio 16: Integral de e^(x^2) con Streams");
        double resultadoIntegralStreams = Matematicas.integralConStreams(0, 1, 0.1, x -> Math.exp(Math.pow(x, 2)));
        System.out.println("Resultado: " + resultadoIntegralStreams);

        System.out.println("\nEjercicio 17: Manejo de personas con Streams");
        Matematicas.Personas grupo = new Matematicas.Personas();
        grupo.annadirPersona(new Matematicas.Persona("Carlota", LocalDate.of(2020, 4, 18)));
        grupo.annadirPersona(new Matematicas.Persona("Flavia", LocalDate.of(2000, 10, 21)));
        grupo.annadirPersona(new Matematicas.Persona("Carlos", LocalDate.of(1985, 3, 15)));

        Matematicas.Persona masJoven = grupo.elMasJoven();
        System.out.println("La persona más joven es: " + (masJoven != null ? masJoven.nombre : "No hay datos"));
        System.out.println("Suma de edades: " + grupo.calcularSumaEdades());
        System.out.println("Más pequeño: " + grupo.calcularEdadMinima());
        System.out.println("Media de las edades: " + grupo.calcularMediaDeEdad());
    }
}