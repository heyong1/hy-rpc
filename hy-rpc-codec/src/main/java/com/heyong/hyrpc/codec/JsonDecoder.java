package com.heyong.hyrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * Description
 *
 * @Author heyong
 * @Date 2022/3/10 20:10
 */
public class JsonDecoder implements Decoder{
    @Override
    public <T> T decode(byte[] bytes, Class<T> clazz) {
        return JSON.parseObject(bytes,clazz);
    }
}
