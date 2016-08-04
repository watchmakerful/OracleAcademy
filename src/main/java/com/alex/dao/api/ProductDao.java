package com.alex.dao.api;

import com.alex.entity.Product;
import com.alex.entity.User;

import java.util.List;

/**
 * Created by root on 14.07.2016.
 */
public interface ProductDao {
    List<Product> findAll();
    Product findById(long id);
    void delete(long id);
    void create(Product product);


}
