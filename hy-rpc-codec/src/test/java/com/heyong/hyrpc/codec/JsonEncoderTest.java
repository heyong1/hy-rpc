package com.heyong.hyrpc.codec;

import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description
 *
 * @Author heyong
 * @Date 2022/3/10 20:12
 */
public class JsonEncoderTest {

    @Test
    public void encode() {
        TestBean testBean = new TestBean();
        JsonEncoder jsonEncoder = new JsonEncoder();
        testBean.setAge(11);
        testBean.setName("llll");
        byte[] bytes = jsonEncoder.encode(testBean);
        assertNotNull(bytes);
    }
}