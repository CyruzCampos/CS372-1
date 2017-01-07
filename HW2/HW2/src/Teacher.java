/**
 * @author CyruzCampos
 * This is the Teacher class that extends from the Person class and implements from the Employee interface.
 */
public class Teacher extends Person implements Employee {
	private int grade_level;
	private boolean certification;
	private static int employee_id = 0;
	private double wage = 0;
	private double balance = 0;
	
/**
 * @param name This is the name of the Teacher.
 * @param age	This is the age of the Teacher.
 * @param phone_number This is the Teacher's phone number.
 * @param grade_level This is the grade level that the Teacher teaches at.
 * @param certification This is the Teacher's certification.
 * @param wage This is the Teacher's wage.
 */
	public Teacher(String name, int age, int phone_number, int grade_level, boolean certification, double wage) {
		super(name, age, phone_number);
		employee_id++;
		this.grade_level = grade_level;
		this.certification = certification;
		this.wage = wage;
	}

/**
 * Payment function, that pays the Officer how much they make (wage).
 */
	public void payment() {
		balance += wage;
	}
	
/**
 * @return Returns the employee ID since it is set to private.
 */
	public int get_employee_id() {
		return employee_id;
	}
}