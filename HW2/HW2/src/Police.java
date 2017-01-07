/**
 * @author CyruzCampos
 * This is the Police class that extends from the Person class and implements from the Employee interface.
 */
public class Police extends Person implements Employee {
	public enum role {
		Patrol, Sargent, Captain, Chief;
	}
	
	public role police_role;
	private static int employee_id = 0;
	private static double wage = 0;
	private static double balance = 0;
	
/**
 * @param name This is the name of the Police officer.
 * @param age This is the age of the Police Officer.
 * @param phone_number This is the Police Officer's phone number.
 * @param police_role This is the ranking of the Police Officer.
 * @param wage This is the Police Officer's wage.
 */
	public Police(String name, int age, int phone_number, role police_role, double wage) {
		super(name, age, phone_number);
		employee_id++;
		this.police_role = police_role;
		this.wage = wage;
	}
	
/**
 * Payment function, that pays the Officer how much they make (wage).
 */
	public void payment(){
		balance += wage;
	}
	
/**
 * @return Returns the employee ID since it is set to private.
 */
	public int get_employee_id() {
		return employee_id;
	}
}