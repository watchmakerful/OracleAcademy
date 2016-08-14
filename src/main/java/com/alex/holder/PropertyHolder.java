package com.alex.holder;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

/**
 * Created by root on 30.06.2016.
 */
public class PropertyHolder {

    private String file = "WEB-INF/resources/application.properties";
    private Properties properties = new Properties();

    private PropertyHolder() {
        try {
            properties.load(new FileReader(new File(file)));
        } catch (java.io.IOException e) {
            System.out.println("File read error!");
        }
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
