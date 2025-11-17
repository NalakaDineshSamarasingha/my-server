package com.nalaka.httpserver;

import com.nalaka.httpserver.config.Configuration;
import com.nalaka.httpserver.config.ConfigurationManager;
import com.nalaka.httpserver.core.ServerListenerThread;
import com.nalaka.httpserver.core.io.WebRootNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 *
 * Driver Class for the Http Server
 *
 */
public class HttpServer {

    private final static Logger LOGGER = LoggerFactory.getLogger(HttpServer.class);

    public static void main(String[] args) {



        LOGGER.info("Server starting...");

        ConfigurationManager.getInstance().loadConfigurationFile("E:\\Code\\http-server\\src\\main\\resources\\http.json");
        Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

        LOGGER.info("Using Port: " + conf.getPort());
        LOGGER.info("Using WebRoot: " + conf.getWebroot());

        try {
            ServerListenerThread serverListenerThread = new ServerListenerThread(conf.getPort(), conf.getWebroot());
            serverListenerThread.start();
        } catch (IOException e) {
            e.printStackTrace();
            // TODO handle later.
        } catch (WebRootNotFoundException e) {
            LOGGER.error("Webroot folder not found",e);
        }


    }

}