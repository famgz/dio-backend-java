package com.dio;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Carlos Nascimento", "1233456456");

        var cc = new ContaCorrente(cliente);
        var cp = new ContaPoupanca(cliente);

        cc.depositar(100);

        cc.transferir(cp, 50);

        cc.imprimirExtrato();
        cp.imprimirExtrato();

    }
}