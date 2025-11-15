package com.nalaka.httpserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Stream;

import com.nalaka.httpserver.config.Configuration;
import com.nalaka.httpserver.config.ConfigurationManager;

public class HttpServer {

    public static void main(String[] args) {
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
        System.out.println(conf.getPort());

        try {
            ServerSocket serverSocket = new ServerSocket(conf.getPort());
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            String html = "<html><head></head><body>Hello world</body></html>";

            final String CRLF = "\n\r";

            String response
                    = "HTTP/1.1 200 OK" + CRLF
                    + "Content-Length" + html.getBytes().length + CRLF
                    + CRLF
                    + html
                    + CRLF + CRLF;

            outputStream.write(response.getBytes());

            inputStream.close();
            outputStream.close();
            socket.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
