package com.aurora.emby.application.tg;

import com.aurora.emby.common.catchlog.CatchAndLog;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@CatchAndLog
public class MyTelegramBot extends TelegramWebhookBot {

    @Value("${telegram.bot.username}")
    private String botUsername;

    @Value("${telegram.bot.token}")
    private String botToken;

    @Value("${telegram.bot.webhookPath}")
    private String webhookPath;

    @Override
    public String getBotUsername() {
        return botUsername;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotPath() {
        return webhookPath;  // Webhook 路径
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        // 处理接收到的 Webhook 消息
        if (update.hasMessage() && update.getMessage().hasText()) {
            return handleTextMessage(update);
        } else {
            log.warn("Received unsupported update: " + update);
            return null;  // 如果不是文本消息或无法处理的更新，返回 null
        }
    }

    private BotApiMethod<?> handleTextMessage(Update update) {
        Message message = update.getMessage();
        String receivedText = message.getText();
        Long chatId = message.getChatId();

        if("/start".equals(receivedText)){

            // 获取用户 ID（发送消息的用户）
            String userId = message.getFrom().getId().toString(); // 用户 ID 是 Long 类型，所以转为 String 使用

            // 获取用户名（如果有的话）
            String username = message.getFrom().getUserName();

            // 获取当前状态
            String status = "正常";  // 可以根据实际情况动态设置

            // 设置积分（示例积分值）
            int score = 340;

            // 设置到期时间（示例时间）
            String expiryTime = "2025-01-23 23:07:45";

            //UserPanelGenerator.sendUserPanelWithCustomKeyboard(chatId, userId, status, score, username, expiryTime, this);
            FloatingKeyboardPanel.sendUserPanelWithFloatingKeyboard(chatId, userId, status, score, username, expiryTime, this);
            return new SendMessage();
        }

        log.info("Received message: {} from chatId: {}", receivedText, chatId);

        // 生成回复消息
        String replyText = "receiver: " + receivedText;

        // 创建发送消息对象
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(replyText);

        try {
            // 发送消息
            execute(sendMessage);  // 使用 execute() 发送消息
        } catch (TelegramApiException e) {
            log.error("Error occurred while sending message", e);
        }

        return sendMessage;
    }
}
