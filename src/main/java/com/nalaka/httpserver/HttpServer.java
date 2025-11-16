package com.nalaka.httpserver;

import java.io.IOException;

import org.slf4j.LoggerFactory;

import com.nalaka.httpserver.config.Configuration;
import com.nalaka.httpserver.config.ConfigurationManager;
import com.nalaka.httpserver.core.ServerListenerThread;

public class HttpServer {

    public final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);

    public static void main(String[] args) {
        LOGGER.info("Server starting....");
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();
        System.out.println(conf.getPort());

        try { 
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(),conf.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }
}
