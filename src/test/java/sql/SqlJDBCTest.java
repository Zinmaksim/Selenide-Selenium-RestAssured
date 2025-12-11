package sql;

import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlJDBCTest extends JDBCPostgreSQLBase {

    @Test
    public void testSelect() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Staff"); // замените на ваше имя таблицы

        // Обработка результата
        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String position = resultSet.getString("position");
            String birthday = resultSet.getString("birthday");
            String has_children = resultSet.getString("has_children");
            System.out.println(id + ", " + name + ", " + position + ", " + birthday + ", " + has_children);
        }


        resultSet.close();
        statement.close();
    }


}





