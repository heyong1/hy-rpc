package com.heyong.hyrpc.transport;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Description Jetty嵌入
 *
 * @Author heyong
 * @Date 2022/3/10 22:52
 */
@Slf4j
public class HttpTransportServer implements TransportServer{
    private RequestHandler handler;
    private Server server;

    @Override
    public void init(int port, RequestHandler handler) {
        this.handler = handler;
        this.server = new Server(port);

        //servlet接受请求
        ServletContextHandler contextHandler = new ServletContextHandler();
        server.setHandler(contextHandler);

        ServletHolder holder = new ServletHolder(new RequestServlet());
        contextHandler.addServlet(holder,"/*");
    }

    @Override
    public void start() {
        try {
            server.start();
            server.join();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    @Override
    public void stop() {
        try {
            server.stop();
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }

    class RequestServlet extends HttpServlet{
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            log.info("client connect");

            InputStream inputStream = req.getInputStream();
            OutputStream outputStream = resp.getOutputStream();

            if (handler != null){
                handler.onRequest(inputStream,outputStream);
            }

            outputStream.flush();
        }
    }
}
