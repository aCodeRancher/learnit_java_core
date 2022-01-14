package com.itbulls.learnit.javacore.dao.hw.template.dao;

import com.itbulls.learnit.javacore.dao.hw.template.dto.OrderDto;
import com.itbulls.learnit.javacore.jdbc.DBUtils;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlJdbcOrderDao implements OrderDao {
    private static MySqlJdbcOrderDao  instance;

    private MySqlJdbcOrderDao() {}

    public static MySqlJdbcOrderDao getInstance(){
        if (instance == null) {
            instance = new MySqlJdbcOrderDao();
        }
        return instance;
    }

    @Override
    public List<OrderDto> getOrdersByUserId(int id) {
        List<OrderDto> orders = new ArrayList<>();
        try (var conn = DBUtils.getConnection();
             var ps = conn.prepareStatement("SELECT * FROM learn_it_db.order WHERE fk_user_id = ?")) {
            ps.setInt(1, id);

            try (var rs = ps.executeQuery()) {
                while (rs.next()) {
                    OrderDto orderDto = new OrderDto();
                    orderDto.setId(rs.getInt("order_id"));
                    orderDto.setUser_id(rs.getInt("fk_user_id"));
                    orderDto.setProduct_id(rs.getInt("fk_product_id"));
                    orderDto.setCreditcard(rs.getString("creditcard"));
                    orders.add(orderDto);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<OrderDto> getOrders() {
        List<OrderDto> orders = new ArrayList<>();
        try (var conn = DBUtils.getConnection();
             var ps = conn.prepareStatement("SELECT * FROM learn_it_db.order")) {
            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    OrderDto orderDto = new OrderDto();
                    orderDto.setId(rs.getInt("order_id"));
                    orderDto.setUser_id(rs.getInt("fk_user_id"));
                    orderDto.setProduct_id(rs.getInt("fk_product_id"));
                    orderDto.setCreditcard(rs.getString("creditcard"));
                    orders.add(orderDto);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orders;
    }
    @Override
    public void saveOrder(OrderDto orderDto) {
        try (var conn = DBUtils.getConnection();
             var ps = conn.prepareStatement("INSERT INTO learn_it_db.order (creditcard, fk_product_id, fk_user_id) " +
                     "VALUES (?, ?, ?);")) {
            ps.setString(1, orderDto.getCreditcard());
            ps.setInt(2, orderDto.getProduct_id());
            ps.setInt(3, orderDto.getUser_id());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
