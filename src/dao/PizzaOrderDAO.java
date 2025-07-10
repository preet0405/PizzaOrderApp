package dao;

import java.sql.*;
import java.util.*;
import model.PizzaOrder;
import util.DBUtil;

public class PizzaOrderDAO {

    public static void saveOrder(PizzaOrder order) {
        String sql = "INSERT INTO pizza_orders (customer_name, mobile_number, pizza_size, number_of_toppings, total_bill) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, order.getCustomerName());
            stmt.setString(2, order.getMobileNumber());
            stmt.setString(3, order.getPizzaSize());
            stmt.setInt(4, order.getNumberOfToppings());
            stmt.setDouble(5, order.getTotalBill());
            stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static List<PizzaOrder> getAllOrders() {
        List<PizzaOrder> list = new ArrayList<>();
        String sql = "SELECT * FROM pizza_orders";
        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new PizzaOrder(
                    rs.getInt("id"),
                    rs.getString("customer_name"),
                    rs.getString("mobile_number"),
                    rs.getString("pizza_size"),
                    rs.getInt("number_of_toppings"),
                    rs.getDouble("total_bill")
                ));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }
}



