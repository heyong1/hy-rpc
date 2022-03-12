package com.heyong.hyrpc.example;

import com.heyong.hyrpc.client.RpcClient;

/**
 * Description
 *
 * @Author heyong
 * @Date 2022/3/11 21:23
 */
public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService calcService = client.getProxy(CalcService.class);

        int add = calcService.add(1, 2);
        int minus = calcService.minus(4, 1);

        System.out.println(add);
        System.out.println(minus);
    }
}
