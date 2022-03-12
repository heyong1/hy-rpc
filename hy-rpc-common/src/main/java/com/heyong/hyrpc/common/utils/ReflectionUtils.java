package com.heyong.hyrpc.common.utils;

import lombok.SneakyThrows;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Description 反射工具类
 *
 * @Author heyong
 * @Date 2022/3/10 16:37
 */
public class ReflectionUtils {
    /**
     * 根据class创建对象
     *
     * @param clazz 待创建对象的类
     * @param <T>   对象类型
     * @return  创建好的对象
     */
    @SneakyThrows
    public static <T> T newInstance(Class<T> clazz){
        return clazz.newInstance();
    }

    /**
     * 获取某个class的公有方法
     * @param clazz
     * @return 当前类声明的公有方法
     */
    public static Method[] getPublicMethod(Class clazz){
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> lMethods = new ArrayList<>();
        for (Method m :
                methods) {
            if (Modifier.isPublic(m.getModifiers())){
                lMethods.add(m);
            }
        }
        return lMethods.toArray(new Method[0]);
    }

    /**
     * 调用指定对象的指定方法
     * @param obj 被调用方法的对象
     * @param method 被调用的方法
     * @param args 方法的参数
     * @return 返回结果
     */
    public static Object invoke(Object obj,
                                Method method,
                                Object... args){
        try {
            return method.invoke(obj,args);
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
