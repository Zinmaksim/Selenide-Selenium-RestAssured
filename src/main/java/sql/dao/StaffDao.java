package sql.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sql.HibernateSessionFactoryUtil;
import sql.Staff;

import java.util.List;

public class StaffDao {
    public Staff findById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Staff.class, id);
    }

    public void save(Staff staff) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(staff);
        tx1.commit();
        session.close();
    }

    public void update(Staff staff) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(staff);
        tx1.commit();
        session.close();
    }

    public void delete(Staff staff) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(staff);
        tx1.commit();
        session.close();
    }

    // если несколько таблиц
    //  public Auto findAutoById(int id) {
    //      return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Auto.class, id);
    //  }

    public List<Staff> findAll() {
        List<Staff> staff = (List<Staff>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Staff").list();
        return staff;
    }
}
