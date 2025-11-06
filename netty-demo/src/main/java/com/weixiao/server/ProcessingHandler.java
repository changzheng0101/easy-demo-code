package com.weixiao.server;

import com.weixiao.RequestData;
import com.weixiao.ResponseData;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author changzheng
 * @date 2025年11月05日 17:32
 */
public class ProcessingHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)
            throws Exception {
        RequestData requestData = (RequestData) msg;
        ResponseData responseData = new ResponseData();
        responseData.setIntValue(requestData.getIntValue() * 2);

        ChannelFuture future = ctx.writeAndFlush(responseData);
        future.addListener(ChannelFutureListener.CLOSE);
        System.out.println(requestData);
    }
}
