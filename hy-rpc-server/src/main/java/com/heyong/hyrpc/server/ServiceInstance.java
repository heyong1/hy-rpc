package com.heyong.hyrpc.server;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.Method;

/**
 * Description 表示一个具体服务
 *
 * @Author heyong
 * @Date 2022/3/11 14:28
 */
@Data
@AllArgsConstructor
public class ServiceInstance {
    private Object target;
    private Method method;
}
