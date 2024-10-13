import java.sql.*;

public class Simple {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "your_password");
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100))");
            stmt.executeUpdate("INSERT INTO users (name) VALUES ('Bob')");
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) System.out.println("User ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
