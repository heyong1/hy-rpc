package com.heyong.hyrpc.transport;

import com.heyong.hyrpc.Peer;

import java.io.InputStream;

/**
 * Description 1.创建连接
 * 2. 发送数据，等待响应
 * 3. 关闭连接
 *
 * @Author heyong
 * @Date 2022/3/10 20:28
 */
public interface TransportClient {
    void connect(Peer peer);

    InputStream write(InputStream data);

    void close();
}
