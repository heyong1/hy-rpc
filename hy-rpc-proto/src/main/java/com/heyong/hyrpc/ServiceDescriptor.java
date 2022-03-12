package com.heyong.hyrpc;

import lombok.*;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * Description 表示服务
 *
 * @Author heyong
 * @Date 2022/3/10 16:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDescriptor {
    private String clazz;
    private String method;
    private String returnType;
    private String[] parameterTypes;

    public static ServiceDescriptor from(Class clazz, Method method){
        ServiceDescriptor descriptor = new ServiceDescriptor();
        descriptor.setClazz(clazz.getName());
        descriptor.setMethod(method.getName());
        descriptor.setReturnType(method.getReturnType().getName());

        Class<?>[] types = method.getParameterTypes();
        String[] parameterTypes = new String[types.length];
        for (int i = 0; i < parameterTypes.length; i++) {
            parameterTypes[i] = types[i].getName();
        }
        descriptor.setParameterTypes(parameterTypes);

        return descriptor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceDescriptor that = (ServiceDescriptor) o;
        return Objects.equals(clazz, that.clazz) && Objects.equals(method, that.method) && Objects.equals(returnType, that.returnType) && Arrays.equals(parameterTypes, that.parameterTypes);
    }

    @Override
    public int hashCode() {
        return toString().hashCode();
    }

    @Override
    public String toString() {
        return "ServiceDescriptor{" +
                "clazz='" + clazz + '\'' +
                ", method='" + method + '\'' +
                ", returnType='" + returnType + '\'' +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                '}';
    }
}
