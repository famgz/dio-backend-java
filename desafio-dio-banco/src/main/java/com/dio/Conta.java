package com.dio;

public abstract class Conta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    int agencia;
    int numero;
    double saldo;
    Cliente cliente;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public abstract void imprimirExtrato();

    protected void imprimirInfosComuns() {
        System.out.println("Agencia: " + agencia);
        System.out.println("Numero: " + numero);
        System.out.println("Saldo: R$ " + saldo);
    }

    public void depositar(double valor) {
        saldo += valor;

    }

    public void sacar(double valor) {
        if (valor > saldo)
            return;
        saldo -= valor;
    }

    public void transferir(Conta contaDestino, double valor) {
        sacar(valor);
        contaDestino.depositar(valor);
    }

}
