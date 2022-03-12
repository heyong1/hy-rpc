package com.heyong.hyrpc.codec;

/**
 * Description 反序列化
 *
 * @Author heyong
 * @Date 2022/3/10 20:00
 */
public interface Decoder {
    <T> T decode(byte[] bytes,Class<T> clazz);
}
