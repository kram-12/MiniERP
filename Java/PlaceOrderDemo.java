import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import oracle.jdbc.OracleTypes;

public class PlaceOrderDemo {
    public static void main(String[] args) {
        try (Connection con = DbUtil.getConnection()) {
            con.setAutoCommit(false);

            int orderId;

            try (CallableStatement cs = con.prepareCall("{ ? = call erp_pkg.create_order(?) }")) {
                cs.registerOutParameter(1, OracleTypes.NUMBER);
                cs.setInt(2, 3);
                cs.execute();
                orderId = cs.getInt(1);
            }

            try (CallableStatement cs = con.prepareCall("{ call erp_pkg.add_order_item(?, ?, ?) }")) {
                cs.setInt(1, orderId);
                cs.setInt(2, 4);
                cs.setInt(3, 1);
                cs.execute();

                cs.setInt(1, orderId);
                cs.setInt(2, 5);
                cs.setInt(3, 2);
                cs.execute();
            }

            try (CallableStatement cs = con.prepareCall("{ call erp_pkg.finalize_order(?) }")) {
                cs.setInt(1, orderId);
                cs.execute();
            }

            con.commit();

            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                     "select order_id, customer_id, total_amount, status from erp_orders where order_id = " + orderId
                 )) {

                System.out.println("ORDER CREATED");
                System.out.println("-------------");
                while (rs.next()) {
                    System.out.println(
                        "Order ID: " + rs.getInt("order_id") +
                        ", Customer ID: " + rs.getInt("customer_id") +
                        ", Total: " + rs.getDouble("total_amount") +
                        ", Status: " + rs.getString("status")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}