package com.weixiao.client;

import com.weixiao.ResponseData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author changzheng
 * @date 2025年11月06日 10:19
 */
public class ResponseDataDecoder extends ReplayingDecoder<ResponseData> {

    @Override
    protected void decode(ChannelHandlerContext ctx,
                          ByteBuf in, List<Object> out) throws Exception {

        ResponseData data = new ResponseData();
        data.setIntValue(in.readInt());
        out.add(data);
    }
}
