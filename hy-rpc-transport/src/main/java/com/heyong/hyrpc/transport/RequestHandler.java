package com.heyong.hyrpc.transport;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * Description 处理网络请求的handler
 *
 * @Author heyong
 * @Date 2022/3/10 20:36
 */
public interface RequestHandler {
    void onRequest(InputStream receive, OutputStream toResp);
}
