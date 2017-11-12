import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by nazmul on 11/7/2017.
 */
public class ConnectMysql {

    static String username = "root";
    static String password = "";
    static String dbUrl ="jdbc:mysql://localhost:3306/javadata";

    public static void main(String[] args) throws SQLException {

        Connection conn  = null;

        try  {

          conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connection Establish to MySql database");
        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }

        finally {
            conn.close();
        }

    }

}
