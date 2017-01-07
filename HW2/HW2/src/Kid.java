/**
 * @author ccampos18
 * This is the Kid class that extends from the Person class..
 */
public class Kid extends Person {
	private String favorite_candy;
	
/**
 * @param name This is the name of the kid.
 * @param age This is the age of the kid.
 * @param phone_number This is the kid's phone number.
 * @param favorite_candy This is the kid's favorite candy.
 */
	public Kid(String name, int age, int phone_number, String favorite_candy) {
		super(name, age, phone_number);
		this.favorite_candy = favorite_candy;
	}

}