package com.heyong.hyrpc.transport;

/**
 * Description 1. 启动，监听
 * 2. 接受请求
 * 3. 关闭监听
 *
 * @Author heyong
 * @Date 2022/3/10 20:31
 */
public interface TransportServer {
    void init(int port, RequestHandler handler);

    void start();

    void stop();
}
