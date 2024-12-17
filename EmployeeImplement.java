import java.sql.*;

public class EmployeeImplement implements EmployeeInterface {

    Connection con;
    @Override
    public void addEmployee(Employee emp) {
        con = DBConnection.createDBConnection();
        String query = "insert into emp values(?,?,?,?)";

        PreparedStatement ps ;
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1,emp.getId());
            ps.setString(2,emp.getName());
            ps.setDouble(3,emp.getSalary());
            ps.setString(4,emp.getJob());

            int count = ps.executeUpdate();

            if(count != 0)
                System.out.println("\nEmployee added  successfully !");

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void showAllEmployee() {

        con = DBConnection.createDBConnection();
        String query = "select * from emp";

        System.out.println("\nEmployee Details");
        System.out.println("----------------------------------------------------------------------------");
        System.out.format("%s\t%s\t\t%s\t\t\t\t%s","ID","NAME","SALARY","ROLE");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------");

        try{
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery(query);

            while(resultSet.next()){

                System.out.format("%d\t%s\t\t%f\t\t%s",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getString(4));
                System.out.println();
                System.out.println("----------------------------------------------------------------------------");
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void showBasedOnId(int id) {

        con = DBConnection.createDBConnection();
        String query = "select * from emp where id = "+id;
        System.out.println("\nEmployee Details");
        System.out.println("----------------------------------------------------------------------------");
        System.out.format("%s\t%s\t\t%s\t\t\t\t%s","ID","NAME","SALARY","ROLE");
        System.out.println();
        System.out.println("----------------------------------------------------------------------------");
        try{
            Statement ps = con.createStatement();
            ResultSet resultSet = ps.executeQuery(query);

            while(resultSet.next()){

                System.out.format("%d\t%s\t\t%f\t\t%s",
                        resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getDouble(3),
                        resultSet.getString(4));
                System.out.println();
                System.out.println("--------------------------------------------------------------------");

            }

        }


        catch (Exception e) {
            e.printStackTrace();
        }
    }

        @Override
    public void updateEmployee(int id, String name) {

        con = DBConnection.createDBConnection();
        String query = "update emp set name = ? where id = ? ";

        try{

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,name);
            ps.setInt(2,id);

            int count = ps.executeUpdate();

            if(count != 0)
                System.out.println("\nEmployee details updated successfully !");

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {

        con = DBConnection.createDBConnection();
        String query = "delete from emp where id = "+id;

        try{

            PreparedStatement ps = con.prepareStatement(query);
            //setInt(1,id);

            int count = ps.executeUpdate();

            if(count != 0)
                System.out.println("\nEmployee deleted successfully !");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
}
