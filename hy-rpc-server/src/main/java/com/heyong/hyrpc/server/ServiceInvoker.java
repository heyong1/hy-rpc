package com.heyong.hyrpc.server;

import com.heyong.hyrpc.Request;
import com.heyong.hyrpc.common.utils.ReflectionUtils;

/**
 * Description 调用具体服务
 *
 * @Author heyong
 * @Date 2022/3/11 15:52
 */
public class ServiceInvoker {
    public Object invoke(ServiceInstance serviceInstance, Request request){
        return ReflectionUtils.invoke(serviceInstance.getTarget(), serviceInstance.getMethod(), request.getParameters());
    }
}
