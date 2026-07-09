import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class SetupCheck {
    public static void main(String[] args) {
        try (Connection con = DbUtil.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("select 'Oracle connection OK' as msg from dual")) {

            while (rs.next()) {
                System.out.println(rs.getString("msg"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}