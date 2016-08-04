package com.alex.service.impl;

import com.alex.utils.Transformer;
import com.alex.dao.api.UserDao;
import com.alex.dao.impl.UserDaoImpl;
import com.alex.dto.UserDto;
import com.alex.entity.User;
import com.alex.service.api.UserService;

import java.util.List;

/**
 * Created by root on 16.06.2016.
 */

public class UserServiceImpl implements UserService {

    private UserServiceImpl() {
        userDao = UserDaoImpl.getInstance();

    }

    private static volatile UserService instance;
    private UserDao userDao;




    public static UserService getInstance() {
        if (instance == null)
            synchronized (UserServiceImpl.class) {
                if (instance == null)
                    instance = new UserServiceImpl();
            }
        return instance;
    }


    @Override
    public List<UserDto> getAllUsers() {

            List<User> users = userDao.findAll();
            List<UserDto> userDtos = Transformer.transformListUserToListUserDto(users);
            return userDtos;
    }

    @Override
    public UserDto getUserById(long id) {
        User user = userDao.findById(id);
        UserDto userDto = Transformer.transformUserToUserDto(user);
        return userDto;
    }

    @Override
    public void createUser(UserDto userDto) {
        User user = Transformer.transformUserDtoToUser(userDto);
        userDao.create(user);
    }

    @Override
    public boolean deleteUser(long id) {
        userDao.delete(id);
        return true;  //// TODO: 21.07.2016 in UserDao
    }

    @Override
    public boolean checkUserExists(String login, String password) {
        List<User> users = userDao.findAll();
        for (User user: users ) {
            if ((user.getLogin().equals(login)) && (user.getPassword().equals(password))) return true;
        }
        return false;
    }

    public boolean checkUserExists(String login) {
        List<User> users = userDao.findAll();
        for (User user: users ) {
            if (user.getLogin().equals(login)) return true;
        }
        return false;
    }
}
