package com.alex.service.api;

        import com.alex.dto.ProductDto;
        import com.alex.entity.Product;

        import java.util.List;

/**
 * Created by root on 07.07.2016.
 */
public interface ProductService {

    List<ProductDto> getAllProducts();
    ProductDto getProductById (long id);
    void createProduct (ProductDto productDto);
    boolean deleteProduct (long id);

}
