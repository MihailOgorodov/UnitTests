package seminars.fourth.message;


import org.example.Seminar4.message.MessageService;
import org.example.Seminar4.message.NotificationService;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class NotificationServiceTest {


    @Test
    void testNotificationService() {
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageService);

        notificationService.sendNotification("Hi!", "John");

        verify(messageService, times(1)).sendMessage("Hi!", "John");

    }
}