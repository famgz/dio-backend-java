import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.dio.Conta;
import com.dio.TransferenciaEntreContas;

public class ExceptionsTeste {

    @Test
    void validarCenarioExcecaoNaTransferencia() {
        Conta contaOrigem = new Conta("123", 0);
        Conta contaDestino = new Conta("124", 100);

        TransferenciaEntreContas transferenciaEntreContas = new TransferenciaEntreContas();

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> transferenciaEntreContas.trasfere(contaOrigem, contaDestino, -1));

        Assertions.assertDoesNotThrow(
                () -> transferenciaEntreContas.trasfere(contaOrigem, contaDestino, 50));
    }
}
