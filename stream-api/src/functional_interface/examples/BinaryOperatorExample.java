package functional_interface.examples;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

/* BinaryOperator
 * Representa uma operacao que combina dois argumentos do tipo T e retorna um resultado do mesmo tipo T
 * E usada par realizar operacoes de reducao em pares de elementos, como somar numeros ou combinar objetos
 */

public class BinaryOperatorExample {

  public static void main(String[] args) {

    List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);

    // Usar o BinaryOperator com expressao lambda para somar dois numeros inteiros
    BinaryOperator<Integer> somar = (num1, num2) -> num1 + num2;

    // Usar o BinaryOperator para somar todos os numeros no Stream
    int resultado = numeros.stream()
        .reduce(0, somar);

    int resultado2 = numeros.stream()
        .reduce(0, (num1, num2) -> num1 + num2);

    System.out.println("A soma dos numeros e: " + resultado);
    System.out.println("A soma dos numeros e: " + resultado2);

  }
}
