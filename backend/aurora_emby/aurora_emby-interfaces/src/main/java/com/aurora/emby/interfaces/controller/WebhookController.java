package com.aurora.emby.interfaces.controller;


import com.aurora.emby.application.tg.MyTelegramBot;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

import javax.annotation.Resource;

@RestController
@RequestMapping
public class WebhookController {


    @Resource
    private  MyTelegramBot telegramBot;


    // 监听 Webhook 路径并接收 Telegram 发送的更新
    @PostMapping("/webhook/callback/webhook")
    public void receiveWebhook(@RequestBody Update update) {
        System.out.println("webhook Received update:" + update);
        // 将 Telegram 传递的 Update 交给 Bot 处理
        telegramBot.onWebhookUpdateReceived(update);

    }



    @RequestMapping("/test")
    public int receive() {
        return 0;
    }
}