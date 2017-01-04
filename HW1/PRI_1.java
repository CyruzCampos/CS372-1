import java.util.Scanner;

public class PRI_1 {
	public static void main (String[] args){
		input();
	}

	//Asking User Input for a random number of their choosing
	public static void input() {
	Scanner scan = new Scanner(System.in);
	System.out.printf("Enter a number: ");
	int x = scan.nextInt();
	int y = x%2;
	
	//Check if the Number is Even
	if (y == 0) {
		System.out.printf("\nThe number is Even\n");
	}
	
	//Check if the Number is Odd
	else {
		System.out.printf("\nThe number is Odd\n");
	}	
	}
}
