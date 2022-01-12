package com.itbulls.learnit.javacore.dao.hw.template.dto;


public class ProductDto {
    private int product_id;
    private String product_name;
    private String category_name;

    private double product_price;

    public ProductDto() {
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    @Override
    public String toString() {
        return "ProductDto [id=" + product_id + ", name=" + product_name + ", category=" + category_name + ", price=" + product_price
                  + "]";
    }
}
