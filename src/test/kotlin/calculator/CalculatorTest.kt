package calculator

import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculatorTest {
    @Test
    fun testWhiteSpace() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            val calculator = Calculator(" ")
            calculator.expression
        }.withMessageMatching("Wrong input")
    }

    @Test
    fun testOperator() {
        assertThatExceptionOfType(IllegalArgumentException::class.java).isThrownBy {
            val calculator = Calculator("1 3 2")
            calculator.calculate()
        }.withMessageMatching("Not a valid operator")
    }

    @Test
    fun testAdd() {
        val expected = 5
        assertEquals(expected, Calculator.add(2, 3))
    }

    @Test
    fun testSubtract() {
        val expected = 1
        assertEquals(expected, Calculator.subtract(3, 2))
    }

    @Test
    fun testMultiply() {
        val expected = 6
        assertEquals(expected, Calculator.multiply(2, 3))
    }

    @Test
    fun testDivide() {
        val expected = 2
        assertEquals(expected, Calculator.divide(4, 2))
    }
}