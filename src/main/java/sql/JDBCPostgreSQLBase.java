package sql;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class JDBCPostgreSQLBase {

    protected Connection connection;

    @BeforeEach
    public void setUp() throws SQLException {
        // Установите соединение с базой данных
        String url = "jdbc:postgresql://localhost:5432/MyDB";
        String user = "postgres";
        String password = "postgres";
        connection = DriverManager.getConnection(url, user, password);
    }


    @AfterEach
    public void tearDown() throws SQLException {
        // Закрытие соединения
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }


}
