package com.heyong.hyrpc.common.utils;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Description
 *
 * @Author heyong
 * @Date 2022/3/10 19:12
 */
public class ReflectionUtilsTest {

    @Test
    public void newInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        TestClass testClass = ReflectionUtils.newInstance(TestClass.class);
//        Object newInstance = Class.forName("com.heyong.hyrpc.common.utils.TestClass").newInstance();
//        assertNotNull(newInstance);
        assertNotNull(testClass);
    }

    @Test
    public void getPublicMethod() {
        Method[] publicMethod = ReflectionUtils.getPublicMethod(TestClass.class);
        assertEquals(1,publicMethod.length);
        String name = publicMethod[0].getName();
        assertEquals("b",name);
    }

    @Test
    public void invoke() {
        Method[] publicMethod = ReflectionUtils.getPublicMethod(TestClass.class);
        Method b = publicMethod[0];
        TestClass testClass = new TestClass();
        Object invoke = ReflectionUtils.invoke(testClass, b);
        assertEquals(b,invoke);
    }
}