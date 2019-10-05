package test.java;

import main.java.Calculator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Suffix Test !!!
public class CalculatorTest {

    @Test
    public void calculatorShouldMultiplyNumbers() {
        Calculator calculator = new Calculator();

        // Testeaza ca multiply-ul din calculator intoarce valoarea 6 pentru 2, 3
        assertEquals("Multiplication failed!", 6, calculator.multiply(2, 3));
        // Regresie, ne-am asigurat ca prima functionalitate merge si cea noua nu.
        // Merge, next cycle.
    }

    @Test
    public void calculatorShouldAddNumbers() {
        Calculator calculator = new Calculator();

        // Testeaza ca multiply-ul din calculator intoarce valoarea 6 pentru 2, 3
        assertEquals("Addition failed!", 5, calculator.addition(2, 3));

        // Merge, next cycle.
    }
}
