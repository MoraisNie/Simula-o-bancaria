package br.com.banco.modelos;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(int numero, Cliente titular) {
        super(numero, titular);
    }

    public void renderJuros(double taxaMensal) {
        double rendimento = this.saldo * taxaMensal;
        this.saldo += rendimento;
        System.out.println("Rendimento de R$" + String.format("%.2f", rendimento) + " aplicado à conta " + numero);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Poupança ===");
        System.out.println("Titular: " + titular.getNome());
        System.out.println("Conta: " + numero);
        System.out.println("Saldo Atual: R$" + String.format("%.2f", saldo));
        System.out.println("==============================");
    }
}
