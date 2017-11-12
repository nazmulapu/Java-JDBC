import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by nazmul on 11/11/2017.
 */
public class callableDB {
    public static void main(String[] args) throws SQLException {
        try (
                Connection conn = DBUtil.getConnection(DBType.MYSQLDB);
                CallableStatement callableStatement = conn.prepareCall("{call NewAddProducts(?,?,?,?)}");
                )
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter product id: ");
            int pid = Integer.parseInt(scanner.nextLine());

            System.out.println("Enter product name: ");
            String pname = scanner.nextLine();

            System.out.println("Enter product description: ");
            String pdescription = scanner.nextLine();

            System.out.println("Enter product price: ");
            Float pprice = scanner.nextFloat();

            callableStatement.setInt(1, pid);
            callableStatement.setString(2, pname);
            callableStatement.setString(3, pdescription);
            callableStatement.setFloat(4, pprice);

            callableStatement.execute();

            System.out.println(" Product added successfully");
        }
        catch (SQLException ex){
            System.out.println(ex);
        }

    }
}
