import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author CyruzCampos
 * This is the Roll class that implements runnable
 */
public class Roll implements Runnable{
	private JLabel _label;
	
	/** 
	 * @param label Sets this label to the local variable in this class named _label.
	 */
	public Roll(JLabel label) {
		_label = label;
	}
	
	/**
	 * The run function is a function that creates two random number generators, one is timer; that sets how long should each thread run for, ranging between 1-100.
	 * The other one is random; that sets which photo should be displayed for each thread, this is ranging between 1-6 (for each side of the dice). Also this function
	 * grabs the images and sets their size, then the when a number is called will set that _label to the corresponding numbered dice.  
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random limit = new Random();
		int timer = limit.nextInt(100) + 1;
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL one_url = getClass().getResource("/Resource/die_face_1.png"); Image one_img = toolkit.getImage(one_url); one_img = one_img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); ImageIcon one_icon = new ImageIcon(one_img);
		URL two_url = getClass().getResource("/Resource/die_face_2.png"); Image two_img = toolkit.getImage(two_url); two_img = two_img.getScaledInstance(50, 50,Image.SCALE_SMOOTH); ImageIcon two_icon = new ImageIcon(two_img);
		URL three_url = getClass().getResource("/Resource/die_face_3.png"); Image three_img = toolkit.getImage(three_url); three_img = three_img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); ImageIcon three_icon = new ImageIcon(three_img);
		URL four_url = getClass().getResource("/Resource/die_face_4.png"); Image four_img = toolkit.getImage(four_url); four_img = four_img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); ImageIcon four_icon = new ImageIcon(four_img);
		URL five_url = getClass().getResource("/Resource/die_face_5.png"); Image five_img = toolkit.getImage(five_url); five_img = five_img.getScaledInstance(50, 50,Image.SCALE_SMOOTH); ImageIcon five_icon = new ImageIcon(five_img);
		URL six_url = getClass().getResource("/Resource/die-face-6.png"); Image six_img = toolkit.getImage(six_url); six_img = six_img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); ImageIcon six_icon = new ImageIcon(six_img);
		 
		for (int i = timer; i >= 0; i--) {
			Random rand = new Random();
			int random = rand.nextInt(6) + 1;
			
			if (random == 1) {
				_label.setIcon(one_icon);
			}
			
			if (random == 2) {
				_label.setIcon(two_icon);
			}
			
			if (random == 3) {
				_label.setIcon(three_icon);
			}
			
			if (random == 4) {
				_label.setIcon(four_icon);
			}
			
			if (random == 5) {
				_label.setIcon(five_icon);
			}
			
			if (random == 6) {
				_label.setIcon(six_icon);
			}
			
			try {
				Thread.sleep(100);
			}
			
			catch (InterruptedException ex) {
				;
			}
		}
	}

}
