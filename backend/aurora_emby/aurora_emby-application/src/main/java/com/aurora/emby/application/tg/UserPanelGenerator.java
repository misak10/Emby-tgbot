package com.aurora.emby.application.tg;

import com.aurora.emby.application.tg.MyTelegramBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class UserPanelGenerator {

    // 生成用户信息文本
    private static String generateUserText(String userId, String status, int score, String username, String expiryTime) {
        StringBuilder userInfo = new StringBuilder();
        userInfo.append("欢迎进入用户面板！\n")
                .append("🌟 用户的 ID: ").append(userId).append("\n")
                .append("📖 当前状态: ").append(status).append("\n")
                .append("💎 积分狗毛: ").append(score).append("\n")
                .append("📛 账号名称: ").append(username).append("\n")
                .append("⏳ 到期时间: ").append(expiryTime).append("\n");
        return userInfo.toString();
    }

    // 发送用户信息面板并添加自定义键盘
    public static void sendUserPanelWithCustomKeyboard(Long chatId, String userId, String status, int score, String username, String expiryTime, MyTelegramBot bot) {
        // 生成用户面板文本
        String userInfoText = generateUserText(userId, status, score, username, expiryTime);

        // 创建自定义键盘
        ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<>();

        // 第一行按钮
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("兑换商店"));
        row1.add(new KeyboardButton("删除账号"));

        // 第二行按钮
        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("显示/隐藏"));
        row2.add(new KeyboardButton("重置密码"));

        // 第三行按钮
        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("我的收藏"));
        row3.add(new KeyboardButton("我的设备"));

        // 添加按钮行
        keyboardRows.add(row1);
        keyboardRows.add(row2);
        keyboardRows.add(row3);

        // 设置键盘
        keyboardMarkup.setKeyboard(keyboardRows);
        keyboardMarkup.setResizeKeyboard(true); // 调整键盘大小

        // 创建并发送消息
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(userInfoText);
        message.setReplyMarkup(keyboardMarkup); // 设置自定义键盘

        try {
            bot.execute(message); // 发送消息
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}

