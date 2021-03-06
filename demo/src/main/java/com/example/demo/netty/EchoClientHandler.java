package com.example.demo.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author gejiangbo
 * @Description
 * @date:2019/6/21
 * @mail jiangbo.ge@kuwo.cn
 */
public class EchoClientHandler extends SimpleChannelInboundHandler<ByteBuf> {
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("connecting... ");
        super.channelActive(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        System.out.println("Client received: " + ByteBufUtil.hexDump(msg.readBytes(msg.readableBytes())));
    }

    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("connect closed! ");
        super.channelInactive(ctx);
    }
}
