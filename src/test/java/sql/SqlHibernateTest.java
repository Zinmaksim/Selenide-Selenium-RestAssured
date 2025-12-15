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
            Transaction tx = null;

            try {
                tx = session.beginTransaction();

                // 1. Простой SELECT — возвращает List<Object[]>
                String sql = "SELECT id, name, position FROM Staff WHERE id > :minId";
                List<Object[]> results = session
                        .createNativeQuery(sql)
                        .setParameter("minId", 0L)
                        .getResultList();

                for (Object[] row : results) {
                    Long id = ((Number) row[0]).longValue();
                    String name = (String) row[1];
                    String position = (String) row[2];
                    System.out.printf("ID: %d, Name: %s, Position: %s%n", id, name, position);
                }

                tx.commit();

            } catch (Exception e) {
                if (tx != null) tx.rollback();
                e.printStackTrace();
            } finally {
                session.close();
            }
           // transaction.commit();
           // session.close();
            // resultSet.close();
            // statement.close();
        }


    }






