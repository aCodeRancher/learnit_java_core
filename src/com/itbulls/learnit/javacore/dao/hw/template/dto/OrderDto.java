package com.itbulls.learnit.javacore.dao.hw.template.dto;
import java.util.List;

public class OrderDto {
    private int id;
    private String creditcard;
    private  int  product_id ;
    private int user_id;

    public int getProduct_id () {
        return product_id ;
    }

    public void setProduct_id ( int product_id) {
        this.product_id = product_id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(String creditcard) {
        this.creditcard = creditcard;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "OrderDto [id=" + id + ", creditcard=" + creditcard + "]";
    }

}
