package com.aurora.emby.application.tg;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.updates.SetWebhook;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
@Slf4j
public class WebhookInitializer implements CommandLineRunner {

    private final MyTelegramBot myTelegramBot;

    @Value("${telegram.bot.webhookHost}")
    private String webhookHost;

    @Value("${telegram.bot.webhookPath}")
    private String webhookPath;

    @Value("${telegram.bot.webhookPort}")
    private int webhookPort;

    public WebhookInitializer(MyTelegramBot myTelegramBot) {
        this.myTelegramBot = myTelegramBot;
    }

    @Override
    public void run(String... args) throws TelegramApiException {
        log.info("Initializing Webhook...");
        // 动态构建 Webhook URL
        String webhookUrl = buildWebhookUrl();
        log.info("Webhook URL: {}", webhookUrl);

        // 设置 Webhook 配置
        SetWebhook setWebhook = new SetWebhook();
        setWebhook.setUrl(webhookUrl);  // 动态设置 Webhook URL

        // 注册 Webhook

        try {
            myTelegramBot.setWebhook(setWebhook);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }

    private String buildWebhookUrl() {
        return String.format("%s%s", webhookHost, webhookPath);
    }
}


