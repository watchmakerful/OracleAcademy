package com.alex.dao.impl;

import com.alex.dao.api.UserDao;
import com.alex.dbutil.DataSource;
import com.alex.entity.Product;
import com.alex.entity.Role;
import com.alex.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by root on 14.07.2016.
 */
public class UserDaoImpl implements UserDao {
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String DELETE_USER = "DELETE FROM users WHERE id = ?";
    private static final String CREATE_NEW_USER = "INSERT INTO users (id, name, name2, age, login, password, email, address, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";


    private UserDaoImpl() {
        dataSource = DataSource.getInstance();
    }


    private static volatile UserDao instance;

    private DataSource dataSource;


    public static UserDao getInstance() {
        if (instance == null)
            synchronized (UserDaoImpl.class) {
                if (instance == null)
                    instance = new UserDaoImpl();
            }
        return instance;
    }


    @Override
    public List<User> findAll() {
        Connection connection = dataSource.getConnection();
        List<User> users = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setSecondName(resultSet.getString("name2"));
                user.setAge(resultSet.getInt("age"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setAddress(resultSet.getString("address"));
                user.setRole(Role.valueOf(resultSet.getString("role")));

                users.add(user);
            }


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


        return users;
    }

    @Override
    public User findById(long id) {
        Connection connection = dataSource.getConnection();
        User user = new User();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_USER_BY_ID);
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {

                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setSecondName(resultSet.getString("name2"));
                user.setAge(resultSet.getInt("age"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setAddress(resultSet.getString("address"));
                user.setRole(Role.valueOf(resultSet.getString("role")));


            }


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


        return user;
    }

    @Override
    public void delete(long id) {
        Connection connection = dataSource.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_USER);
            ps.setLong(1, id);
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

    @Override
    public void create(User user) {
        Connection connection = dataSource.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(CREATE_NEW_USER);
            ps.setLong(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getSecondName());
            ps.setInt(4, user.getAge());
            ps.setString(5, user.getLogin());
            ps.setString(6, user.getPassword());
            ps.setString(7, user.getEmail());
            ps.setString(8, user.getAddress());
            ps.setString(9, user.getRole().toString());


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


}
