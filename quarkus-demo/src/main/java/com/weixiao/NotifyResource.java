package com.weixiao;

import com.weixiao.spi.MessageSender;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.ServiceLoader;

/**
 * @author changzheng
 * @date 2025年12月31日 16:39
 */
@Path("/notify")
public class NotifyResource {
    @Inject
    Instance<MessageSender> senders;

    /**
     * 两个接口
     * /notify/email
     * /notify/sms
     *
     * @param type 对应类型
     * @param msg  发送的消息
     * @return 消息返回结果
     */
    @GET
    @Path("/{type}")
    public String notify(@PathParam("type") String type, @QueryParam("msg") String msg) {
        for (MessageSender sender : senders) {
            if (sender.getName().equalsIgnoreCase(type)) {
                sender.send(msg);
                return "Message sent via " + sender.getName();
            }
        }
        return "No provider found for type: " + type;
    }
}