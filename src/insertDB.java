

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by nazmul on 11/11/2017.
 */
public class insertDB {

    public static void main(String[] args) throws SQLException {

        Connection conn = DBUtil.getConnection(DBType.MYSQLDB);

        int id;
        String pname, pdescription;
        float ppprice;

        Scanner scanner = new Scanner(System.in);

        System.out.println(" Enter product ID :");
        id = Integer.parseInt(scanner.nextLine());

        System.out.println("Enter product name: ");
        pname = scanner.nextLine();

        System.out.println("Enter product description: ");
        pdescription = scanner.nextLine();

        System.out.println("Enter the price: ");
        //ppprice = Float.parseFloat(scanner.nextLine());
        ppprice = scanner.nextFloat();


        String sql = "insert into products values (?, ?, ?,?)";

        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setInt(1, id);
        pstmt.setString(2, pname);
        pstmt.setString(3, pdescription);
        pstmt.setFloat(4, ppprice);

        int result = pstmt.executeUpdate();

        if ( result == 1)

        {
            System.out.println("Record Inserted Successful.");
        }

        else {
            System.err.println("Error while adding the record");
        }

        scanner.close();
        pstmt.close();
        conn.close();

    }
}
