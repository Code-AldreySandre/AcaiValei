package br.ufpa.tdd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Conta {
    private int saldo = 0;
    private final List<String> extrato = new ArrayList<>();

    public int getSaldo() {
        return this.saldo;
    }

    public List<String> getEntradas() {
        return Collections.unmodifiableList(this.extrato);
    }

    public void deposito(int quantia) {
        validarQuantia(quantia);
        this.saldo += quantia;
        registrar("DEPOSITO", quantia);
    }

    public void saque(int quantia) {
        validarQuantia(quantia);
        if (quantia > this.saldo) {
            throw new IllegalArgumentException("Saldo insuficiente.");
        }
        this.saldo -= quantia;
        registrar("SAQUE", quantia);
    }

    private void validarQuantia(int quantia) {
        if (quantia <= 0) {
            throw new IllegalArgumentException("A quantia deve ser maior que zero.");
        }
    }

    private void registrar(String tipo, int quantia) {
        this.extrato.add(tipo + ", " + quantia + ", " + this.saldo);
    }
}
