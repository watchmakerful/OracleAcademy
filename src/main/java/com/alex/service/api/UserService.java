package com.alex.service.api;

import com.alex.dto.UserDto;

import java.util.List;

/**
 * Created by root on 16.06.2016.
 */
public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById (long id);
    void createUser (UserDto userDto);
    boolean deleteUser (long id);
    boolean checkUserExists (String username, String password);
    boolean checkUserExists (String username);
}
