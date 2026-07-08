package br.com.banco;

import br.com.banco.excecoes.SaldoInsuficienteException;
import br.com.banco.modelos.Cliente;
import br.com.banco.modelos.ContaCorrente;
import br.com.banco.modelos.ContaPoupanca;
import br.com.banco.servicos.Banco;

public class Main {
    public static void main(String[] args) {
        // 1. Criando o Banco
        Banco meuBanco = new Banco("JavaBank Internacional");

        // 2. Criando Clientes
        Cliente cliente1 = new Cliente("Ana Souza", "111.222.333-44");
        Cliente cliente2 = new Cliente("Carlos Lima", "555.666.777-88");

        // 3. Criando Contas
        ContaCorrente cc = new ContaCorrente(1001, cliente1);
        ContaPoupanca cp = new ContaPoupanca(2002, cliente2);

        meuBanco.adicionarConta(cc);
        meuBanco.adicionarConta(cp);

        meuBanco.listarContas();

        // 4. Simulando Operações
        try {
            System.out.println("--- Iniciando Transações ---");
            cc.depositar(1500.00);
            cp.depositar(500.00);

            // Transferindo da CC para a CP (será cobrada a taxa de saque da CC)
            cc.transferir(300.00, cp);

            // Rendimento na poupança (ex: 1% ao mês)
            cp.renderJuros(0.01);

            // Tentando sacar mais do que tem (Vai disparar a Exceção)
            // cc.sacar(5000.00); // Descomente para testar o erro

        } catch (SaldoInsuficienteException e) {
            System.err.println("ERRO NA TRANSAÇÃO: " + e.getMessage());
        }

        System.out.println("\n--- Extratos Finais ---");
        cc.imprimirExtrato();
        cp.imprimirExtrato();
    }
}
