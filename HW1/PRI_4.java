import java.util.Scanner;

public class PRI_4 {
	public static void main (String[] args){
		BMI();
	}

	//Asking User Input for their weight and height
	public static void BMI() {
	Scanner scan = new Scanner(System.in);
	System.out.printf("Enter your weight(lbs): ");
	double a = scan.nextDouble();
	System.out.printf("Enter your height(inches): ");
	double b = scan.nextDouble();
	
	//Calculations for BMI
	double BMIV = ((a * 703) / (b*b));
	
		//Underweight
		if (BMIV < 18.5) {
		System.out.printf("Underweight: %.2f", BMIV);
		}
		
		//Normal
		if (BMIV > 18.5 && BMIV < 24.9) {
		System.out.printf("Normal: %.2f", BMIV);
		}
		
		//Overweight
		if (BMIV > 25 && BMIV < 29.9) {
		System.out.printf("Overweight: %.2f", BMIV);
		}
		
		//Obese
		if (BMIV > 30) {
		System.out.printf("Obese: %.2f", BMIV);
		}
		
		//Should not reach here
		else {
		System.out.printf("You got a problem...");
		}
	}	
}