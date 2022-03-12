package com.heyong.hyrpc.server;

import com.heyong.hyrpc.Request;
import com.heyong.hyrpc.ServiceDescriptor;
import com.heyong.hyrpc.common.utils.ReflectionUtils;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Description 管理rpc暴露的服务
 *
 * @Author heyong
 * @Date 2022/3/11 14:30
 */
@Slf4j
public class ServiceManager {
    private Map<ServiceDescriptor, ServiceInstance> services;

    public ServiceManager(){
        this.services = new ConcurrentHashMap<>();
    }

    public <T> void register(Class<T> interfaceClass, T bean){
        Method[] methods = ReflectionUtils.getPublicMethod(interfaceClass);
        for (Method method :
                methods) {
            ServiceInstance serviceInstance = new ServiceInstance(bean,method);
            ServiceDescriptor serviceDescriptor = ServiceDescriptor.from(interfaceClass, method);

            services.put(serviceDescriptor,serviceInstance);
            log.info("register service: {} , {}", serviceDescriptor.getClazz(), serviceDescriptor.getMethod());
        }
    }

    public ServiceInstance lookup(Request request){
        ServiceDescriptor service = request.getService();
        return services.get(service);
    }
}
