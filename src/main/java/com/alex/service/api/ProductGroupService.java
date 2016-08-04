package com.alex.service.api;

import com.alex.dto.ProductGroupDto;

/**
 * Created by Алексей on 14.07.2016.
 */
public interface ProductGroupService {

    ProductGroupDto getProductGroupById (long id);
    void createProductGroup (ProductGroupDto ProductGroupDto);
    boolean deleteProductGroup (long id);
}
