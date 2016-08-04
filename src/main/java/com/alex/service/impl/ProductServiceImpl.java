package com.alex.service.impl;

import com.alex.dto.ProductDto;
import com.alex.service.api.ProductService;

/**
 * Created by Алексей on 14.07.2016.
 */
public class ProductServiceImpl implements ProductService {


        private ProductServiceImpl() {}

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
        public ProductDto getProductById(long id) {
            ProductDto ProductDto = new ProductDto();
            ProductDto.setId(id);
            return ProductDto;
        }

        @Override
        public void createProduct(ProductDto ProductDto) {
            //// TODO: 16.06.2016 add implementation
        }

        @Override
        public boolean deleteProduct(long id) {
            //// TODO: 16.06.2016 add implementation
            return true;
        }
    }


