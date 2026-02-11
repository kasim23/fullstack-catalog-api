import models.Product;
import repository.ProductRepository;

import java.sql.*;
import java.util.List;
import java.util.Properties;

public class App {

    public static void main(String[] args) {
        try (Connection conn = setup()) {
            if (conn.isValid(5)) {
                System.out.println("--- Connection Verified ---");
                createAndSetSchema(conn);

                ProductRepository repo = new ProductRepository(conn);

                // setup the database
                repo.createTable();
                Product newKeyboard = new Product("MSI Keyboard", "Mechanical switches", 99.99, 10);
                repo.save(newKeyboard);
                Product razorMouse = new Product("RAZER VIPER V3 PRO", "Ultra-lighweight Wireless Symmetrical Esports Mouse",
                        89.99, 15);
                repo.save(razorMouse);
                Product airPodsProMax = new Product("APPLE Airpods Pro Max", "Sleek and modern premium over-ear headphones",
                        499.99, 26);
                repo.save(airPodsProMax);
                Product nvidiaRtx5090 = new Product("NVIDIA GeForce RTX 5090", "Ultimate, enthusiast-class flagship GPU, offering unprecedented performance for 4K gaming",

                        4499.99, 20);
                repo.save(nvidiaRtx5090);

                List<Product> catalogue = repo.findAll();
                catalogue.forEach(System.out::println);
                System.out.println("--- Setup Complete ---");
            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Connects to the database
    public static Connection setup() throws SQLException {
        String url = "jdbc:postgresql://localhost/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "postgres");

        System.out.println("Connecting to database...");
        return DriverManager.getConnection(url, props);
    }

    // Creates the schema and sets the search path
    public static void createAndSetSchema(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE SCHEMA IF NOT EXISTS my_shop_schema");
            stmt.execute("SET search_path TO my_shop_schema");
            System.out.println("Schema 'my_shop_schema' is ready.");
        }
    }

    // Creates the products table
    public static void createTables(Connection conn) throws SQLException {
        String createTableSql = """
            CREATE TABLE IF NOT EXISTS products (
                product_id SERIAL PRIMARY KEY,
                name VARCHAR(40) NOT NULL,
                description TEXT NOT NULL,
                price DECIMAL(10, 2) NOT NULL,
                stock_quantity INT DEFAULT 0
            )
            """;
        try (Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSql);
            System.out.println("Products table is ready.");
        }
    }

    // Inserts a product using a PreparedStatement for security
    public static void insertProduct(Connection conn, String name, String desc, double price, int qty) throws SQLException {
        String insertSql = "INSERT INTO products (name, description, price, stock_quantity) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, desc);
            pstmt.setDouble(3, price);
            pstmt.setInt(4, qty);
            pstmt.executeUpdate();
            System.out.println("Sample product '" + name + "' inserted.");
        }
    }
}