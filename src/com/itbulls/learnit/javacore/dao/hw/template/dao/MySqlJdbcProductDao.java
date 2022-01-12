package com.itbulls.learnit.javacore.dao.hw.template.dao;

import com.itbulls.learnit.javacore.dao.hw.template.dto.ProductDto;

import com.itbulls.learnit.javacore.jdbc.DBUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlJdbcProductDao implements ProductDao {
    private static MySqlJdbcProductDao  instance;


    private MySqlJdbcProductDao() {}

    public static MySqlJdbcProductDao getInstance(){
        if (instance == null) {
            instance = new MySqlJdbcProductDao();
        }
        return instance;
    }

    @Override
    public ProductDto getProductById(int id) {
        try (var conn = DBUtils.getConnection();
             var ps = conn.prepareStatement("SELECT * FROM product WHERE id = ?")) {
             ps.setInt(1, id);
            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    ProductDto productDto = new ProductDto();
                    productDto.setProduct_id(rs.getInt("product_id"));
                    productDto.setProduct_name(rs.getString("product_name"));
                    productDto.setCategory_name(rs.getString("category_name"));
                    productDto.setProduct_price(rs.getBigDecimal("product_price").doubleValue());
                    return productDto;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ProductDto> getProducts() {
        List<ProductDto> productDtos = new ArrayList<>();
        try (var conn = DBUtils.getConnection();
             var ps = conn.prepareStatement("SELECT * FROM product")) {

            try (var rs = ps.executeQuery()) {
                while (rs.next()) {
                    ProductDto productDto = new ProductDto();
                    productDto.setProduct_id(rs.getInt("product_id"));
                    productDto.setProduct_name(rs.getString("product_name"));
                    productDto.setCategory_name(rs.getString("category_name"));
                    productDto.setProduct_price(rs.getBigDecimal("product_price").doubleValue());
                    productDtos.add(productDto);
              }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productDtos;
    }

}
