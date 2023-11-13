package seminars.fourth.card;

import org.example.Seminar4.card.CreditCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CreditCardTest {
    CreditCard creditCard;

    @BeforeEach
    void SetUp(){
        creditCard = new CreditCard("4565987845651232", "Makito Hansa","31.12.2033","111");
    }

    @Test
    void testGetCardNumber(){
        assertEquals("4565987845651232", creditCard.getCardNumber());
    }
    @Test
    void testGetCardHolder(){
        assertEquals("Makito Hansa", creditCard.getCardHolder());
    }
    @Test
    void testGetExpiryDate(){
        assertEquals("31.12.2033", creditCard.getExpiryDate());
    }
    @Test
    void testGetCvv(){
        assertEquals("111", creditCard.getCvv());
    }

    @Test
    void testCharge(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        creditCard.charge(1200.00);
        assertEquals("Charged amount 1200.0 from the card: 4565987845651232", outputStream.toString().trim());

        System.setOut(null);
    }
}
