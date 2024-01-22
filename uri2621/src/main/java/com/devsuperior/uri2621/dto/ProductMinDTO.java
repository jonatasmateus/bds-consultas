package com.devsuperior.uri2621.dto;

import com.devsuperior.uri2621.projection.ProductMinProjection;

public class ProductMinDTO {

    private String name;

    public ProductMinDTO(String name) {
        this.name = name;
    }

    public ProductMinDTO(ProductMinProjection projection) {
        name = projection.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}