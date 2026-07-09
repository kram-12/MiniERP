import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductStockReport {
    public static void main(String[] args) {
        String sql = "select product_id, product_name, category, unit_price, stock_qty from erp_products order by product_id";

        try (Connection con = DbUtil.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("PRODUCT STOCK REPORT");
            System.out.println("--------------------");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("product_id") + " | " +
                    rs.getString("product_name") + " | " +
                    rs.getString("category") + " | " +
                    rs.getDouble("unit_price") + " | stock=" +
                    rs.getInt("stock_qty")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}