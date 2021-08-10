package com.xkf.system.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author xukefei
 * @create 2021-08-10 上午9:43
 */
@ServerEndpoint(value = "/websocket")
@Component
public class MyWebSocket {
    static Logger logger = LoggerFactory.getLogger(MyWebSocket.class);

    // 静态变量，记录当前的连接数
    private static int onlineCount = 0;

    // 线程安全的Set，用于存放每个客户端对应的MyWebSocket对象
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    // 和某个客户端连接会话时，用来给客户端发送数据
    private Session session;

    /**
     * 连接成功调用的方法
     */
    @OnOpen
    public void OnOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        logger.info("有新连接加入，当前在线人数为：" + onlineCount);
        try {
            sendMessage("您已成功连接");
        } catch (IOException e) {
            logger.warn("IO异常");
        }
    }

    /**
     * 连接关闭调用方法
     */
    @OnClose
    public void OnClose() {
        webSocketSet.remove(this);
        subOnlineCount();
        logger.info("有一个连接关闭，当前在线人数为：" + onlineCount);
    }

    /**
     * 收到客户端消息时调用方法
     */
    @OnMessage
    public void OnMessage(String msg, Session session) {
        logger.info("来自客户端的消息：" + msg);

        // 群发消息
        for (MyWebSocket item : webSocketSet) {
            try {
                item.sendMessage(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void OnError(Session session, Throwable error) {
        logger.info("发生错误");
        error.printStackTrace();
    }

    /**
     * 自定义群发消息
     */
    public static void SendInfo(String msg) {
        for (MyWebSocket item : webSocketSet) {
            try {
                item.sendMessage(msg);
            } catch (IOException e) {
                continue;
            }
        }
    }

    public void sendMessage(String msg) throws IOException {
        this.session.getBasicRemote().sendText(msg);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount ++ ;
    }

    public static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount -- ;
    }
}
