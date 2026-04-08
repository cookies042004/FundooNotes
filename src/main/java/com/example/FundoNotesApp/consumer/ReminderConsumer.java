package com.example.FundoNotesApp.consumer;

import com.example.FundoNotesApp.dto.ReminderDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ReminderConsumer {
    @RabbitListener(queues = "reminderQueue")
    public void receive(ReminderDto dto) {
        System.out.println("📩 Reminder received: " + dto.getMessage());
    }
}