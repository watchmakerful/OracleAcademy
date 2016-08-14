package com.alex.servlets;

import com.alex.holder.PropertyHolder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Алексей on 14.08.2016.
 */
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        PropertyHolder holder = PropertyHolder.getInstance();
        sce.getServletContext().setAttribute("URL",holder.getProperty("DatabaseURL"));




    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("Context is destroyed");
    }
}
