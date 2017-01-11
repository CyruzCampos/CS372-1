	/**
	 * The City program implements an application that creates a city
	 * with multiple buildings and citizens, as well as organizing those
	 * citizens for which are children, teachers, and police.
	 * 
	 * @author ccampos18
	 * @version 1.0
	 * @since 01/11/2017
	 */
	import java.util.Scanner;

	import javax.swing.*;

	import java.util.ArrayList;
	import java.util.Random;

	/**
	 * The class city holds:
	 * main(), prompt(), we_built_this_city(), add_citizens(), display_population(), display_buildings(),
	 * display_children_in_school(), display_people_in_City_Hall(), pay_employees(), and the interface.
	 */
	public class City extends JComponent {
	/**
	* The population ArrayList creates an array to hold how many people are created overall.
	* The buildings ArrayList creates an array to hold how many buildings are created overall.
	*/
		private static Random rnd = new Random ();
		static ArrayList<Person> population = new ArrayList<Person>();
		static ArrayList<Building> buildings = new ArrayList<Building>();
		
	/**
	 * The prompt function asks the user what exactly they want to do in the program.
	 */
		public static void prompt() {
			int choice;
			
				do {
					System.out.printf("\n-Welcome to Spokane City-\n");
					System.out.printf("\n1.Output the names of all the Citizens\n");
					System.out.printf("2.Output the names of all the Buildings\n");
					System.out.printf("3.Output who is in School, and City Hall\n");
					System.out.printf("4.Pay the Employees\n");
					System.out.printf("5.Quit the program\n");
					System.out.printf("\nWhat is your decision?: ");
					Scanner S = new Scanner(System.in);
					choice = S.nextInt();
			
					switch (choice) {
						case 1: display_population();
							break;
				
						case 2: display_building();
							break;
				
						case 3: display_children_in_school(); display_people_in_City_Hall();
							break;
					
						case 4: pay_employees();
							break;
							
						case 5: System.out.printf("\nYou have chosen to Quit, Goodbye.\n");
						break;
				
						default: System.out.printf ("Invaid Answer");
							break;
						}
					}while (choice!=5);
		}
		
	/**
	 * The we_built_this_city function, creates all the buildings using Building.java for parameters and
	 * sets them into the buildings ArrayList.
	 */
		public static void we_built_this_city() {
			buildings.add(new City_Hall("City Hall", "808 W Spokane Falls Blvd"));
			//buildings.add(new School("Villa Vista Preschool", "8802 N Country Homes Blvd"));
			buildings.add(new School("Sheridan Elementary", "3737 E 5th Ave"));
			//buildings.add(new School("Chase Middle School", "4747 E 37th Ave, Spokane"));
			buildings.add(new School("Ferris High School", "3020 E 37th Ave"));
			buildings.add(new School("Whitworth University", "300 W Hawthorne Rd"));
			buildings.add(new Building("Downtown Mall", " 808 W Main Ave"));
			//buildings.add(new Building("Northtown Mall", "4750 N Division St"));
			//buildings.add(new Building("Valley Mall", "14700 E Indiana Ave"));
			buildings.add(new Building("Spokane City Credit Union", "1930 N Monroe St"));
			//buildings.add(new Building("Wonderland", "10515 N Division St"));
			//buildings.add(new Building("FedEx", "7116 N Division St"));
		
		}
		
	/**
	 * The add-citizens function, creates all the citizens using Person.java as the main class, while
	 * Police.java, Teacher.java, and Kid.java are extensions have their own variables in each, then 
	 * sets them into the population ArrayList.
	 */
		public static void add_citizens() {
			int namecount = 1;
			for (int i = 0; i <5; i++){
				population.add(new Police(String.format("Police Name %d", namecount++),rnd.nextInt(40)+20, rnd.nextInt(900000)+1000000, Police.role.Captain, (double)rnd.nextInt(3000)/100+10));
				population.add(new Police(String.format("Police Name %d", namecount++),rnd.nextInt(40)+20, rnd.nextInt(900000)+1000000, Police.role.Chief, (double)rnd.nextInt(3000)/100+10));
				population.add(new Police(String.format("Police Name %d", namecount++),rnd.nextInt(40)+20, rnd.nextInt(900000)+1000000, Police.role.Sargent, (double)rnd.nextInt(3000)/100+10));
				population.add(new Police(String.format("Police Name %d", namecount++),rnd.nextInt(40)+20, rnd.nextInt(900000)+1000000, Police.role.Patrol, (double)rnd.nextInt(3000)/100+10));
			}
			
			namecount = 1;
			for (int i = 0; i < 20; i++){
				population.add(new Teacher(String.format("Teacher Name %d", namecount++),rnd.nextInt(40)+20, rnd.nextInt(900000)+1000000, rnd.nextInt(12)+1, rnd.nextInt(1)==1, (double)rnd.nextInt(3000)/100+10));
			}
			
			namecount = 1;
			for (int i = 0; i < 40; i++){
				population.add(new Kid(String.format("Kid Name %d", namecount++), rnd.nextInt(11)+10, rnd.nextInt(9000000)+1000000, String.format("Favorite Candy %d", namecount)));
			}
			
			namecount = 1;
			for (int i = 0; i < 20; i++){
				population.add(new Person(String.format("Person Name %d", namecount++), rnd.nextInt(40)+20, rnd.nextInt(9000000)+1000000));
			}
			
			for (int i = 0; i < population.size(); i++){
				buildings.get(rnd.nextInt(buildings.size())).addPeople(population.get(i));
			}
		}
		
	/**
	 * The display_population function, is a function that outputs what is all in the populations ArrayList;
	 * outputting each person's name as well.
	 */
		public static void display_population() {
			System.out.println("\nPopulation: ");
			for (Person p : population) {
				System.out.printf("%s \n", p.getName());
			}
		}
		
	/**
	 * The display_building function, is a function that outputs what is all in the buildings ArrayList;
	 * outputting each building's names as well.
	 */
		public static void display_building() {
			System.out.println("\nBuildings: ");
			for (Building b: buildings) {
				System.out.printf(("%s \n"), b.getName());
			}
		}
		
	/**
	 * The display_children_in_school function, is a function that outputs everyone who is in school currently,
	 * it does this by filtering the buildings, to only schools, then filtering the people, to only kids.
	 */
		public static void display_children_in_school() {
			System.out.printf("\nThese are the children who are at school: \n");
			for (Building b: buildings) {
				if (b instanceof School) {
					for(Person p: b.getOccupants()) {
						if (p instanceof Kid) {
							System.out.printf("%s is at %s.\n", p.getName(), b.getName());
						}
					}
				}
			}
		}
		
	/**
	* The display_people_in_city_hall function, is a function that outputs everyone who is in city hall currently,
	* it does this by filtering the buildings, to only city hall.
	*/
		public static void display_people_in_City_Hall() {
			System.out.printf("\nThese are the people who are at City Hall: \n");
			for (Building b: buildings) {
				if (b instanceof City_Hall) {
					for(Person p: b.getOccupants()) {
							System.out.printf("%s is at %s.\n", p.getName(), b.getName());
					}
				}
			}
		}
		
	/**
	 * the pay_employees function, is a function that pays anyone who is an employee, then showing said employee
	 * was paid.
	 */
		public static void pay_employees() {
			for (Person p: population) {
				if (p instanceof Police) {
				System.out.printf("%s ", p.getName());
				System.out.printf("got paid ");
				System.out.printf("%s", ((Police) p).payment());
				}
				
				if (p instanceof Teacher) {
					System.out.printf("%s ", p.getName());
					System.out.printf("got paid ");
					System.out.printf("$%s.00.\n", ((Teacher) p).payment());
				}
			}
		}
		
	/**
	 * @param args (argument holder value) The main function of the program.
	 */
		public static void main(String[] args) {
		we_built_this_city();
		add_citizens();
		Second_City c = new Second_City();
		prompt();
	}

}
