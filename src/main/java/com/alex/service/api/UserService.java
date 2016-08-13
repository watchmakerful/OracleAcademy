package com.alex.service.api;

import com.alex.dto.ProductDto;
import com.alex.dto.UserDto;

import java.util.List;

/**
 * Created by root on 16.06.2016.
 */
public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getUserById (long id);
    void createUser (UserDto userDto);
    void deleteUser (long id);
    long checkUserExists (String username, String password);
    long checkUserExists (String username);
    List<ProductDto> getCartById (long id);
    void addProductToCart (long userId, long productId);
    void removeProductFromCart (long userId, long productId);

}
