package com.alex.holders;

import com.alex.servlets.ContextListener;

import java.util.Properties;

/**
 * Created by root on 30.06.2016.
 */
public class PropertyHolder {

    private String file = "/WEB-INF/resources/application.properties";
    private Properties properties = new Properties();

    private PropertyHolder() {
        properties = ContextListener.getProperties();
    }




    private static volatile PropertyHolder instance;



    public static PropertyHolder getInstance() {
        if (instance == null)
            synchronized (PropertyHolder.class) {
                if (instance == null)
                    instance = new PropertyHolder();
            }
        return instance;
    }



    public String getProperty(String key) {
        return properties.getProperty(key, "No such key");
    }


}
