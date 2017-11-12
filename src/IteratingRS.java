import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by nazmul on 11/9/2017.
 */
public class IteratingRS {

    public static void main(String[] args) throws SQLException {

        try (
               Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
               Statement stmt = conn.createStatement();
               ResultSet rs = stmt.executeQuery("Select * from products");
            ) {


            String format = "%-4s%-20s%-25s%-10f\n";

            while (rs.next()) {
                System.out.format(format,rs.getString("id"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"));
            }
        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }
    }
}
