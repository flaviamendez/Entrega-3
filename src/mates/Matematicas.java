package mates;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Matematicas {
    //Ejercicio 12: Expresiones Lambda en Java
    /*
     * Una expresión lambda en Java es una función anónima que permite definir un comportamiento sin necesidad de declarar una clase o método explícito.
     * Se usa en Streams, Interfaces funcionales y Programación funcional.
    */

    // Ejercicio 13: Integral usando recursión con lambda
    public static Function<Double, Function<Double, Function<Double, Function<Function<Double, Double>, Double>>>> integral =
            (a) -> (b) -> (h) -> (funcion) -> calcularIntegral(a, b, h, funcion);

    public static double calcularIntegral(double a, double b, double h, Function<Double, Double> funcion) {
        if (a >= b) return 0.0;
        return funcion.apply(a) * h + calcularIntegral(a + h, b, h, funcion);
    }

    
    public static void generarStreams() {
        System.out.println("Stream usando of:");
        IntStream.of(1, 2, 3, 4, 5).forEach(System.out::println);

        System.out.println("\nStream usando range:");
        IntStream.range(1, 6).forEach(System.out::println);

        System.out.println("\nStream usando iterate:");
        IntStream.iterate(1, n -> n + 2).limit(5).forEach(System.out::println);

        System.out.println("\nStream de números aleatorios:");
        new Random().ints(5, 0, 100).forEach(System.out::println);
    }
    // Ejercicio 15: Ejercicios del 1 - 12
    // Ejercicio 1 suma
    public static int suma(int n) {
        return IntStream.rangeClosed(1, n)
        .sum();
    }

    // Ejercicio 2 Factorial
    public static int factorial(int n) {
        return IntStream.rangeClosed(1, n)
        .reduce(1, (a, b) -> a * b);
    }

    // Ejercicio 3 exponente
    public static int potencia(int base, int exponente) {
        return IntStream.range(0, exponente)
        .reduce(1, (a, b) -> a * base);
    }

    // Ejercicio 4 suma lista
    public static int sumaLista(ArrayList<Integer> lista) {
        return lista.stream().mapToInt(Integer::intValue)
        .sum();
    }

    // Ejercicio 5 media aritmética de una lista de enteros
    public static double mediaAritm(ArrayList<Integer> lista) {
        return lista.stream().mapToInt(Integer::intValue)
        .average().orElse(0.0);
    }

    // Ejercicio 6 desviación típica de una lista
    public static double desviacionT(ArrayList<Integer> lista) {
        double media = mediaAritm(lista);
        return Math.sqrt(lista.stream()
        .mapToDouble(num -> Math.pow(num - media, 2)).sum() / lista.size());
    }

    // Ejercicio 7 La suma de los primeros números pares hasta n asumiendo n ≥ 2
    public static int sumaPar(int n) {
        return IntStream.rangeClosed(0, n)
        .filter(x -> x % 2 == 0).sum();
    }

    // Ejercicio 8 suma de los elementos pares de una lista de enteros
    public static int sumaParLista(ArrayList<Integer> lista) {
        return lista.stream()
        .filter(num -> num % 2 == 0)
        .mapToInt(Integer::intValue).sum();
    }

    // EJERCICIO 9 Lista de números >= 2 obtener otra lista solo con los pares.
    public static ArrayList<Integer> listaPares(ArrayList<Integer> lista) {
        return lista.stream()
        .filter(num -> num % 2 == 0)
        .collect(Collectors.toCollection(ArrayList::new));
    }

    // Ejercicio 10 lista de los primeros números pares hasta n asumiendo n ≥ 2.
    public static ArrayList<Integer> listaDeSoloPar(int n) {
        return IntStream.rangeClosed(2, n)
        .filter(i-> i %2 == 0)
        .boxed()
        .collect(Collectors.toCollection(ArrayList::new));
    }

    // Ejercicio 11  Producto escalar de dos listas de números no vacías y del mismo tamaño.
    public static int productoEscalar(ArrayList<Integer> lista1, ArrayList<Integer> lista2) {
        return IntStream.range(0, lista1.size())
        .map(i -> lista1.get(i) * lista2.get(i)).sum();
    }

    //EJERCICIO 12 Elemento n-ésimo de la sucesión fibinacci.
    public static int fibo(int n) {
        return IntStream.range(0, n)
        .reduce(0, (a, b) -> a + b);
    }


    // Ejercicio 16: Integral con Streams
    public static double integralConStreams(double a, double b, double h, Function<Double, Double> funcion) {
        return DoubleStream.iterate(a, x -> x + h)
                .limit((long) ((b - a) / h))
                .map(funcion::apply)
                .sum() * h;
    }

    // Ejercicio 17: Clase Persona
    public static class Persona {
        public String nombre;
        LocalDate fechaNacimiento;

        public Persona(String nombre, LocalDate fechaNacimiento) {
            this.nombre = nombre;
            this.fechaNacimiento = fechaNacimiento;
        }

        public long calcularEdad() {
            return Period.between(fechaNacimiento, LocalDate.now()).getYears();
        }
    }

    // 🔹 Ejercicio 17: Clase Personas
    public static class Personas {
        List<Persona> lista = new ArrayList<>();

        public void annadirPersona(Persona persona) {
            lista.add(persona);
        }

        public Persona elMasJoven() {
            return lista.stream().min(Comparator.comparing(Persona::calcularEdad)).orElse(null);
        }

        public long calcularSumaEdades() {
            return lista.stream().mapToLong(Persona::calcularEdad).sum();
        }

        public long calcularEdadMinima() {
            return lista.stream().mapToLong(Persona::calcularEdad).min().orElse(0);
        }

        public double calcularMediaDeEdad() {
            return lista.stream().mapToLong(Persona::calcularEdad).average().orElse(0);
        }
    }
}
