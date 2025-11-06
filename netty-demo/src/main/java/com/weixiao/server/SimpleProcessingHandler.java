package com.weixiao.server;

import com.weixiao.RequestData;
import com.weixiao.ResponseData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author changzheng
 * @date 2025年11月05日 17:19
 */
public class SimpleProcessingHandler extends ChannelInboundHandlerAdapter {
    private ByteBuf tmp;

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        System.out.println("Handler added");
        tmp = ctx.alloc().buffer(4);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        System.out.println("Handler removed");
        tmp.release();
        tmp = null;
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf m = (ByteBuf) msg;
        tmp.writeBytes(m);
        // 释放已经读取到的数据
        m.release();
        if (tmp.readableBytes() >= 4) {
            RequestData requestData = new RequestData();
            requestData.setIntValue(tmp.readInt());
            ResponseData responseData = new ResponseData();
            responseData.setIntValue(requestData.getIntValue() * 2);

            ChannelFuture future = ctx.writeAndFlush(responseData);
            future.addListener(ChannelFutureListener.CLOSE);
        }
    }
}
