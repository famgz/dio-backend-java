package functional_interface.examples;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

/* Supplier
 * Representa uma operacao quenao aceita nenhumargumento e retorna um resultado do tipo T
 * E comumente usada para criar oufornecer novos ovjetos de um determinado tipo
 */

public class SupplierExample {

  public static void main(String[] args) {
    // Usar o Supplier com expresao lambda para fornece rum e saudacao personalizada
    Supplier<String> saudacao = () -> "Ola, seja bem vindo";

    // Usar o Supplier para obter uma lista com 5 saudacoes
    List<String> listaSaudacoes = Stream.generate(saudacao)
        .limit(5)
        .toList();

    List<String> listaSaudacoes2 = Stream.generate(() -> "Ola, seja bem vindo")
        .limit(5)
        .toList();

    listaSaudacoes.forEach(System.out::println); // Reference method

  }

}
