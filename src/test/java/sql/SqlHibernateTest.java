package sql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class SqlHibernateTest extends JDBCPostgreSQLHibernateBase {
    private static SessionFactory sessionFactory;

    public SqlHibernateTest() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public List<Staff> getAllStaff() {
        Session session = sessionFactory.openSession();
        List<Staff> staff = null;
        return staff;
    }

        @Test
        public void getSelectHibernate () throws SQLException {
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            //  Statement statement = connection.createStatement();
            //  ResultSet resultSet = statement.executeQuery("SELECT * FROM Staff2"); // замените на ваше имя таблицы
            Query resultSet = session.createQuery("FROM Staff");//.getResultList();

            // Обработка результата
            //   while (resultSet.next()) {
            //       String id = resultSet.getString("id");
            //       String name = resultSet.getString("name");
            //       String position = resultSet.getString("position");
            //       String birthday = resultSet.getString("birthday");
            //       String has_children = resultSet.getString("has_children");
            //       System.out.println(id + ", " + name + ", " + position + ", " + birthday + ", " + has_children);
            //   }

            transaction.commit();
            session.close();
            // resultSet.close();
            // statement.close();
        }


    }






