package com.example.notification.service;

import com.example.notification.event.TransferEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationService {

    public void processTransferNotification(TransferEvent event) {
        log.info("📤 NOTIFICATION [User {}]: Перевод #{} выполнен. " +
                        "Сумма: {} ₽ отправлена с карты {} на карту {}",
                event.senderUserId(),
                event.transferId(),
                event.amount(),
                event.senderCardMasked(),
                event.recipientCardMasked()
        );

        log.info("📥 NOTIFICATION [User {}]: Получен перевод #{}. " +
                        "Сумма: {} ₽ на карту {} от карты {}",
                event.recipientUserId(),
                event.transferId(),
                event.amount(),
                event.recipientCardMasked(),
                event.senderCardMasked()
        );
    }
}
