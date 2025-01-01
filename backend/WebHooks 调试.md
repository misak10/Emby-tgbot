WebHooks 调试

如何查询设置的webHooks是否成功 请求如下地址就可以：

```
https://api.telegram.org/bot<YOUR_BOT_API_TOKEN>/getWebhookInfo
```

这个token就是你申请的token

比如我申请的机器人的token是：

```
7810606621:AAEJIPwa8zfbYaooJQZNWdXQ88GuKUwpiz
```

 那么我的地址就是：

```
https://api.telegram.org/bot7810606621:AAEJIPwa8zfbYaooJQZNWdXQ88GuKUwpiz/getWebhookInfo
```

如果设置成功那么就会返回：

```
{"ok":true,"result":{"url":"https://c270-223-73-62-50.ngrok-free.app/webhook/callback/webhook","has_custom_certificate":false,"pending_update_count":0,"max_connections":40,"ip_address":"18.192.31.165"}}
```







其实手动设置webhook是这么设置的

```
https://api.telegram.org/bot<you token>/setWebhook?url=webhook path
```



```
https://api.telegram.org/bot7810606621:AAEJIPwa8zfbYaooJQZNWdXQ88GuKUwpiz/setWebhook?url=https://97cc-223-73-62-50.ngrok-free.app:443/webhook
```



