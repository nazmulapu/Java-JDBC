import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by nazmul on 11/11/2017.
 */
public class updateDB {

    public static void main(String[] args) throws SQLException {
        Connection conn = DBUtil.getConnection(DBType.MYSQLDB);

        String sql = "UPDATE `products` SET `price` = ? WHERE `products`.`id` = ?";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter product ID :");
        int id = scanner.nextInt();

        System.out.println("Enter new Price :");
        Float pprice = scanner.nextFloat();

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setFloat(1, pprice);
        pstmt.setInt(2, id);

        int result = pstmt.executeUpdate();

        if (result == 1)
        {
            System.out.println("Product price updated successfully.");
        }

        else {
            System.err.println("Product price update failed.");
        }

        scanner.close();
        pstmt.close();
        conn.close();
    }
}
