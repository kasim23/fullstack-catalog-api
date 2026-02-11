package repository;

import models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class OrderRepository {
    private final Connection conn;

    public OrderRepository(Connection conn) {
        this.conn = conn;
    }

    public void createTable() throws SQLException {
        String sql = """
            CREATE TABLE IF NOT EXISTS orders (
                id SERIAL PRIMARY KEY,
                customer_id INT, -- This would link to a customers table
                order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                status TEXT
            )
            """;
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        }
    }

    public void save(Order order) throws SQLException {
        String sql = "INSERT INTO orders (customer_id, status)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, order.getCustomerId());
            pstmt.setString(2, order.getStatus().name());
        }
    }

//    public void printOrderReceipt(int orderId) throws SQLException {
//        String sql = """
//                SELECT """
//    }
}
