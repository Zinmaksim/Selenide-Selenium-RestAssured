package sql;

//import org.hibernate.hql.internal.ast.tree.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCPostgreSQLExample {
    //  Database credentials
    static final String DB_URL = "jdbc:postgresql://localhost:5432/MyDB";
    static final String USER = "postgres";
    static final String PASS = "postgres";

    public static void main(String[] argv) throws SQLException {

        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        Connection connection = null;

        try {
            connection = DriverManager
                    .getConnection(DB_URL, USER, PASS);

        } catch (SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }


        // assert connection != null;
        //   Statement sql_statement =   connection.createStatement();
        // ResultSet table = sql_statement.executeQuery("SELECT * FROM   Staff");
        // while (table.next())   {
        //     String tableCol= table.getString("name");
        //     System.out.println("Bike Number = " +   tableCol);
        // }


    }
}