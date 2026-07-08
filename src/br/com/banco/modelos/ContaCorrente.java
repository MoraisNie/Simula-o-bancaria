package br.com.banco.modelos;
import br.com.banco.excecoes.SaldoInsuficienteException;

public class ContaCorrente extends Conta {
    private static final double TAXA_SAQUE = 2.50;

    public ContaCorrente(int numero, Cliente titular) {
        super(numero, titular);
    }

    @Override
    public void sacar(double valor) throws SaldoInsuficienteException {
        double valorTotal = valor + TAXA_SAQUE;
        super.sacar(valorTotal);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato Conta Corrente ===");
        System.out.println("Titular: " + titular.getNome());
        System.out.println("Conta: " + numero);
        System.out.println("Saldo Atual: R$" + String.format("%.2f", saldo));
        System.out.println("==============================");
    }
}
