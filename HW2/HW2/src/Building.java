import java.util.ArrayList;
/**
 * @author ccampos18
 * The Building class.
 */
public class Building {
	private String name;
	private String address;
	private ArrayList<Person>  occupants = new ArrayList <Person>();
	
/**
 * 
 * @param name This is the name of the building.
 * @param address This is the address of the building.
 */
	public Building (String name, String address) {
		this.name = name;
		this.address = address;
	}
	
/**
 * @return Returns the name since it is set to private.
 */
	public String getName() {
		return name;
	}
	
/**
* @return Returns the address since it is set to private.
*/
	public String getAddress() {
		return address;
	}
	
/**
 * @param p P is the person object.
 */
	public void addPeople(Person p){
		occupants.add(p);
	}
	
/**
 * @return Returns the how many occupants that are in a certain building.
 */
	public ArrayList<Person> getOccupants() {
		return occupants;
	}
	
}