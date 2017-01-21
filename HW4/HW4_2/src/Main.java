/**
 * This is the Spider program that creates a spider which grabs URL links from the HTML code, and saves them into a Hashmap and then
 * reads each link grabbing more links and saving them, only stops after 100 times.
 * 
 * @author CyruzCampos
 * @version 1.0
 * @since 01/20/17
 */
public class Main {

	/**
	 * @param args (argument holder value) The main function of the program. Also runs the LinktoLink function from the Spider class.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Spider s = new Spider();
		s.LinktoLink();
	}

}
