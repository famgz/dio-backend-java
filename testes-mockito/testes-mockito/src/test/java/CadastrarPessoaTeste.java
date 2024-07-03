import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.dio.mockito.ApiDosCorreios;
import com.dio.mockito.CadastrarPessoa;
import com.dio.mockito.DadosLocalizacao;
import com.dio.mockito.Pessoa;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

    // @BeforeAll
    // void setup() {
    // MockitoAnnotations.initMocks(this);
    // }

    @Mock
    private ApiDosCorreios apiDosCorreios = Mockito.mock(ApiDosCorreios.class);

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro() {
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("PB", "Cidade", "Rua dos bancarios", "casa",
                "Bairro novo");
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("78787878")).thenReturn(dadosLocalizacao);
        Pessoa pessoa = cadastrarPessoa
                .cadastrarPessoa(("Wilks"), "123123", LocalDate.of(1980, 1, 1), "78787878");

        assertEquals("Wilks", pessoa.getNome());
        assertEquals("123123", pessoa.getDocumento());
        assertEquals("PB", pessoa.getEndereco().getUf());

    }

}
