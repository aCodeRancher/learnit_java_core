package com.itbulls.learnit.javacore.dao.hw.template.dto.converter;

import com.itbulls.learnit.javacore.dao.hw.template.dto.ProductDto;
import com.itbulls.learnit.javacore.dao.hw.template.dto.UserDto;
import com.itbulls.learnit.javacore.dao.hw.template.enteties.Product;
import com.itbulls.learnit.javacore.dao.hw.template.enteties.User;
import com.itbulls.learnit.javacore.dao.hw.template.enteties.impl.DefaultProduct;
import com.itbulls.learnit.javacore.dao.hw.template.enteties.impl.DefaultUser;

public class ProductConverter {
    private static ProductConverter instance;

    private ProductConverter() {};


    public static ProductConverter getInstance() {
        if (instance == null) {
            instance = new ProductConverter();
        }
        return instance;
    }

    public ProductDto productToProductDto(Product product){
         ProductDto productDto = new ProductDto();
         productDto.setProduct_id(product.getId());
         productDto.setProduct_name(product.getProductName());
         productDto.setCategory_name(product.getCategoryName());
         productDto.setProduct_price( product.getPrice());
        return productDto;
    }

    public Product productDtoToProduct(ProductDto productDto){
        int id = productDto.getProduct_id();
        String name = productDto.getProduct_name();
        String category = productDto.getCategory_name();
        double price = productDto.getProduct_price();
        Product product = new DefaultProduct(id ,name,category,price);
        return product;
    }
}
