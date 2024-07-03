import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

public class AssumptionsTeste {

    @Test
    void validarAlgoSomenteNoUsuarioRoot() {
        String userName = System.getenv("USERNAME");
        Assumptions.assumeTrue("root".equals(userName));
        Assertions.assertEquals(10, 5 + 5);
    }
}
