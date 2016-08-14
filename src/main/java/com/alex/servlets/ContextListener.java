package com.alex.servlets;

import com.alex.holder.PropertyHolder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Алексей on 14.08.2016.
 */
public class ContextListener implements ServletContextListener {
    private static Properties properties = new Properties();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        InputStream is = sce.getServletContext().getResourceAsStream("/WEB-INF/resources/application.properties");
        try {
            properties.load(is);
            System.out.println(properties.getProperty("DatabaseURL"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context is destroyed");
    }

    public static Properties getProperties() {
        return properties;
    }




}
