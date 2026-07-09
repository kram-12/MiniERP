import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class EmployeeReport {
    public static void main(String[] args) {
        String sql = "select employee_id, employee_name, department, salary from erp_employees order by employee_id";

        try (Connection con = DbUtil.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("EMPLOYEE REPORT");
            System.out.println("---------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("employee_id") + " | " +
                    rs.getString("employee_name") + " | " +
                    rs.getString("department") + " | " +
                    rs.getDouble("salary")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}