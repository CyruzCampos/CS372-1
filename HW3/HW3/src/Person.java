import java.util.ArrayList;
/**
 * @author CyruzCampos
 * The Person class.
 */
public class Person {
	protected String name;
	protected int age;
	protected int phone_number;
	private ArrayList<Person>  population = new ArrayList <Person>();
	
	/**
	 * @param name This is the name of the person.
	 * @param age This is the age of the person.
	 * @param phone_number This is the person's phone number.
	 */
	public Person(String name, int age, int phone_number) {
		this.name = name;
		this.age = age;
		this.phone_number = phone_number;
	}
	
/**
 * @return Returns the name since it is set to private.
 */
		public String getName() {
			return name;
		}
		
/**
 * @return Returns the age since it is set to private.
 */
		public int getAge() {
			return age;
		}
		
/**
 * @return Returns the phone number since it is set to private.
 */
		public int getPhone_number() {
			return phone_number;
		}

/**
 * @param p P is the person object.
 */
		public void addCitizens(Person p){
			population.add(p);
		}
		
/**
 * @return Returns how many citizens are in the city.
 */
		public ArrayList<Person> getCitizens() {
			return population;
		}
		
		public String getInfo() {
			String s = String.format(" Name: %s\n Age: %d\n Phone Number: %d\n", name, age, phone_number);
			return s;
		}
}
