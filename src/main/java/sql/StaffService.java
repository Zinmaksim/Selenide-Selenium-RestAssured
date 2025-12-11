package sql;

import sql.dao.StaffDao;

public class StaffService {
    private final StaffDao staffDao = new StaffDao();

    public StaffService() {
    }

    public Staff findStaff(int id) {
        return staffDao.findById(id);
    }

    public void saveStaff(Staff staff) {
        staffDao.save(staff);
    }

    public void deleteStaff(Staff staff) {
        staffDao.delete(staff);
    }

    public void updateStaff(Staff staff) {
        staffDao.update(staff);
    }

    public void findAllStaff() {
        staffDao.findAll();
        staffDao.findAll().forEach(System.out::println);
    }

    // public Auto findAutoById(int id) {
    //     return usersDao.findAutoById(id);
    // }


}
