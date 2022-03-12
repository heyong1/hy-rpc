package com.heyong.hyrpc;

import lombok.Data;

/**
 * Description 表示rpc的一个请求
 *
 * @Author heyong
 * @Date 2022/3/10 16:29
 */
@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] parameters;
}
