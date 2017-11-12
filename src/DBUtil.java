import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by nazmul on 11/8/2017.
 */
public class DBUtil {

    private static final String oraUser = "hr";
    private static final String oraPwd = "hr";
    private static final String mySqlUser = "root";
    private static final String mySqlPwd = "";
    private static final String oraCS = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String mySQLCS = "jdbc:mysql://localhost:3306/nazshop";

    public static Connection getConnection (DBType dbType) throws SQLException {

        switch (dbType) {
            case ORADB:
                return DriverManager.getConnection(oraCS, oraUser, oraPwd);
            case MYSQLDB:
                return DriverManager.getConnection(mySQLCS, mySqlUser, mySqlPwd);
            default:
                return null;
        }
    }
}
