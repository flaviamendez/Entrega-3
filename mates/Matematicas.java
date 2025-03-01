package mates;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Matematicas {

    // Ejercicio 13: Integral usando recursión con lambda
    public static Function<Double, Function<Double, Function<Double, Function<Function<Double, Double>, Double>>>> integral =
            (a) -> (b) -> (h) -> (funcion) -> calcularIntegral(a, b, h, funcion);

    public static double calcularIntegral(double a, double b, double h, Function<Double, Double> funcion) {
        if (a >= b) return 0.0;
        return funcion.apply(a) * h + calcularIntegral(a + h, b, h, funcion);
    }

    // Ejercicio 14: Generación de Streams
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

    // Ejercicio 15: Suma de una lista con Streams
    public static int sumaLista(List<Integer> numeros) {
        return numeros.stream().mapToInt(Integer::intValue).sum();
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
