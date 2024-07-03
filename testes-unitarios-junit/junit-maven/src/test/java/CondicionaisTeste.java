import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class CondicionaisTeste {
    @Test
    @EnabledIfEnvironmentVariable(named = "USERNAME", matches = "root")
    void validarAlgoSomenteNoUsuarioRoot() {
        Assertions.assertEquals(10, 5 + 5);
    }

    @Test
    @DisabledIfEnvironmentVariable(named = "USERNAME", matches = "root")
    void validarAlgoSomenteSeNaoNoUsuarioRoot() {
        Assertions.assertEquals(10, 5 + 5);
    }

    @Test
    @EnabledOnOs({ OS.WINDOWS, OS.LINUX })
    @EnabledForJreRange(min = JRE.JAVA_11, max = JRE.JAVA_21)
    void validarAlgoSomenteSeNoWindows() {
        Assertions.assertEquals(10, 5 + 5);
    }
}
