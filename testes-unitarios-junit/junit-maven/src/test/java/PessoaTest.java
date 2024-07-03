import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.dio.Pessoa;

public class PessoaTest {

    @Test
    void deveCalcularIdadeCorretamente() {
        LocalDate dataNascimento = LocalDate.of(2000, 1, 1);
        Pessoa pessoa = new Pessoa("Jessica", dataNascimento);
        int idadeEsperada = (int) ChronoUnit.YEARS.between(dataNascimento, LocalDate.now());
        Assertions.assertEquals(idadeEsperada, pessoa.getIdade());
    }

    @Test
    void deveRetornarMaiorDeIdade() {
        Pessoa pessoa = new Pessoa("Carolaine", LocalDate.of(2000, 1, 1));
        Assertions.assertTrue(pessoa.ehMaiorDeIdade());

        Pessoa pessoa2 = new Pessoa("Joao", LocalDate.of(2020, 1, 1));
        Assertions.assertFalse(pessoa2.ehMaiorDeIdade());
    }

}
