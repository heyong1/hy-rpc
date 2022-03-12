package com.heyong.hyrpc.codec;

import com.alibaba.fastjson.JSON;

/**
 * Description 基于json的序列化实现
 *
 * @Author heyong
 * @Date 2022/3/10 20:08
 */
public class JsonEncoder implements Encoder {
    @Override
    public byte[] encode(Object obj) {
        return JSON.toJSONBytes(obj);
    }
}
