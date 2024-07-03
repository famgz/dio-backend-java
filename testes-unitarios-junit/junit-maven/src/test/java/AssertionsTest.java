import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.dio.Pessoa;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals; // importacao estatica
import static org.junit.jupiter.api.Assertions.*; // importacao estatica de tudo

public class AssertionsTest {

    @Test
    void validarLancamentos() {
        int[] primeirosLancamentos = { 10, 20, 30, 40, 50 };
        int[] segundosLancamentos = { 10, 20, 30, 40, 50 };
        Assertions.assertArrayEquals(primeirosLancamentos, segundosLancamentos);
    }

    @Test
    void validarSeObjetoEstaNulo() {
        Pessoa pessoa = null;
        Assertions.assertNull(pessoa);
        pessoa = new Pessoa("Luciano", LocalDate.now());
        assertNotNull(pessoa);
    }

    @Test
    void validarNumerosDeTiposDiferentes() {
        double valor = 5.0;
        double valor2 = 5.0;
        assertEquals(valor, valor2);
    }
}
