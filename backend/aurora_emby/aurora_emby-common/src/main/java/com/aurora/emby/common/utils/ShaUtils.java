package com.aurora.emby.common.utils;

import org.springframework.util.Base64Utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class ShaUtils {

    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");

    /**
     * 传入文本内容，返回 SHA-256 串
     *
     * @param text
     * @return
     */
    public static String encode256(final String text) {
        return encode(text, "SHA-256");
    }

    /**
     * 传入文本内容，返回 SHA-512 串
     *
     * @param text
     * @return
     */
    public static String encode512(final String text) {
        return encode(text, "SHA-512");
    }

    /**
     * 字符串 SHA 加密
     *
     * @param text
     * @param encodeType
     * @return
     */
    private static String encode(final String text, final String encodeType) {
        // 返回值
        String result = null;

        // 是否是有效字符串
        if (text != null && text.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并传入加密类型
                MessageDigest messageDigest = MessageDigest.getInstance(encodeType);
                // 传入要加密的字符串
                messageDigest.update(text.getBytes(DEFAULT_CHARSET));
                // 得到 byte 类型结果
                byte[] bytes = messageDigest.digest();

                // 将 byte 转换为 string
                StringBuffer strHexString = new StringBuffer();
                // 遍历 byte buffer
                for (int i = 0; i < bytes.length; i++) {
                    String hex = Integer.toHexString(0xff & bytes[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回结果
                result = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    /**
     * HmacSHA256加密
     *
     * @param content
     * @param secret
     * @return
     */
    public static String hmacSHA256(String content, String secret) {

        try {

            Mac hmacSHA256 = Mac.getInstance("HmacSHA256");
            SecretKeySpec keySpec = new SecretKeySpec(secret.getBytes(DEFAULT_CHARSET), "HmacSHA256");
            hmacSHA256.init(keySpec);

            return Base64Utils.encodeToUrlSafeString(hmacSHA256.doFinal(content.getBytes(DEFAULT_CHARSET)));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        return null;
    }

}
