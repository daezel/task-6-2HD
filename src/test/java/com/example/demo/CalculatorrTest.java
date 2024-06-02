package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;;

@SpringBootTest
class CalculatorrTest {
    @Test
    public void testAddition() {
        Calculatorr calculator = new Calculatorr();
        int result = calculator.add(8, 4);
        assertEquals(result == 12, "The addition of 8 and 4 is 12");
    }

    @Test
    public void testSubtract() {
        Calculatorr calculator = new Calculatorr();
        int result = calculator.subtract(8, 4);
        assertEquals(result == 4, "The subtract of 8 and 4 should be 4");
    }

    @Test
    public void testMultiplication() {
        Calculatorr calculator = new Calculatorr();
        int result = calculator.multiply(8, 4);
        assertEquals(result == 32, "The multiply of 8 and 4 should be 32");
    }

    @Test
    public void testDivision() {
        Calculatorr calculator = new Calculatorr();
        int result = calculator.divide(8, 4);
        assertEquals(result == 2, "The division of 8 and 4 should be 2");
    }
}