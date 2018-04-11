package com.fiberhome.jetty.test;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.xml.XmlConfiguration;

import java.io.FileInputStream;

public class FiberhomeJettyServer extends Server {

    private String basePath;


    public FiberhomeJettyServer(final String basePath, final String jettyXml, final String contextPath){

        this.basePath = basePath;
        try {
            XmlConfiguration configuration = new XmlConfiguration(new FileInputStream(jettyXml));
            configuration.configure(this);
        } catch (Exception e) {
            e.printStackTrace();
        }

//        ContextHandler contextHandler = new ContextHandler("/");

        ContextHandlerCollection contextHandlerCollection = new ContextHandlerCollection();
        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath(contextPath);
        webAppContext.setDefaultsDescriptor(basePath+"/jetty/webdefault.xml");
        webAppContext.setResourceBase(basePath);
        webAppContext.setDescriptor(basePath+"/web.xml");
        contextHandlerCollection.addHandler(webAppContext);

//        contextHandler.setHandler(webAppContext);
        super.setHandler(webAppContext);

    }


    public void startServer(){
        try {
            super.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
