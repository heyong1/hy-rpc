package com.heyong.hyrpc.codec;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Description
 *
 * @Author heyong
 * @Date 2022/3/10 20:13
 */
public class JsonDecoderTest {

    @Test
    public void decode() {
        TestBean testBean = new TestBean();
        JsonEncoder jsonEncoder = new JsonEncoder();
        testBean.setAge(11);
        testBean.setName("llll");
        byte[] bytes = jsonEncoder.encode(testBean);

        JsonDecoder decoder = new JsonDecoder();
        TestBean bean = decoder.decode(bytes, TestBean.class);
        assertEquals(testBean.getName(),bean.getName());
        assertEquals(testBean.getAge(), bean.getAge());
    }
}