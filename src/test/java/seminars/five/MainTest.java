package seminars.five;


import org.example.Seminar5.number.MaxNumberModule;
import org.example.Seminar5.number.RandomNumberModule;
import org.example.Seminar5.order.OrderService;
import org.example.Seminar5.order.PaymentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.example.Seminar5.user.UserRepository;
import org.example.Seminar5.user.UserService;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    RandomNumberModule randModule;
    MaxNumberModule maxNumModule;

    @BeforeEach
    void setUp() {
        randModule = new RandomNumberModule();
        maxNumModule = new MaxNumberModule();
    }


    //5.1.

    @Test
    void testRandomGenerate() {
        List<Integer> res = randModule.generate(6);

        assertEquals(6, res.size());
    }

    @Test
    void testMaxNumberModule() {
        List<Integer> nums = Arrays.asList(4, 5, 6, 7, 8, 7, 2);

        int max = maxNumModule.findMax(nums);

        assertEquals(8, max);
    }

    @Test
    void integrationTest() {
        List<Integer> nums = randModule.generate(6);

        assertEquals(Collections.max(nums), maxNumModule.findMax(nums));

    }


    //5.2.
    @Test
    void testUserIntegration() {
        UserService userService = new UserService(new UserRepository());

        String user = userService.getUserName(0);

        assertEquals("User 0", user);
    }


    //5.3.

    @Test
    void testOrderServiceIntegration() {
        OrderService orderService = new OrderService(new PaymentService());

        boolean res = orderService.placeOrder("123", 1200);

        assertTrue(res);
    }

}