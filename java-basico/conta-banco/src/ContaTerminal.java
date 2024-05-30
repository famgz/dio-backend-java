import java.util.Locale;
import java.util.Scanner;

public class ContaTerminal {
    public static void main(String[] args) throws Exception {

        int numero;
        String agencia;
        String nomeCliente;
        float saldo;

        Scanner scan = new Scanner(System.in);
        scan.useLocale(Locale.US);

        System.out.println("Digite numero conta: ");
        numero = scan.nextInt();
        scan.nextLine();

        System.out.println("Digite numero agencia: ");
        agencia = scan.nextLine();

        System.out.println("Digite nome do cliente: ");
        nomeCliente = scan.nextLine();

        System.out.println("Digite saldo da conta: ");
        saldo = scan.nextFloat();

        System.out.printf(
                "Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %f já está disponível para saque.",
                nomeCliente, agencia, numero, saldo);

        scan.close();
    }
}