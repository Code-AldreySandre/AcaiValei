package br.ufpa.tdd;

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private int saldo = 0;
    public int getSaldo() {
        return this.saldo;
    }

    public List<String> getEntradas() {
        return new ArrayList<>(); 
    }

    public void deposito(int quantia) {
        this.saldo += quantia;
    }
}