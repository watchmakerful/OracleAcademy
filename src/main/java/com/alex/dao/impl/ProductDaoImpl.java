package com.alex.dao.impl;

import com.alex.dao.api.ProductDao;
import com.alex.dbutil.DataSource;
import com.alex.entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Алексей on 24.07.2016.
 */
public class ProductDaoImpl implements ProductDao {

    private static final String SELECT_ALL_PRODUCTS = "select * from products";
    private static final String SELECT_PRODUCT_BY_ID = "select * from products where id = ?";
    private static final String DELETE_PRODUCT = "delete from products where id = ?";
    private static final String CREATE_NEW_PRODUCT = "insert into products (id, name, description, count, price, made) values (?, ?, ?, ?, ?, ?)";






    private ProductDaoImpl() {
        dataSource = DataSource.getInstance();
    }


    private static volatile ProductDao instance;

    private DataSource dataSource;


    public static ProductDao getInstance() {
        if (instance == null)
            synchronized (UserDaoImpl.class) {
                if (instance == null)
                    instance = new ProductDaoImpl();
            }
        return instance;
    }



    @Override
    public List<Product> findAll() {
        Connection connection = dataSource.getConnection();
        List<Product> products = new LinkedList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_PRODUCTS);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setCount(resultSet.getInt("count"));
                product.setDescription(resultSet.getString("description"));
                product.setMade(resultSet.getString("made"));
                product.setPrice(resultSet.getDouble("price"));
                products.add(product);
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

        return products;
    }

    @Override
    public Product findById(long id) {
        Connection connection = dataSource.getConnection();
        Product product = new Product();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_PRODUCT_BY_ID);
            ps.setLong(1, id);
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {

                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setCount(resultSet.getInt("count"));
                product.setDescription(resultSet.getString("description"));
                product.setMade(resultSet.getString("made"));
                product.setPrice(resultSet.getDouble("price"));


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


        return product;
    }

    @Override
    public void delete(long id) {
        Connection connection = dataSource.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_PRODUCT);
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
    public void create(Product product) {
        Connection connection = dataSource.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(CREATE_NEW_PRODUCT);
            ps.setLong(1,product.getId());
            ps.setString(2,product.getName());
            ps.setString(3,product.getDescription());
            ps.setInt(4,product.getCount());
            ps.setDouble(5,product.getPrice());
            ps.setString(6,product.getMade());


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
