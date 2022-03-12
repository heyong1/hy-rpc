package com.heyong.hyrpc.server;

import com.heyong.hyrpc.codec.Decoder;
import com.heyong.hyrpc.codec.Encoder;
import com.heyong.hyrpc.codec.JsonDecoder;
import com.heyong.hyrpc.codec.JsonEncoder;
import com.heyong.hyrpc.transport.HttpTransportServer;
import com.heyong.hyrpc.transport.TransportServer;
import lombok.Data;

/**
 * Description server配置
 *
 * @Author heyong
 * @Date 2022/3/11 14:17
 */
@Data
public class RpcServerConfig {
    private Class<? extends TransportServer> transportClass = HttpTransportServer.class;
    private Class<? extends Encoder> encoderClass = JsonEncoder.class;
    private Class<? extends Decoder> decoderClass = JsonDecoder.class;
    private int port = 3000;
}
