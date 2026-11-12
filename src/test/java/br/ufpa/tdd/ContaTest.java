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

    @Test
    void saqueAlteraSaldoCorretamente() {
        Conta acc = new Conta();
        acc.deposito(100);
        acc.saque(40);
        
        assertEquals(60, acc.getSaldo());
    }

    @Test
    void extratoNaoPodeSerAlteradoExternamente() {
        Conta acc = new Conta();
        acc.deposito(100);
        assertThrows(UnsupportedOperationException.class, () -> {
            acc.getEntradas().clear();
        });
    }

    @Test
    void saqueCriaLancamentoNoExtrato() {
        Conta acc = new Conta();
        acc.deposito(100);
        acc.saque(40);
        assertEquals(2, acc.getEntradas().size());
        assertEquals("SAQUE, 40, 60", acc.getEntradas().get(1));
    }

    @Test
    void depositoComZeroOuValorNegativoLancaExcecao() {
        Conta acc = new Conta();

        assertThrows(IllegalArgumentException.class, () -> {
            acc.deposito(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            acc.deposito(-50);
        });
    }
    @Test
    void saqueComZeroOuValorNegativoLancaExcecao() {
        Conta acc = new Conta();
        acc.deposito(100);
        assertThrows(IllegalArgumentException.class, () -> {
            acc.saque(0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            acc.saque(-30);
        });
    }

    @Test
    void saqueMaiorQueSaldoLancaExcecaoSemColateral()
    {
        Conta acc = new Conta();
        acc.deposito(100);

        assertThrows(IllegalArgumentException.class, () -> {
            acc.saque(150);
        });

        assertEquals(100, acc.getSaldo());
        assertEquals(1, acc.getEntradas().size());
        assertEquals("DEPOSITO, 100, 100", acc.getEntradas().get(0));
    }
