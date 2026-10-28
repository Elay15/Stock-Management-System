package com.mycompany.stock_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseTest {
    public static void main(String[] args) {
        try {
            Connection connection = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM products";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                JOptionPane.showMessageDialog(
                    null,
                    "Product: " + result.getString("product_name")
                    + "\nStock: " + result.getInt("current_stock")
                );
            }

            result.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}