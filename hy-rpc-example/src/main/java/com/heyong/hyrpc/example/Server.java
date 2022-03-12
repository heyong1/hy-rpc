package com.heyong.hyrpc.example;

import com.heyong.hyrpc.server.RpcServer;
import com.heyong.hyrpc.server.RpcServerConfig;

/**
 * Description
 *
 * @Author heyong
 * @Date 2022/3/11 21:23
 */
public class Server {
    public static void main(String[] args) {
        RpcServerConfig config = new RpcServerConfig();
        RpcServer server = new RpcServer(config);
        server.register(CalcService.class, new CalcServiceImpl());
        server.start();
    }
}
