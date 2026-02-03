package com.example.notification.consumer;

import com.example.notification.event.TransferEvent;
import com.example.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class TransferEventConsumer {

    private final NotificationService notificationService;

    @KafkaListener(
            topics = "bank.transfers",
            groupId = "bank_notification_service"
    )
    public void handleTransferEvent(TransferEvent event) {
        log.debug("Received transfer event: transferId={}", event.transferId());

        try {
            notificationService.processTransferNotification(event);
        } catch (Exception e) {
            log.error("Error processing transfer event: transferId={}", event.transferId(), e);
        }
    }
}
