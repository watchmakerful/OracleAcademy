package com.alex.dao.api;

import com.alex.entity.Product;
import com.alex.entity.User;

import java.util.List;

/**
 * Created by root on 14.07.2016.
 */
public interface UserDao {
    List<User> findAll();
    User findById (long id);
    void delete (long id);
    void create (User user);
    List<Product> getCart (long id); //?
    void addProductToCart (long userId, long productId);
    void removeProductFromCart (long userId, long productId);

}
