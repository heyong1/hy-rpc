package com.heyong.hyrpc.codec;

/**
 * Description 序列化
 *
 * @Author heyong
 * @Date 2022/3/10 19:58
 */
public interface Encoder {
    byte[] encode(Object obj);

}
