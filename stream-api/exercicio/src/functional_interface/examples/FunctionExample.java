package functional_interface.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionExample {

    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 25);

        // Usar a Function com expressao lambda para dobrar todos os numeros
        Function<Integer, Integer> dobrar = numero -> numero * 2;

        // Usar a funcao para dobrar todos os numeros no Stream
        // e armazena-los em outra lista
        List<Integer> numerosDobrados = numeros.stream()
                .map(dobrar)
                .toList();

        List<Integer> numerosDobrados2 = numeros.stream()
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer n) {
                        return n * 2;
                    }
                })
                .toList();

        List<Integer> numerosDobrados3 = numeros.stream()
                .map(n -> n * 2)
                .toList();

        numerosDobrados.forEach(System.out::println);

    }

}
