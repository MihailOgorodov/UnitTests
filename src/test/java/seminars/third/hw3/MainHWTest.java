package seminars.third.hw3;

import org.example.Seminar3.hw.MainHW;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainHWTest {

    /**
     * Тестируем корректность четного числа
     * ожидаем получить от метода evenOddNumber - true
     */
    @Test
    void checkEvenNumber() {
        assertTrue(MainHW.evenOddNumber(4));
    }

    /**
     * Тестируем корректность четного числа
     * ожидаем получить от метода evenOddNumber - false
     */
    @Test
    void checkOddNumber() {
        assertFalse(MainHW.evenOddNumber(3));
    }

    /**
     * Тестируем корректность нахождения числа в интервале (25;100)
     * ожидаем получить от метода numberInInterval - true
     */
    @Test
    void checkNumberInInterval() {
        assertTrue(MainHW.numberInInterval(25));
        assertTrue(MainHW.numberInInterval(100));
    }

    /**
     * Тестируем корректность нахождения числа в интервале (25;100)
     * ожидаем получить от метода numberInInterval - false
     */
    @Test
    void checkNumberNotInInterval() {
        assertFalse(MainHW.numberInInterval(24));
        assertFalse(MainHW.numberInInterval(101));
    }
}