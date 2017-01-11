
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * @author ccampos18
 * This is the Second_City Class
 */
public class Second_City extends City {
	/**
	 * int idx is the place holder to find a certain person in a building.
	 * int btnlisten is the place holder to find a certain list for the occupants in a building.
	 * Person person is the place holder to hold the information of a person.
	 * JButton lastpressedbutton is the place holder to find what was the last pressed button.
	 */
	int idx;
	int btnlisten;
	Person person;
	JButton lastpressedbutton;
	
	/**
	 * These are the lists for each of the buildings that are created and are set to the corresponding place holders.
	 */
	JList<?> list_City_Hall = new JList<Object>(new Vector<Person>(buildings.get(0).occupants));
	JList<?> list_Elementary = new JList<Object>(new Vector<Person>(buildings.get(1).occupants));
	JList<?> list_Highschool = new JList<Object>(new Vector<Person>(buildings.get(2).occupants));
	JList<?> list_University = new JList<Object>(new Vector<Person>(buildings.get(3).occupants));
	JList<?> list_Mall = new JList<Object>(new Vector<Person>(buildings.get(4).occupants));
	JList<?> list_Bank = new JList<Object>(new Vector<Person>(buildings.get(5).occupants));
	JList<?> list_Population = new JList<Object>(new Vector<Person>(population));
	
	/**
	 * The Second_City function is the function for creating the interface.
	 */
	public Second_City() {
		/**
		 * Creating the frame.
		 */
			JFrame City = new JFrame("Spokane");
			City.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			City.setMinimumSize(new Dimension(600, 260));
			City.getContentPane().setLayout(new BorderLayout());
		
			/**
			 * Moving all the lists into an array to access them easier.
			 */
			JList[] Lists = {list_City_Hall, list_Elementary, list_Highschool, list_University, list_Mall, list_Bank, list_Population}; 
			
			/**
			 * Grabbing the images from resource and setting their size.
			 */
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			URL CH_img_url = getClass().getResource("/Resource/City_Hall.png");
			URL B_img_url = getClass().getResource("/Resource/Building.png");
			URL S_img_url = getClass().getResource("/Resource/School.png");
			Image CH_img = toolkit.getImage(CH_img_url);
			Image B_img = toolkit.getImage(B_img_url);
			Image S_img = toolkit.getImage(S_img_url);
			CH_img = CH_img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			B_img = B_img.getScaledInstance(50, 50,Image.SCALE_SMOOTH);
			S_img = S_img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
			ImageIcon CH_icon = new ImageIcon(CH_img);
			ImageIcon B_icon = new ImageIcon(B_img);
			ImageIcon S_icon = new ImageIcon(S_img);
			
			/**
			 * Panel_1 that holds the lists of occupants in a building, when first starting the program
			 * the list is blank until a button is pressed, this panel is located on border layout west.
			 */
			JPanel panel_1 = new JPanel();
			City.getContentPane().add(panel_1, BorderLayout.WEST);
			panel_1.setPreferredSize(new Dimension(125, 200));
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setPreferredSize(new Dimension(125, 200));
			panel_1.add(scrollPane);
			
			/**
			 * Panel_2 is located on border layout south.
			 */
			JPanel panel_2 = new JPanel();
			City.getContentPane().add(panel_2, BorderLayout.SOUTH);
			
			/**
			 * Panel_3 that holds the building information regarding address, name, and how many occupants in the building
			 * and person information regarding their wages, balance, name, age, phone number, police role, certification,
			 * and grade level, this panel is located on border layout east.
			 */
			JPanel panel_3 = new JPanel();
			panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
			panel_3.setPreferredSize(new Dimension(150, 200));
			City.getContentPane().add(panel_3, BorderLayout.EAST);
			JEditorPane OccupantPane = new JEditorPane();
			OccupantPane.setAlignmentY(TOP_ALIGNMENT);
			OccupantPane.setPreferredSize(new Dimension((int)65, 200));
			OccupantPane.setText(String.format("Population: %d", population.size()));
			panel_3.add(OccupantPane);
			JEditorPane InfoPane = new JEditorPane();
			InfoPane.setPreferredSize(new Dimension((int)65, 200));
			panel_3.add(InfoPane);
			
			/**
			 * Panel_4 that holds the buttons that correspond to each building that is in the city, this panel
			 * is located on border layout center.
			 */
			JPanel panel_4 = new JPanel();
			City.getContentPane().add(panel_4, BorderLayout.CENTER);
			panel_4.setPreferredSize(new Dimension(300,300));
		    
			/**
			 * payEmployees is a button that when clicked calls the payment function for every person that is in
			 * the city, that are either a policeman/women or a teacher. Then outputs the change in their balance to panel_3.
			 * This button is on panel_4.
			 */
		    JButton payEmployees = new JButton("Pay Employees");
		    payEmployees.setToolTipText("Pay the Employees");
		    payEmployees.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					for (Person p : population) {
						if (p instanceof Teacher) {
							((Teacher) p).payment();
						}
						else if (p instanceof Police) {
							((Police) p).payment();
						}
					}

					panel_3.removeAll();
		        	InfoPane.setText(buildings.get(btnlisten).occupants.get(idx).getInfo());
		        	OccupantPane.setText(String.format("%s\nOccupants: %d\n%s", buildings.get(btnlisten).getName(), buildings.get(btnlisten).occupants.size(), buildings.get(btnlisten).getAddress()));
		        	panel_3.add(OccupantPane);
		        	panel_3.add(InfoPane);
		        	panel_3.repaint();
		        	panel_3.revalidate();
				}
		    	
		    });
			
		    /**
		     * btnMove is a button that when clicked sets lastpressedbutton to itself. Then grabs the person that was selected
		     * from the occupancy list then sets it to person, then removes it from the list. This button is on panel_4.
		     */
			JButton btnMove = new JButton("Move");
			btnMove.setToolTipText("Move a Person");
			btnMove.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					btnMove.setEnabled(false);
					person = buildings.get(btnlisten).occupants.remove(idx);
					lastpressedbutton = (JButton) e.getSource();
				};	
			});
		      
			/**
			 * btnCITYHALL is a button that when clicked checks if the last button pressed was btnMove, if true, then grabs the
			 * list_City_Hall and adds person to the list, then sets lastpressedbutton to itself. If false, then sets panel_1
			 * to the list_City_Hall and shows the occupants of that list (building). Then sets panel_3 to displays the information 
			 * of each person in the building (when selected) and the information of the building itself. This button is on panel_4.
			 */
			JButton btnCITYHALL = new JButton(CH_icon);
			btnCITYHALL.setToolTipText(String.format("%s", buildings.get(0).getName()));
			btnCITYHALL.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (lastpressedbutton == btnMove) {
						btnlisten = 0;
						buildings.get(0).occupants.add(person);
						lastpressedbutton = (JButton) e.getSource();
						btnMove.setEnabled(true);
					}
					else {
					btnlisten = 0;
					panel_1.removeAll();
					panel_3.removeAll();
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane);
					scrollPane.setPreferredSize(new Dimension(125, 200));
					
					scrollPane.setViewportView(Lists[btnlisten]);
					Lists[btnlisten].setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    Lists[btnlisten].addListSelectionListener(new ListSelectionListener() {
				      public void valueChanged(ListSelectionEvent e) {
				        idx = Lists[btnlisten].getSelectedIndex();
				        if (idx != -1) {
				        	panel_3.removeAll();
				        	InfoPane.setText(buildings.get(btnlisten).occupants.get(idx).getInfo());
				        	OccupantPane.setText(String.format(" %s\n Occupants: %d\n %s\n", buildings.get(btnlisten).getName(), buildings.get(btnlisten).occupants.size(), buildings.get(btnlisten).getAddress()));
				        	panel_3.add(OccupantPane);
				        	panel_3.add(InfoPane);
				        	panel_3.repaint();
				        	panel_3.revalidate();
				        }
				      }
				    });
					
					Lists[btnlisten].setCellRenderer(new DefaultListCellRenderer() {
			            @Override
			            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			                if (renderer instanceof JLabel && value instanceof Person) {
			                    ((JLabel) renderer).setText(((Person) value).getName());
			                }
			                return renderer;
			            }
					 });
					
					OccupantPane.setText(String.format("%s\nOccupants: %d\n%s", buildings.get(btnlisten).getName(), buildings.get(btnlisten).occupants.size(), buildings.get(btnlisten).getAddress()));
					panel_3.add(OccupantPane);
					
					
					person = buildings.get(btnlisten).occupants.get(idx);
					panel_1.revalidate();
					panel_3.revalidate();
					panel_1.repaint();
					panel_3.repaint();
				}
				}
			});
			panel_4.add(btnCITYHALL);
			
			/**
			 * btnBUILDING1 is a button that when clicked checks if the last button pressed was btnMove, if true, then grabs the
			 * list_Mall and adds person to the list, then sets lastpressedbutton to itself. If false, then sets panel_1
			 * to the list_Mall and shows the occupants of that list (building). Then sets panel_3 to displays the information 
			 * of each person in the building (when selected) and the information of the building itself. This button is on panel_4.
			 */
			JButton btnBUILDING1 = new JButton(B_icon);
			btnBUILDING1.setToolTipText(String.format("%s", buildings.get(4).getName()));
			btnBUILDING1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (lastpressedbutton == btnMove){
						buildings.get(4).occupants.add(person);
						lastpressedbutton = (JButton) e.getSource();
						btnMove.setEnabled(true);
					}
					
					else {
					btnlisten = 4;
					panel_1.removeAll();
					panel_3.removeAll();
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane);
					scrollPane.setPreferredSize(new Dimension(125, 200));
					
					scrollPane.setViewportView(Lists[btnlisten]);
					Lists[btnlisten].setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    Lists[btnlisten].addListSelectionListener(new ListSelectionListener() {
				      public void valueChanged(ListSelectionEvent e) {
				        idx = Lists[btnlisten].getSelectedIndex();
				        if (idx != -1) {
				        	panel_3.removeAll();
				        	InfoPane.setText(buildings.get(btnlisten).occupants.get(idx).getInfo());
				        	OccupantPane.setText(String.format("%s\nOccupants: %d\n%s", buildings.get(btnlisten).getName(), buildings.get(btnlisten).occupants.size(), buildings.get(btnlisten).getAddress()));
				        	person = buildings.get(btnlisten).occupants.get(idx);
				        	panel_3.add(OccupantPane);
				        	panel_3.add(InfoPane);
				        	panel_3.repaint();
				        	panel_3.revalidate();
				        }
				      }
				    });
					
					Lists[btnlisten].setCellRenderer(new DefaultListCellRenderer() {
			            @Override
			            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			                if (renderer instanceof JLabel && value instanceof Person) {
			                    ((JLabel) renderer).setText(((Person) value).getName());
			                }
			                return renderer;
			            }
					 });
					OccupantPane.setText(String.format("%s\nOccupants: %d\n%s", buildings.get(btnlisten).getName(), buildings.get(btnlisten).occupants.size(), buildings.get(btnlisten).getAddress()));
					panel_3.add(OccupantPane);
					
					panel_1.revalidate();
					panel_3.revalidate();
					panel_1.repaint();
					panel_3.repaint();
				}
				}
			});
			panel_4.add(btnBUILDING1);
			
			/**
			 * btnBUILDING2 is a button that when clicked checks if the last button pressed was btnMove, if true, then grabs the
			 * list_Bank and adds person to the list, then sets lastpressedbutton to itself. If false, then sets panel_1
			 * to the list_Bank and shows the occupants of that list (building). Then sets panel_3 to displays the information 
			 * of each person in the building (when selected) and the information of the building itself. This button is on panel_4.
			 */
			JButton btnBUILDING2 = new JButton(B_icon);
			btnBUILDING2.setToolTipText(String.format("%s", buildings.get(5).getName()));
			btnBUILDING2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (lastpressedbutton == btnMove) {
						buildings.get(5).occupants.add(person);
						lastpressedbutton = (JButton) e.getSource();
						btnMove.setEnabled(true);
					}
					
					else {
					btnlisten = 5;
					panel_1.removeAll();
					panel_3.removeAll();
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane);
					scrollPane.setPreferredSize(new Dimension(125, 200));
			
					scrollPane.setViewportView(Lists[btnlisten]);
					Lists[btnlisten].setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    Lists[btnlisten].addListSelectionListener(new ListSelectionListener() {
				      public void valueChanged(ListSelectionEvent e) {
				        idx = Lists[btnlisten].getSelectedIndex();
				        if (idx != -1) {
				        	panel_3.removeAll();
				        	InfoPane.setText(buildings.get(btnlisten).occupants.get(idx).getInfo());
				        	OccupantPane.setText(String.format("%s\nOccupants: %d\n%s", buildings.get(btnlisten).getName(), buildings.get(btnlisten).occupants.size(), buildings.get(btnlisten).getAddress()));
				        	person = buildings.get(btnlisten).occupants.get(idx);
				        	panel_3.add(OccupantPane);
				        	panel_3.add(InfoPane);
				        	panel_3.repaint();
				        	panel_3.revalidate();
				        }
				      }
				    });
					
					Lists[btnlisten].setCellRenderer(new DefaultListCellRenderer() {
			            @Override
			            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			                if (renderer instanceof JLabel && value instanceof Person) {
			                    ((JLabel) renderer).setText(((Person) value).getName());
			                }
			                return renderer;
			            }
					 });
					OccupantPane.setText(String.format("%s\nOccupants: %d\n%s", buildings.get(btnlisten).getName(), buildings.get(btnlisten).occupants.size(), buildings.get(btnlisten).getAddress()));
					panel_3.add(OccupantPane);
					
					panel_1.revalidate();
					panel_3.revalidate();
					panel_1.repaint();
					panel_3.repaint();
				}
				}
			});
			panel_4.add(btnBUILDING2);
			
			/**
			 * btnSCHOOL1 is a button that when clicked checks if the last button pressed was btnMove, if true, then grabs the
			 * list_Elementary and adds person to the list, then sets lastpressedbutton to itself. If false, then sets panel_1
			 * to the list_Elementary and shows the occupants of that list (building). Then sets panel_3 to displays the information 
			 * of each person in the building (when selected) and the information of the building itself. This button is on panel_4.
			 */
			JButton btnSCHOOL1 = new JButton(S_icon);
			btnSCHOOL1.setToolTipText(String.format("%s", buildings.get(1).getName()));
			btnSCHOOL1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (lastpressedbutton == btnMove) {
						buildings.get(1).occupants.add(person);
						lastpressedbutton = (JButton) e.getSource();
						btnMove.setEnabled(true);
					}
					
					else {
					btnlisten = 1;
					panel_1.removeAll();
					panel_3.removeAll();
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane);
					scrollPane.setPreferredSize(new Dimension(125, 200));
					
					scrollPane.setViewportView(Lists[btnlisten]);
					Lists[btnlisten].setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    Lists[btnlisten].addListSelectionListener(new ListSelectionListener() {
				      public void valueChanged(ListSelectionEvent e) {
				        idx = Lists[btnlisten].getSelectedIndex();
				        if (idx != -1) {
				        	panel_3.removeAll();
				        	InfoPane.setText(buildings.get(btnlisten).occupants.get(idx).getInfo());
				        	OccupantPane.setText(String.format("%s\nOccupants: %d\n%s", buildings.get(btnlisten).getName(), buildings.get(btnlisten).occupants.size(), buildings.get(btnlisten).getAddress()));
				        	person = buildings.get(btnlisten).occupants.get(idx);
				        	panel_3.add(OccupantPane);
				        	panel_3.add(InfoPane);
				        	panel_3.repaint();
				        	panel_3.revalidate();
				        }
				      }
				    });
					
					Lists[btnlisten].setCellRenderer(new DefaultListCellRenderer() {
			            @Override
			            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			                if (renderer instanceof JLabel && value instanceof Person) {
			                    ((JLabel) renderer).setText(((Person) value).getName());
			                }
			                return renderer;
			            }
					 });
					OccupantPane.setText(String.format("%s\nOccupants: %d\n%s", buildings.get(btnlisten).getName(), buildings.get(btnlisten).occupants.size(), buildings.get(btnlisten).getAddress()));
					panel_3.add(OccupantPane);
					
					panel_1.revalidate();
					panel_3.revalidate();
					panel_1.repaint();
					panel_3.repaint();
				}
				}
			});
			panel_4.add(btnSCHOOL1);
			
			/**
			 * btnSCHOOL2 is a button that when clicked checks if the last button pressed was btnMove, if true, then grabs the
			 * list_Highschool and adds person to the list, then sets lastpressedbutton to itself. If false, then sets panel_1
			 * to the list_Highschool and shows the occupants of that list (building). Then sets panel_3 to displays the information 
			 * of each person in the building (when selected) and the information of the building itself. This button is on panel_4.
			 */
			JButton btnSCHOOL2 = new JButton(S_icon);
			btnSCHOOL2.setToolTipText(String.format("%s", buildings.get(2).getName()));
			btnSCHOOL2.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (lastpressedbutton == btnMove) {
						buildings.get(2).occupants.add(person);
						lastpressedbutton = (JButton) e.getSource();
						btnMove.setEnabled(true);
					}
					
					else {
					btnlisten = 2;
					panel_1.removeAll();
					panel_3.removeAll();
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane);
					scrollPane.setPreferredSize(new Dimension(125, 200));
					
					scrollPane.setViewportView(Lists[btnlisten]);
					Lists[btnlisten].setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    Lists[btnlisten].addListSelectionListener(new ListSelectionListener() {
				      public void valueChanged(ListSelectionEvent e) {
				        idx = Lists[btnlisten].getSelectedIndex();
				        if (idx != -1) {
				        	panel_3.removeAll();
				        	InfoPane.setText(buildings.get(btnlisten).occupants.get(idx).getInfo());
				        	OccupantPane.setText(String.format("%s\nOccupants: %d\n%s", buildings.get(btnlisten).getName(), buildings.get(btnlisten).occupants.size(), buildings.get(btnlisten).getAddress()));
				        	person = buildings.get(btnlisten).occupants.get(idx);
				        	panel_3.add(OccupantPane);
				        	panel_3.add(InfoPane);
				        	panel_3.repaint();
				        	panel_3.revalidate();
				        }
				      }
				    });
					
					Lists[btnlisten].setCellRenderer(new DefaultListCellRenderer() {
			            @Override
			            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			                if (renderer instanceof JLabel && value instanceof Person) {
			                    ((JLabel) renderer).setText(((Person) value).getName());
			                }
			                return renderer;
			            }
					 });
					OccupantPane.setText(String.format("%s\nOccupants: %d\n%s", buildings.get(btnlisten).getName(), buildings.get(btnlisten).occupants.size(), buildings.get(btnlisten).getAddress()));
					panel_3.add(OccupantPane);
					
					panel_1.revalidate();
					panel_3.revalidate();
					panel_1.repaint();
					panel_3.repaint();
				}
				}
			});
			panel_4.add(btnSCHOOL2);
			
			/**
			 * btnSCHOOL3 is a button that when clicked checks if the last button pressed was btnMove, if true, then grabs the
			 * list_University and adds person to the list, then sets lastpressedbutton to itself. If false, then sets panel_1
			 * to the list_University and shows the occupants of that list (building). Then sets panel_3 to displays the information 
			 * of each person in the building (when selected) and the information of the building itself. This button is on panel_4.
			 */
			JButton btnSCHOOL3 = new JButton(S_icon);
			btnSCHOOL3.setToolTipText(String.format("%s", buildings.get(3).getName()));
			btnSCHOOL3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (lastpressedbutton == btnMove) {
						buildings.get(3).occupants.add(person);
						lastpressedbutton = (JButton) e.getSource();
						btnMove.setEnabled(true);
					}
					
					else {
					btnlisten = 3;
					panel_1.removeAll();
					panel_3.removeAll();
					JScrollPane scrollPane = new JScrollPane();
					panel_1.add(scrollPane);
					scrollPane.setPreferredSize(new Dimension(125, 200));
					
					scrollPane.setViewportView(Lists[btnlisten]);
					Lists[btnlisten].setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				    Lists[btnlisten].addListSelectionListener(new ListSelectionListener() {
				      public void valueChanged(ListSelectionEvent e) {
				        idx = Lists[btnlisten].getSelectedIndex();
				        if (idx != -1) {
				        	panel_3.removeAll();
				        	InfoPane.setText(buildings.get(btnlisten).occupants.get(idx).getInfo());
				        	OccupantPane.setText(String.format("%s\nOccupants: %d\n%s", buildings.get(btnlisten).getName(), buildings.get(btnlisten).occupants.size(), buildings.get(btnlisten).getAddress()));
				        	person = buildings.get(btnlisten).occupants.get(idx);
				        	panel_3.add(OccupantPane);
				        	panel_3.add(InfoPane);
				        	panel_3.repaint();
				        	panel_3.revalidate();
				        }
				      }
				    });
					
					Lists[btnlisten].setCellRenderer(new DefaultListCellRenderer() {
			            @Override
			            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
			                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
			                if (renderer instanceof JLabel && value instanceof Person) {
			                    ((JLabel) renderer).setText(((Person) value).getName());
			                }
			                return renderer;
			            }
					 });
					OccupantPane.setText(String.format("%s\nOccupants: %d\n%s", buildings.get(btnlisten).getName(), buildings.get(btnlisten).occupants.size(), buildings.get(btnlisten).getAddress()));
					panel_3.add(OccupantPane);
					
					panel_1.revalidate();
					panel_3.revalidate();
					panel_1.repaint();
					panel_3.repaint();
				}
				}

			});
			panel_4.add(btnSCHOOL3);
			
			/**
			 * Adds btnMove and payEmployees to panel_4 and sets it so they are aligned in a certain way. then set the frame visibility
			 * to true.
			 */
			panel_4.add(btnMove);
			panel_4.add(payEmployees);
			btnMove.setAlignmentY(CENTER_ALIGNMENT);
			payEmployees.setAlignmentY(LEFT_ALIGNMENT);
			City.setVisible(true);
	}
}