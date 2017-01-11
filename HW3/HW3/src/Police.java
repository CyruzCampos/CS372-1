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
	@SuppressWarnings("static-access")
	public Police(String name, int age, int phone_number, role police_role, double wage) {
		super(name, age, phone_number);
		employee_id++;
		this.police_role = police_role;
		this.wage = wage;
	}
	
/**
 * Payment function, that pays the Officer how much they make (wage).
 */
	public int payment(){
		balance += wage/20;
		return (int)balance;
	}
	
/**
 * @return Returns the employee ID since it is set to private.
 */
	public int get_employee_id() {
		return employee_id;
	}
	
	public String getInfo() {
		String s = String.format(" Name: %s\n Age: %d\n Phone Number: %d\n Police Role: %s\n Wage: $%.2f\n Balance: $%.2f\n", name, age, phone_number, police_role.toString(), wage, balance);
		return s;
	}
}