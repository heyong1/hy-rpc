package com.heyong.hyrpc.server;

import com.heyong.hyrpc.Request;
import com.heyong.hyrpc.ServiceDescriptor;
import com.heyong.hyrpc.common.utils.ReflectionUtils;
import com.sun.org.apache.xml.internal.security.Init;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

/**
 * Description
 *
 * @Author heyong
 * @Date 2022/3/11 15:29
 */
public class ServiceManagerTest {
    ServiceManager sm;

    @Before
    public void init(){
        sm = new ServiceManager();

        TestInterface bean = new TestClass();
        sm.register(TestInterface.class,bean);
    }

    @Test
    public void register() {
        TestInterface bean = new TestClass();
        sm.register(TestInterface.class,bean);
    }

    @Test
    public void lookup() {
        Method method = ReflectionUtils.getPublicMethod(TestInterface.class)[0];
        ServiceDescriptor descriptor = ServiceDescriptor.from(TestInterface.class, method);

        Request request = new Request();
        request.setService(descriptor);

        ServiceInstance lookup = sm.lookup(request);
        assertNotNull(lookup);
    }


}