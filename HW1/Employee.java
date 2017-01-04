 public class Employee {
 //Setting First, Last, and Salary all to private
 private String firstName;
 private String lastName;
 private double monthlySalary;
 
 public Employee(String f, String l, double m){
 firstName = f;
 lastName = l;
 
 //If User creates a salary lower than 0, it will automatically set the salary to 0
 if(m < 0){ 
 monthlySalary =0;
 }
 else monthlySalary = m;
 }
 
 //Retriving First Name
 public String getFirstName() {
 return firstName;
 }
 public void setFirstName(String fname) {
 firstName = fname;
 }
 
 //Retriving Last Name
 public String getLastName() {
 return lastName;
 }
 public void setLastName(String lname) {
 lastName = lname;
 }
 
 //Retriving Monthly Salary
 public double getMonthlySalary() {
 return monthlySalary;
 }
 public void setMonthlySalary(double m) {
 if(m < 0){
 monthlySalary =0;
 }
 else monthlySalary = m;
 }
 }