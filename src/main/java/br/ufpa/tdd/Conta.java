package br.ufpa.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Conta {
    
    private int saldo = 0;
    private List<String> extrato = new ArrayList<>(); 
    
    public int getSaldo() {
        return this.saldo;
    }

    public List<String> getEntradas() {
        // Devolve uma versão protegida: quem chamar pode ler, mas não pode alterar
        return Collections.unmodifiableList(this.extrato);
    }

    public void deposito(int quantia) {
        this.saldo += quantia;
        this.extrato.add("DEPOSITO, " + quantia + ", " + this.saldo);
    }

    public void saque(int quantia) {
        this.saldo -= quantia;
        this.extrato.add("SAQUE, " + quantia + ", " + this.saldo);
    }
}