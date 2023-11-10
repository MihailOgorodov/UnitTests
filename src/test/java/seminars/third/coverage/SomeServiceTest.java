package seminars.third.coverage;

import org.assertj.core.api.AssertionsForClassTypes;
import org.example.Seminar3.coverage.SomeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.Assert.*;

class SomeServiceTest {
    SomeService someService;

    // 3.1.
    @BeforeEach
    void SetUp() {
        someService = new SomeService();
    }

    @Test
    void multipleThreeNotFiveReturnsFizz() {
        assertEquals("Fizz", someService.fizzBuzz(3));
    }

    @Test
    void multipleThreeNotFiveReturnsBuzz() {
        assertEquals("Buzz", someService.fizzBuzz(5));
    }

    @Test
    void multipleThreeNotFiveReturnsFizzBuzz() {
        assertEquals("FizzBuzz", someService.fizzBuzz(15));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 7, 11, 17, 22})
    void multipleThreeNotFiveReturnsNumber(int i) {
        assertEquals(String.valueOf(i), someService.fizzBuzz(i));
    }

    @Test
    void checkFirstLast6IsTrue() {
        assertTrue(someService.firstLast6(new int[]{6, 2, 3}));
        assertTrue(someService.firstLast6(new int[]{2, 3, 6}));
    }

    @Test
    void checkFirstLast6IsFalse() {
        assertFalse(someService.firstLast6(new int[]{2, 6, 3}));
        assertFalse(someService.firstLast6(new int[]{2, 3}));
    }

    @ParameterizedTest
    @CsvSource({"2000.0,50,1000", "2000.0,100,0", "2000.0,0,2000"})
    void insufficientCoverageTest(double i, int d, int r) {
        AssertionsForClassTypes.assertThat(someService.calculatingDiscount(i, d)).isEqualTo(r);// обычная скидка
    }

    @Test
    void discountSubZero() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки меньше 0
    }

    @Test
    void discountOverThat100() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, 101))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%
    }

    @Test
    void correctLuckySum() {
        AssertionsForClassTypes.assertThat(someService.luckySum(1, 4, 8)).isEqualTo(13);
    }

    @Test
    void correctLuckySum1() {
        AssertionsForClassTypes.assertThat(someService.luckySum(1, 4, 8)).isEqualTo(13);
    }
}