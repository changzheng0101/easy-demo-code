# netty

netty中的Channel操作都是NIO，会直接返回，不会阻塞。  
一般会返回ChannelFuture，这个可以在成功的时候触发回调，Java的Future需要阻塞线程直到执行完成。

ChannelInboundHandler --> ChannelInboundHandlerAdapter -->  ByteToMessageDecoder

ChannelInboundHandler 处理输入事件，Adapter提供很多空实现，子类只用关心自己想要监听的事件。

Netty 抽象出两组线程池，BossGroup 专门负责接收客户端连接，WorkerGroup 专门负责网络读写操作；

