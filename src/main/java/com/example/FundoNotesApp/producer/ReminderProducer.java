package com.example.FundoNotesApp.producer;

import com.example.FundoNotesApp.config.RabbitMQConfig;
import com.example.FundoNotesApp.dto.ReminderDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class ReminderProducer {
    private final RabbitTemplate rabbitTemplate;

    public ReminderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendReminder(ReminderDto dto) {
        rabbitTemplate.convertAndSend(
                RabbitMQConfig.EXCHANGE,
                RabbitMQConfig.ROUTING_KEY,
                dto
        );
    }
}