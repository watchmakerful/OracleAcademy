package com.alex.dbutil;

import com.alex.service.api.UserService;
import com.alex.service.impl.UserServiceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Алексей on 14.08.2016.
 */
public class DatabaseCreator {
    public DatabaseCreator() {
        dataSource = DataSource.getInstance();
    }

    private static volatile DatabaseCreator instance;

    public static DatabaseCreator getInstance() {
        if (instance == null)
            synchronized (DatabaseCreator.class) {
                if (instance == null)
                    instance = new DatabaseCreator();
            }
        return instance;
    }

    private DataSource dataSource;
    private static final String CREATE_USERS_TABLE = "CREATE TABLE IF NOT EXISTS `users` (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `name` varchar(256) DEFAULT NULL,\n" +
            "  `name2` varchar(256) DEFAULT NULL,\n" +
            "  `age` int(11) DEFAULT NULL,\n" +
            "  `login` varchar(256) DEFAULT NULL,\n" +
            "  `password` varchar(256) DEFAULT NULL,\n" +
            "  `email` varchar(256) DEFAULT NULL,\n" +
            "  `address` varchar(256) DEFAULT NULL,\n" +
            "  `role` varchar(5) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;\n";

    private static final String CREATE_PRODUCTS_TABLE = "CREATE TABLE IF NOT EXISTS `products` (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT,\n" +
            "  `name` varchar(256) DEFAULT NULL,\n" +
            "  `description` varchar(256) DEFAULT NULL,\n" +
            "  `count` int(11) DEFAULT NULL,\n" +
            "  `price` double DEFAULT NULL,\n" +
            "  `made` varchar(256) DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;\n";

    private static final String CREATE_ADMIN_USER = "INSERT INTO users (name, login, password, age, role) VALUES ('admin', 'admin', 'admin', 20, 'ADMIN') ";


    private void executeStatement(String statement) {

        Connection connection = dataSource.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(statement);
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void createUsersTable() {
        executeStatement(CREATE_USERS_TABLE);
        UserService userService = UserServiceImpl.getInstance();
        if (userService.checkUserExists("admin") == -1)

            executeStatement(CREATE_ADMIN_USER);
    }

    public void createProductsTable() {
        executeStatement(CREATE_PRODUCTS_TABLE);
    }

}

