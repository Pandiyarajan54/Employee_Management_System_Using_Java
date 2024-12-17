import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection  {

     static Connection con;

    public static Connection createDBConnection() {

        try {

            String url = "jdbc:mysql://127.0.0.1:3306/employee";
            String name = "root";
            String password = "password";

             con = DriverManager.getConnection(url, name, password);
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }

}
