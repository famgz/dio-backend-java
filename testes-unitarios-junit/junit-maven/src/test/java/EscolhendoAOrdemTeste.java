import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

// @TestMethodOrder(MethodOrderer.OrderAnnotation.class) // deve definir a ordem @Order
@TestMethodOrder(MethodOrderer.MethodName.class) // segue ordem alfabetica do nome dos metodos
// @TestMethodOrder(MethodOrderer.Random.class) // segue ordem aleatoria
// @TestMethodOrder(MethodOrderer.DisplayName.class) // segue ordem alfabetica
// definida em @DisplayName
public class EscolhendoAOrdemTeste {

    @Order(3) // para usar com MethodOrderer.OrderAnnotation
    @DisplayName("Teste que valida de o usuario foi criado") // para usar com MethodOrderer.DisplayName
    @Test
    void validaFluxoA() {
        Assertions.assertTrue(true);
    }

    @Order(2)
    @DisplayName("B")
    @Test
    void validaFluxoB() {
        Assertions.assertTrue(true);
    }

    @Order(1)
    @DisplayName("C")
    @Test
    void validaFluxoC() {
        Assertions.assertTrue(true);
    }

}
