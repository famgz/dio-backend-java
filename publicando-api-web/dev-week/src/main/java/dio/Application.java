package dio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(servers = { @Server(url = "/", description = "Default server URL") })
@SpringBootApplication
public class Application {

    static {
        String activeProfile = System.getProperty("spring.profiles.active");

        if ("prod".equals(activeProfile)) {
            Dotenv dotenv = Dotenv.configure().load();
            setSystemProperty("PGHOST", dotenv);
            setSystemProperty("PGPORT", dotenv);
            setSystemProperty("PGDATABASE", dotenv);
            setSystemProperty("DB_USERNAME", dotenv);
            setSystemProperty("DB_PASSWORD", dotenv);
        }
    }

    private static void setSystemProperty(String key, Dotenv dotenv) {
        String value = dotenv.get(key);
        if (value != null) {
            System.setProperty(key, value);
        } else {
            throw new RuntimeException("Environment variable " + key + " is not set.");
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
