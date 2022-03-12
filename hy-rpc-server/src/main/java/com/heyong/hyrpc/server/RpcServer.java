package com.heyong.hyrpc.server;

import com.heyong.hyrpc.Request;
import com.heyong.hyrpc.Response;
import com.heyong.hyrpc.codec.Decoder;
import com.heyong.hyrpc.codec.Encoder;
import com.heyong.hyrpc.common.utils.ReflectionUtils;
import com.heyong.hyrpc.transport.RequestHandler;
import com.heyong.hyrpc.transport.TransportServer;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Description
 *
 * @Author heyong
 * @Date 2022/3/11 16:21
 */
@Slf4j
public class RpcServer {
    private RpcServerConfig config;
    private TransportServer net;
    private Encoder encoder;
    private Decoder decoder;
    private ServiceManager serviceManager;
    private ServiceInvoker serviceInvoker;

        public RpcServer(RpcServerConfig config) {
        this.config = config;

        //net
        this.net = ReflectionUtils.newInstance(config.getTransportClass());
        this.net.init(config.getPort(), this.handler);
        //codec
        this.encoder = ReflectionUtils.newInstance(config.getEncoderClass());
        this.decoder = ReflectionUtils.newInstance(config.getDecoderClass());
        //service
        this.serviceManager = new ServiceManager();
        this.serviceInvoker = new ServiceInvoker();
    }

    public <T> void register(Class<T> interfaceClass, T bean){
        serviceManager.register(interfaceClass,bean);
    }

    public void start() {
        this.net.start();
    }

    public void stop() {
        this.net.stop();
    }

    private RequestHandler handler = new RequestHandler() {
        @Override
        public void onRequest(InputStream receive, OutputStream toResp) {
            Response response = new Response();

            try {
                byte[] inBytes = IOUtils.readFully(receive, receive.available());
                Request request = decoder.decode(inBytes, Request.class);
                log.info("get request:{}", request);

                ServiceInstance instance = serviceManager.lookup(request);
                Object invoke = serviceInvoker.invoke(instance, request);
                response.setData(invoke);
            } catch (Exception e) {
                log.warn(e.getMessage(), e);
                response.setCode(1);
                response.setMessage("RpcServer got error: " + e.getClass().getName() + " : " + e.getMessage());
            }finally {
                try {
                    byte[] outBytes = encoder.encode(response);
                    toResp.write(outBytes);

                    log.info("response client");
                } catch (IOException e) {
                    log.warn(e.getMessage(), e);
                }
            }
        }
    };
}
