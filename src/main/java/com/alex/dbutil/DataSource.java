package com.alex.dbutil;

import com.alex.holders.PropertyHolder;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

/**
 * Created by root on 14.07.2016.
 */
public class DataSource {
    private static DataSource dataSource;

    private DataSource() {
    }

    public static DataSource getInstance() {
        if (dataSource == null) {
            synchronized (DataSource.class) {
                if (dataSource == null) {
                    dataSource = new DataSource();
                }
            }
        }
        return dataSource;
    }

    public Connection getConnection() {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        Connection conn = null;
        try {
            //todo application.properties
            PropertyHolder holder = PropertyHolder.getInstance();

            cpds.setDriverClass(holder.getProperty("DatabaseDriver")); //loads the jdbc driver
            cpds.setJdbcUrl(holder.getProperty("DatabaseURL"));
            cpds.setUser(holder.getProperty("DatabaseUser"));
            cpds.setPassword(holder.getProperty("DatabasePassword"));

            cpds.setMinPoolSize(5);
            cpds.setAcquireIncrement(10);
            cpds.setMaxPoolSize(200);

            conn = cpds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }
    
}
