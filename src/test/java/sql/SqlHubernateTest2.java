package sql;


import org.junit.jupiter.api.Test;

public class SqlHubernateTest2 {
    StaffService staffService = new StaffService();


   @Test
    public  void getSelect() {
       staffService.findAllStaff();

   }
}
