import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * @author CyruzCampos
 *This is the interface class
 */
public class Interface {
	
	/**
	 * The Interface function creates a frame which names it "Dice Roll" and in this frame there is a button that is named start
	 * and when pressed creates five threads that each grab from the roll function from Roll.java and starts the program, also
	 * sets the button set to false so users can not make another set of five rolling dice.
	 */
	public Interface () {
		JFrame Yahtzee = new JFrame("Dice Roll");
		Yahtzee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Yahtzee.setLayout(new FlowLayout());
		Yahtzee.setSize(500, 100);
		
		JButton Start = new JButton("Start");
		Start.setToolTipText("Start the dice roll!");
		Start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Start.setEnabled(false);
				Roll[] r = new Roll[5];
				for (int i = 0; i < 5; i++) {
					JLabel l = new JLabel();
					r[i] = new Roll(l);
					Yahtzee.add(l);
				}
				
				for (int i = 0; i < 5; i++) {
					Thread t = new Thread(r[i]);
					t.start();
					try {
						Thread.sleep(100);
					}
					catch (InterruptedException ex) {
						;
					}
				}
			}
			
		});
		
		Yahtzee.add(Start);
		Yahtzee.setVisible(true);
	}
}
