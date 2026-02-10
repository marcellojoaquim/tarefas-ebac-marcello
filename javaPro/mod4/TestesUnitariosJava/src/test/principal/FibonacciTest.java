package test.principal;

import org.junit.jupiter.api.Test;
import principal.Fibonacci;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {

    @Test
    void deveRetornarUm() {
        long expect = 1;
        long result = Fibonacci.fibonacci(1);
        assertEquals(expect, result);
    }

    @Test
    void deveRetornarSegundoElemento() {
        long expect = 1;
        long result = Fibonacci.fibonacci(2);
        assertEquals(expect, result);
    }

    @Test
    void deveRetornarSextoElemento() {
        long expect = 8;
        long result = Fibonacci.fibonacci(6);
        assertEquals(expect, result);
    }

    @Test
    void deveRetornarODecimoElemento() {
        long expect = 55;
        long result = Fibonacci.fibonacci(10);
        assertEquals(expect, result);
    }

}