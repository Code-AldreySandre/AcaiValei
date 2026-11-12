package br.ufpa.tdd;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    @Test
    void novaContaIniciaComSaldo0() {
        Conta acc = new Conta();
        assertEquals(0, acc.getSaldo());
    }

    @Test
    void novaContaIniciaComExtratoVazio() {
        Conta acc = new Conta();
        assertTrue(acc.getEntradas().isEmpty());
    }

    @Test
    void depositoAlteraSaldoCorretamente() {
        Conta acc = new Conta();
        acc.deposito(100);
        assertEquals(100, acc.getSaldo());
    }

    @Test
    void depositoCriaLancamentoNoExtrato() {
        Conta acc = new Conta();
        acc.deposito(100);
        
        assertEquals(1, acc.getEntradas().size());
        assertEquals("DEPOSITO, 100, 100", acc.getEntradas().get(0));
    }

}