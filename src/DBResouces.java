import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by nazmul on 11/8/2017.
 */
public class DBResouces {

        public static void main(String[] args) throws SQLException {

            Connection conn  = null;

            try  {

               // conn = DriverManager.getConnection(dbUrl, username, password);

                conn = DBUtil.getConnection(DBType.MYSQLDB);
                System.out.println("Connection Establish to MySql database");
            } catch (SQLException e) {

                System.err.println(e.getMessage());
            }

            finally {
                conn.close();
            }

        }

    }


