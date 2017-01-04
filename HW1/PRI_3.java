import java.util.Scanner;

public class PRI_3 {
	public static void main (String[] args){
		value();
	}

	//Asking User Input for a random number of their choosing
	public static void value() {
	
	//Uppercase Characters
	char ua = 'A';
	char ub = 'B';
	char uc = 'C';
	
	//Lowercase Characters
	char a = 'a';
	char b = 'b';
	char c = 'c';
	
	//Numbers Characters
	char x = '0';
	char y = '1';
	char z = '2';
	
	//Symbols Characters
	char s = '$';
	char u = '*';
	char p = '+';
	char bl = ' ';
	
	//Displaying the Character and the value from the UNICODE character set
	//Uppercase Characters
	System.out.printf("The character %c has the value %d\n", ua, ((int) ua));
	System.out.printf("The character %c has the value %d\n", ub, ((int) ub));
	System.out.printf("The character %c has the value %d\n", uc, ((int) uc));
	
	//Lowercase Characters
	System.out.printf("\nThe character %c has the value %d\n", a, ((int) a));
	System.out.printf("The character %c has the value %d\n", b, ((int) b));
	System.out.printf("The character %c has the value %d\n", c, ((int) c));
	
	//Number Characters
	System.out.printf("\nThe character %c has the value %d\n", x, ((int) x));
	System.out.printf("The character %c has the value %d\n", y, ((int) y));
	System.out.printf("The character %c has the value %d\n", z, ((int) z));
	
	//Symbol Characters
	System.out.printf("\nThe character %c has the value %d\n", s, ((int) s));
	System.out.printf("The character %c has the value %d\n", u, ((int) u));
	System.out.printf("The character %c has the value %d\n", p, ((int) p));
	System.out.printf("The character %c has the value %d\n", bl, ((int) bl));
	}
	
}
