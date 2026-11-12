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
        return Collections.unmodifiableList(this.extrato);
    }
    public void deposito(int quantia) {
        if (quantia <= 0) {
            throw new IllegalArgumentException("A quantia do depósito deve ser maior que zero.");
        }
        this.saldo += quantia;
        this.extrato.add("DEPOSITO, " + quantia + ", " + this.saldo);
    }

    @fix
    public void saque(int quantia) {
        if (quantia <= 0){
            throw new IllegalArgumentException("A quantia deve ser maior que zero");
        }
        if (quantia > this.saldo){
            throw new IllegalArgumentException("Saldo Insuficiente.");
        }
        this.saldo -= quantia;
        this.extrato.add("SAQUE, " + quantia + ", " + this.saldo);
    }
}
