package testes.unitarios.junit;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaTest {

    @Test
    void validarCalculoIdade() {
        Pessoa pessoa = new Pessoa("Julia", LocalDate.of(2010, 1, 1));
        Assertions.assertEquals(14, pessoa.getIdade());

    }
}
