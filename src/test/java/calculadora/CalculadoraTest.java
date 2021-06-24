package calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {
    private Calculadora calc;

    @BeforeEach
    public void inicializa() {
        calc = new Calculadora();
    }

    @DisplayName("Testa a soma de dois n�meros")
    @Test
    public void testSomaDoisNumeros() {
        int soma = calc.soma(4, 5);
        assertEquals(9, soma);
    }

    @Test
    public void testDivisaoDoisNumeros() {
        int divisao = calc.divisao(8, 4);
        assertTrue(divisao == 2);
    }

    @Test
    public void testDivisaoPorZero() {
        try {
            int divisao = calc.divisao(8, 0);
            fail("Exce��o n�o lan�ada");
        }catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
    }

    @Test
    public void testDivisaoPorZeroComAssertThrows() {
        assertThrows(ArithmeticException.class,
                () -> calc.divisao(8, 0));
    }

    @Test
    public void testSubtracaoDoisNumeros() {
        int subtracao = calc.subtracao(10, 5);
        assertEquals(5, subtracao);
    }

    @Test
    public void testMultiplicacaoDoisNumeros() {
        int multiplicacao = calc.multiplicacao(10, 7);
        assertEquals(70, multiplicacao);
    }

    @Test
    public void testSomatoria() {
        int somatoria = calc.somatoria(3);
        assertEquals(6, somatoria);
    }

    @Test
    public void testNumeroEhPositivo() {
        Boolean EhPositivo1 = calc.ehPositivo(-4);
        assertEquals(false, EhPositivo1);

        Boolean EhPositivo2 = calc.ehPositivo(6);
        assertEquals(true, EhPositivo2);
    }
}
