package test.principal;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import principal.Calculadora;

class CalculadoraTest {
    Calculadora calc = new Calculadora();
    @Test
    void adicionar() {
        int expect = 2;
        assertEquals(expect, calc.adicionar(1, 1));
    }

    @Test
    void subtrair() {
        int expect = 0;
        assertEquals(expect, calc.subtrair(1, 1));
    }

    @Test
    void multiplicar() {
        int expect = 1;
        assertEquals(expect, calc.multiplicar(1, 1));
    }

    @Test
    void dividir() {
        int expect = 2;
        assertEquals(expect, calc.dividir(4, 2));
    }

    @Test
    void deveLançarException() {
        assertThrows(IllegalArgumentException.class, () -> {
           calc.dividir(1, 0);
        });

    }
}