package com.heyong.hyrpc.transport;

import com.heyong.hyrpc.Peer;
import lombok.SneakyThrows;
import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.server.HttpConnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * Description
 *
 * @Author heyong
 * @Date 2022/3/10 20:39
 */
public class HttpTransportClient implements TransportClient{
    private String url;
    @Override
    public void connect(Peer peer) {
        this.url = "http://" + peer.getHost() + ":" + peer.getPort();
    }

    @Override
    public InputStream write(InputStream data) {
        try {
            HttpURLConnection httpConnection = (HttpURLConnection) new URL(url).openConnection();
            httpConnection.setDoInput(true);
            httpConnection.setDoOutput(true);
            httpConnection.setUseCaches(false);
            httpConnection.setRequestMethod("POST");

            httpConnection.connect();
            IOUtils.copy(data,httpConnection.getOutputStream());

            int responseCode = httpConnection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK){
                return httpConnection.getInputStream();
            }else {
                return httpConnection.getErrorStream();
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() {

    }
}
