import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {
    private Calculator calculator;

    @BeforeAll
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testStringToInteger() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> {
                    calculator.stringToInteger("+");
                }
        ).withMessageMatching("숫자가 아닙니다.");
    }

    @Test
    void testStringToChar() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> {
                    calculator.stringToChar("");
                }
        ).withMessageMatching("문자열이 비어있습니다.");
    }

    @Test
    void testAdd() {
        assertThat(calculator.add(4,3)).isEqualTo(7);
    }

    @Test
    void testSubtract() {
        assertThat(calculator.subtract(4,3)).isEqualTo(1);
    }

    @Test
    void testMultiply() {
        assertThat(calculator.multiply(4,3)).isEqualTo(12);
    }

    @Test
    void testDivide() {
        assertThat(calculator.divide(4,3)).isEqualTo(1);
    }

}