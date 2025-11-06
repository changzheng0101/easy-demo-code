package com.weixiao.client;

import com.weixiao.RequestData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.Charset;

/**
 * @author changzheng
 * @date 2025年11月06日 10:18
 */
public class RequestDataEncoder extends MessageToByteEncoder<RequestData> {

    private final Charset charset = Charset.forName("UTF-8");

    @Override
    protected void encode(ChannelHandlerContext ctx,
                          RequestData msg, ByteBuf out) throws Exception {

        out.writeInt(msg.getIntValue());
        out.writeInt(msg.getStringValue().length());
        out.writeCharSequence(msg.getStringValue(), charset);
    }
}
