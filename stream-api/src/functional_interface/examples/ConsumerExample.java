package functional_interface.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/* Consumer
 * Representa yuma operacao que aceita um argumento de tipo T e nao retorna nenhum resultado
 * E utilizado principalmente para realizar acoes, ou efeitos colaterais nos elementos do Stream sem modificar ou retornar um valor
 */

public class ConsumerExample {
  public static void main(String[] args) {
    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

    Consumer<Integer> imprimirNumeroPar = numero -> {
      if (numero % 2 == 0) {
        System.out.println(numero);
      }
    };

    numeros.stream().forEach(imprimirNumeroPar);

    numeros.stream().forEach(new Consumer<Integer>() {
      @Override
      public void accept(Integer n) {
        if (n % 2 == 0) {
          System.out.println(n);
        }
      }
    });

    numeros.stream().forEach(numero -> {
      if (numero % 2 == 0) {
        System.out.println(numero);
      }
    });

    numeros.forEach(numero -> {
      if (numero % 2 == 0) {
        System.out.println(numero);
      }
    });

    numeros.stream()
        .filter(n -> n % 2 == 0)
        .forEach(System.out::println);

  }

}
