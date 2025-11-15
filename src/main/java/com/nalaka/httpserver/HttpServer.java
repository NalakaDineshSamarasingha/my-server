package com.nalaka.httpserver;

import com.nalaka.httpserver.config.Configuration;
import com.nalaka.httpserver.config.ConfigurationManager;

public class HttpServer {
    public static void main(String[] args) {
        ConfigurationManager.getInstance().loadConfigurationFile("src/main/resources/http.json");
        Configuration conf =  ConfigurationManager.getInstance().getCurrentConfiguration();
        System.out.println(conf.getPort());
    }
}
