package br.com.banco.modelos;
import br.com.banco.excecoes.SaldoInsuficienteException;

public abstract class Conta {
    protected int numero;
    protected double saldo;
    protected Cliente titular;

    public Conta(int numero, Cliente titular) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado na conta " + numero);
        }
    }

    public void sacar(double valor) throws SaldoInsuficienteException {
        if (valor > this.saldo) {
            throw new SaldoInsuficienteException("Saldo insuficiente para saque. Saldo atual: R$" + this.saldo);
        }
        this.saldo -= valor;
        System.out.println("Saque de R$" + valor + " realizado na conta " + numero);
    }

    public void transferir(double valor, Conta contaDestino) throws SaldoInsuficienteException {
        this.sacar(valor);
        contaDestino.depositar(valor);
        System.out.println("Transferência de R$" + valor + " para a conta " + contaDestino.getNumero() + " realizada com sucesso.");
    }

    public double getSaldo() { return saldo; }
    public int getNumero() { return numero; }
    public Cliente getTitular() { return titular; }

    public abstract void imprimirExtrato();
}
