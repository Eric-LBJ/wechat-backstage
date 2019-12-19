package com.corereach.communication.wechatbackstage.server;

import com.corereach.communication.wechatbackstage.comm.Constants;
import com.corereach.communication.wechatbackstage.server.initializer.WebSocketServerInitializer;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Description: TODO
 * @Author ga.zhang
 * @Date 2019/12/19 14:27
 * @Version V1.0
 **/
@Component
public class ChatServer {

    @Resource
    private WebSocketServerInitializer webSocketServerInitializer;

    private static final Logger log = LoggerFactory.getLogger(ChatServer.class);

    private static class SingletonChatServer{
        private static final ChatServer instance = new ChatServer();
    }

    public static ChatServer getInstance(){
        return SingletonChatServer.instance;
    }

    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    private ServerBootstrap server;
    private ChannelFuture future;

    public ChatServer(){
        bossGroup = new NioEventLoopGroup();
        workerGroup = new NioEventLoopGroup();
        server = new ServerBootstrap();
        server.group(bossGroup,workerGroup)
                .channel(NioServerSocketChannel.class)
//                .childHandler(webSocketServerInitializer);
                .childHandler(new WebSocketServerInitializer());
    }

    public void start(){
        /**这里不需要加同步，因为这里并不是处于main方法中*/
        this.future = server.bind(Constants.SERVER_PORT);
        log.info("log ChatServer启动完毕。。。");
    }

}
