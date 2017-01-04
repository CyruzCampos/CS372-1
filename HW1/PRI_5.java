import java.util.Scanner;

public class PRI_5 {
 public static void main(String[] args){
 
 //Ask User First Name
 Scanner S = new Scanner(System.in);
 System.out.println("Enter the first name: ");
 String fname = S.next();
 
 //Ask User Last Name
 System.out.println("Enter the last name: ");
 String lname = S.next();
 
 //Ask User Salary
 System.out.println("Enter the Salary: ");
 double sal = S.nextDouble();
 
 //Display the yearly salary
 Employee e =new Employee(fname, lname, sal);
 System.out.println("the yearly salary of "+e.getFirstName()+" "+e.getLastName()+" :");
 System.out.println(e.getMonthlySalary()*12);
 double newsalary=e.getMonthlySalary()*0.1+e.getMonthlySalary();
 e.setMonthlySalary(newsalary);
 System.out.println("the new yearly salary of "+e.getFirstName()+" "+e.getLastName()+" :");
 System.out.println(e.getMonthlySalary()*12);
 e.getMonthlySalary();
 }
}


