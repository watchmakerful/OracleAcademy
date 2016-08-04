package com.alex.utils;

import com.alex.dto.ProductDto;
import com.alex.dto.UserDto;
import com.alex.entity.Product;
import com.alex.entity.User;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by root on 14.07.2016.
 */
public class Transformer {
    public static UserDto transformUserToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setAge(user.getAge());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword()); //// TODO: 24.07.2016 remove?
        userDto.setEmail(user.getEmail());
        userDto.setSecondName(user.getSecondName());
        userDto.setRole(user.getRole());
        userDto.setAddress(user.getAddress());


        return userDto;
    }

    public static List<UserDto> transformListUserToListUserDto (List<User> users){
        List<UserDto> userDtos = new LinkedList<>();

        for (User user : users) {
            UserDto userDto = transformUserToUserDto(user);
            userDtos.add(userDto);
        }
        return userDtos;
    }

    public static User transformUserDtoToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setSecondName(userDto.getSecondName());
        user.setEmail(userDto.getEmail());
        user.setRole(userDto.getRole());
        user.setAddress(userDto.getAddress());

        return user;
    }
    public static List<User> transformListUserDtoToListUser (List<UserDto> userDtos){
        List<User> users = new LinkedList<>();

        for (UserDto userDto : userDtos) {
            User user = transformUserDtoToUser(userDto);
            users.add(user);
        }
        return users;
    }

    public static ProductDto transformProductToProductDto (Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setCount(product.getCount());
        productDto.setMade(product.getMade());
        return productDto;
    }

    public static Product transformProductDtoToProduct (ProductDto productDto){
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setCount(productDto.getCount());
        product.setMade(productDto.getMade());
        return product;
    }

    public static List<Product> transformListProductDtoToListProduct (List<ProductDto> productDtos) {
        List<Product> products = new LinkedList<>();

        for (ProductDto ProductDto : productDtos) {
            Product product = transformProductDtoToProduct(ProductDto);
            products.add(product);
        }
        return products;
    }

    public static List<ProductDto> transformListProductToListProductDto (List<Product> products) {
        List<ProductDto> productDtos = new LinkedList<>();

        for (Product product : products) {
            ProductDto productDto = transformProductToProductDto(product);
            productDtos.add(productDto);
        }
        return productDtos;
    }
}
