package br.com.banco.servicos;
import br.com.banco.modelos.Conta;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        contas.add(conta);
    }

    public void listarContas() {
        System.out.println("\n--- Lista de Contas do Banco " + nome + " ---");
        for (Conta c : contas) {
            System.out.println("Conta: " + c.getNumero() + " | Titular: " + c.getTitular().getNome());
        }
        System.out.println("----------------------------------\n");
    }
}
