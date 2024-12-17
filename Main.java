import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        EmployeeInterface employeeInterface = new EmployeeImplement();
        System.out.println();
        System.out.println("\t\t\tEmployee Management Application");
        Scanner sc = new Scanner(System.in);


        while(true){
            System.out.println("\n" +
                    "1. Add Employee\n" +
                    "2. Show all employee\n" +
                    "3. Show employee based on id\n" +
                    "4. Update employee\n" +
                    "5. Delete employee\n" +
                    "6. Exit\n");
            System.out.println();

            System.out.println("Enter your choice : ");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    Employee emp = new Employee ();
                    System.out.println("Enter employee id :");
                    int id = sc.nextInt();
                    System.out.println("Enter the employee name :");
                    String name = sc.next();
                    System.out.println("Enter the salary : ");
                    double salary = sc.nextDouble();
                    System.out.println("Enter the job role :");
                    String job = sc.next();
                    emp.setId(id);
                    emp.setName(name);
                    emp.setSalary(salary);
                    emp.setJob(job);
                    employeeInterface.addEmployee(emp);
                    break;


                case 2:
                    employeeInterface.showAllEmployee();
                    break;


                case 3:
                    System.out.println("Enter the employee id : ");
                    int empid = sc.nextInt();
                    employeeInterface.showBasedOnId(empid);
                    break;


                case 4:
                    System.out.println("Enter the id to update the details : ");
                    int id2 = sc.nextInt();
                    System.out.println("Enter the name : ");
                    String name2 = sc.next();
                    employeeInterface.updateEmployee(id2,name2);
                    break;


                case 5:
                    System.out.println("Enter the id to delete : ");
                    int id3 = sc.nextInt();
                    employeeInterface.deleteEmployee(id3);
                    break;


                case 6:
                    System.out.println("\nThanks for using this application !!!");
                    System.exit(0);


                default:
                    System.out.println("\nEnter the valid choice..");
                    break;

            }

        }

    }
}