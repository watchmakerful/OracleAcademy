package com.alex.service.api;

        import com.alex.dto.ProductDto;
        import com.alex.entity.Product;

/**
 * Created by root on 07.07.2016.
 */
public interface ProductService {

    ProductDto getProductById (long id);
    void createProduct (ProductDto productDto);
    boolean deleteProduct (long id);

}
