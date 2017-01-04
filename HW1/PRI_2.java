import java.util.Scanner;

public class PRI_2 {
	public static void main (String[] args){
		output();
	}

	//Asking User Input for a random number of their choosing
	public static void output() {
	Scanner scan = new Scanner(System.in);
	System.out.printf("Enter the radius of a circle: ");
	int r = scan.nextInt();
	
	//Constant value PI that holds 3.14
	final double PI = 3.14;
	
	//The solution for the area of the circle
	double area = (PI)*(r*r);
	
	//Outputs the area of the circle they created
	System.out.printf("Area of the Circle is: %.2f", area);
	}
}
