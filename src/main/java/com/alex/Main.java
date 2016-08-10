package com.alex;

import com.alex.dao.api.ProductDao;
import com.alex.dao.api.UserDao;
import com.alex.dao.impl.ProductDaoImpl;
import com.alex.dao.impl.UserDaoImpl;
import com.alex.entity.Role;
import com.alex.entity.User;
import com.alex.service.api.UserService;
import com.alex.service.impl.UserServiceImpl;
import com.alex.utils.Transformer;

/**
 * Created by Алексей on 21.07.2016.
 */
public class Main {
    public static void main(String[] args) {
        UserDao userDao = UserDaoImpl.getInstance();
        ProductDao productDao = ProductDaoImpl.getInstance();

        User user1 = new User();
        user1.setId(1);
        user1.setName("Alex1");
        user1.setAge(30);
        user1.setRole(Role.ADMIN);

        userDao.create(user1);

        System.out.println(userDao.findById(1));
        UserService userService = UserServiceImpl.getInstance();
        System.out.println(Transformer.transformListUserDtoToListUser(userService.getAllUsers()));

        System.out.println(productDao.findAll());
        userDao.removeProductFromCart(6,1);
        System.out.println(userDao.getCart(6));
    }
}
