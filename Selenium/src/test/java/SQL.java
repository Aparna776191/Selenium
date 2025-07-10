import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQL {

    public static void main(String[] args) throws SQLException {
        // Update with your actual database name
        String url = "jdbc:mysql://localhost:3306/mysql"; 
        String username = "root";
        String password = "Kanna@143";

        Connection connection = DriverManager.getConnection(url, username, password);

        if (connection.isClosed()) {
            System.out.println("SQL is not connected");
        } else {
            System.out.println("SQL is connected");
        }
    }
}
