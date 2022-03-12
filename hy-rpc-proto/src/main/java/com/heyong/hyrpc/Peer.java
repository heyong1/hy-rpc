package com.heyong.hyrpc;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Description 表示网络传输的一个端点
 *
 * @Author heyong
 * @Date 2022/3/10 16:23
 */
@Data
@AllArgsConstructor
public class Peer {
    private String host;
    private int port;
}
