import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    private static final String URL = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
    private static final String USER = "appuser";
    private static final String PASSWORD = "appuser123";

    public static Connection getConnection() throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}