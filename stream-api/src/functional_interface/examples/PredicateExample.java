package functional_interface.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/* Predicate
 * Representa uma funcao que aceita um argumento do tipo T e retorna um valor boolean
 * E comumente usada para filtrar os elementos do Strea com base em alguma condicao
 */

public class PredicateExample {

  public static void main(String[] args) {

    List<String> palavras = Arrays.asList("java", "kotlin", "javascript", "typescript", "python", "c", "go", "rust");

    // Criar um Predicate que verifica se a palavra tem mais de 5 caracteres
    Predicate<String> maisDeCincoCaracteres = palavra -> palavra.length() > 5;

    // Usar o Stream para filtrar as palavras com mais de 5 caracteres e, em
    // seguida, imiprimir cada palavra que passou no filtro
    palavras.stream()
        .filter(maisDeCincoCaracteres)
        .forEach(System.out::println);

    palavras.stream()
        .filter(
            new Predicate<String>() {
              @Override
              public boolean test(String p) {
                return p.length() > 5;
              }
            }

        )
        .forEach(System.out::println);

    palavras.stream()
        .filter(p -> p.length() > 5)
        .forEach(System.out::println);

  }

}
