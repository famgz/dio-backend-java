package dio.springboot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SistemaMensagem implements CommandLineRunner {
    /*
     * 
     * @Value("${nome}") // get the value from application.properties
     * private String nome;
     * 
     * @Value("${email}")
     * private String email;
     */

    @Autowired
    private Remetente noreply;

    @Autowired
    private Remetente techTeam;

    public void enviarConfirmacaoCadastro() {
        System.out.println(noreply);
    }

    public void enviarMensagemBoasVindas() {
        techTeam.setEmail("tech@dio.br");
        System.out.println(techTeam);
        System.out.println("Bem vindo a Tech");
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Mensagem enviada por " + noreply.getNome() + noreply.getEmail());
    }

}
