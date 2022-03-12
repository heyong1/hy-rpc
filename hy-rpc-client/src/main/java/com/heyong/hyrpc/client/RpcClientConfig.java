package com.heyong.hyrpc.client;

import com.heyong.hyrpc.Peer;
import com.heyong.hyrpc.codec.Decoder;
import com.heyong.hyrpc.codec.Encoder;
import com.heyong.hyrpc.codec.JsonDecoder;
import com.heyong.hyrpc.codec.JsonEncoder;
import com.heyong.hyrpc.transport.HttpTransportClient;
import com.heyong.hyrpc.transport.TransportClient;
import lombok.Data;

import java.util.Arrays;
import java.util.List;

/**
 * Description
 *
 * @Author heyong
 * @Date 2022/3/11 20:14
 */
@Data
public class RpcClientConfig {
    private Class<? extends TransportClient> transportClass = HttpTransportClient.class;
    private Class<? extends Encoder> encoderClass = JsonEncoder.class;
    private Class<? extends Decoder> decoderClass = JsonDecoder.class;
    private Class<? extends RandomTransportSelector> selectorClass = RandomTransportSelector.class;
    private int connectCount = 1;
    private List<Peer> servers = Arrays.asList(new Peer("127.0.0.1", 3000));
}
