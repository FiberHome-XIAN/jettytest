package com.fiberhome.jetty.test;

public class StartServer {

    public static void main(String[] args) {

        String basePath = System.getProperty("base.path");



        new FiberhomeJettyServer(basePath,basePath+"/jetty/jetty.xml","/").startServer();
    }
}
