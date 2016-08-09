package com.alex.service.impl;

import com.alex.dao.api.ProductDao;
import com.alex.dao.impl.ProductDaoImpl;
import com.alex.dto.ProductDto;
import com.alex.dto.UserDto;
import com.alex.entity.Product;
import com.alex.service.api.ProductService;
import com.alex.utils.Transformer;

import java.util.List;

/**
 * Created by Алексей on 14.07.2016.
 */
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;

    private ProductServiceImpl() {
        productDao = ProductDaoImpl.getInstance();
    }

    private static volatile ProductService instance;


    public static ProductService getInstance() {
        if (instance == null)
            synchronized (ProductServiceImpl.class) {
                if (instance == null)
                    instance = new ProductServiceImpl();
            }
        return instance;
    }

    @Override
    public List<ProductDto> getAllProducts() {

        List<Product> products = productDao.findAll();
        List<ProductDto> productDtos = Transformer.transformListProductToListProductDto(products);
        return productDtos;
    }


    @Override
    public ProductDto getProductById(long id) {
        ProductDto productDto = Transformer.transformProductToProductDto(productDao.findById(id));
        return productDto;
    }

    @Override
    public void createProduct(ProductDto productDto) {
        Product product = Transformer.transformProductDtoToProduct(productDto);
        productDao.create(product);
    }

    @Override
    public boolean deleteProduct(long id) {
        productDao.delete(id);
        return true;
    }
}


