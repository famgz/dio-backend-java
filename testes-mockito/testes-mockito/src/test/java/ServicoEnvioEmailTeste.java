import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dio.mockito.Email;
import com.dio.mockito.Formato;
import com.dio.mockito.PlataformaDeEnvio;
import com.dio.mockito.ServicoEnvioEmail;

@ExtendWith(MockitoExtension.class)
public class ServicoEnvioEmailTeste {

    @Mock
    private PlataformaDeEnvio plataformaDeEnvio;

    @InjectMocks
    private ServicoEnvioEmail servicoEnvioEmail;

    @Captor
    ArgumentCaptor<Email> captor;

    @Test
    void validarDadosEnviadosParaAPlataforma() {
        String enderecoDeEmail = "user@email.com";
        String mensagem = "Ola mundo";
        boolean ehFormatoHTML = false;

        servicoEnvioEmail.enviaEmail(enderecoDeEmail, mensagem, ehFormatoHTML);

        Mockito.verify(plataformaDeEnvio).enviaEmail(captor.capture());

        Email emailCapturado = captor.getValue();

        Assertions.assertEquals(enderecoDeEmail, emailCapturado.getEnderecoEmail());
        Assertions.assertEquals(mensagem, emailCapturado.getMensagem());
        Assertions.assertEquals(Formato.TEXTO, emailCapturado.getFormato());
    }

}
