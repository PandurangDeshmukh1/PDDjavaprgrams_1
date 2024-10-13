import java.sql.*;

public class SimpleDB {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db", "root", "root");
        Statement stmt = conn.createStatement();
        stmt.execute("CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100))");
        stmt.executeUpdate("INSERT INTO users (name) VALUES ('Alice')");
        ResultSet rs = stmt.executeQuery("SELECT * FROM users");
        while (rs.next()) System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
        rs.close(); stmt.close(); conn.close();
    }
}
