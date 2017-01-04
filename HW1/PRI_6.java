import java.util.Scanner;

public class PRI_6 {
 
 public static void main(String [] args){
 Scanner S = new Scanner(System.in);
 
 //Ask user the year
 System.out.print("Enter year: ");
 int year = S.nextInt();
 
 //Ask user the month
 System.out.print("Enter month: ");
 int month = S.nextInt();
 
 //Ask user the day
 System.out.print("Enter day: ");
 int day = S.nextInt();
 
 //Displays the user's input
 Date date = new Date(year, month, day);
 System.out.print("The date you entered: ");
 date.display();
 }
}