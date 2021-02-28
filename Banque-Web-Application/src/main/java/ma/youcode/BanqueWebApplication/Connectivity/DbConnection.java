package ma.youcode.BanqueWebApplication.Connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static String jdbcURL = "jdbc:postgresql://localhost/webbq?useSSL=false";
    private static String jdbcUsername = "postgres";
    private static String jdbcPassword = "moonlightmydata";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            System.out.println("Connection Etablie");
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("erreur !!!!!!!!!!!!!!!!");
        }
        return connection;
    }



}
