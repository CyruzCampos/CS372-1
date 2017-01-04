public class Date {
//Setting Year, Month, and Day all to private
 private int year;
 private int month;
 private int day;
 public Date(int y , int m , int d){
//If User creates a year less than 0, automatically set the year to 2000
 if(y>=0)
 year = y;
 else year = 2000;
 
//If User does not create a month between, january and december, then set the month to january
 if(m>0 && m<=12)
 month = m;
 else month = 1;
 
//If User does not create a day between, 0 and 30, then set the day to 1
 if(d>0 && d<=30)
 day = d;
 else day = 1;
 }
 
 public int getYear(){
 return year;
 }
 public void setYear(int y){
 if(y>=0)
 year = y;
 else year = 2000;
 }
 public int getMonth(){
 return month;
 }
 public void setMonth(int m){
 if(m>0 && m<=12)
 month = m;
 else month = 1;
 }
 public int getDay(){
 return day;
 }
 public void setDay(int d){
 if(d>0 && d<=30)
 day = d;
 else day = 1;
 }
 public void display(){
 System.out.println(month+"/"+day+"/"+year);
 }
}