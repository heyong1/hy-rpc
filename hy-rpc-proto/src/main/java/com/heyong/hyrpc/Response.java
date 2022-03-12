package com.heyong.hyrpc;

import lombok.Data;

/**
 * Description 表示rpc的返回
 *
 * @Author heyong
 * @Date 2022/3/10 16:32
 */
@Data
public class Response {
    /**
     * 服务返回编码：0-成功，非0失败
     */
    private int code = 0;
    /**
     * 具体的错误信息
     */
    private String message = "ok";
    /**
     *  返回的数据
     */
    private Object data;
}
