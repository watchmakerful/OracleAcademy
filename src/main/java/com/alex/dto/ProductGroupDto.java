package com.alex.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 07.07.2016.
 */
public class ProductGroupDto {
    private long id;
    private String name;
    private String description;
    private List<ProductDto> products = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
}
