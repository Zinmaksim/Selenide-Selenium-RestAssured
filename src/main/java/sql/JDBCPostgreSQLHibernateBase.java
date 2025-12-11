package sql;

import org.hibernate.SessionFactory;

abstract public class JDBCPostgreSQLHibernateBase {
    private static SessionFactory sessionFactory;

    //  @BeforeClass
    //  public static void setUp() {
    //      sessionFactory = new Configuration().configure().buildSessionFactory();
    //  }
//


    //  protected Connection connection;

    //  @BeforeEach
    //  public void setUp() throws SQLException {
    //      // Установите соединение с базой данных
    //      String url = "jdbc:postgresql://localhost:5432/MyDB";
    //      String user = "postgres";
    //      String password = "postgres";
    //      connection = DriverManager.getConnection(url, user, password);
    //  }


    //  @AfterEach
    //  public void tearDown() throws SQLException {
    //      // Закрытие соединения
    //      if (connection != null && !connection.isClosed()) {
    //          connection.close();
    //      }
    //  }


}
