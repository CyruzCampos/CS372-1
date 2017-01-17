import java.awt.*;
import java.net.URL;
import java.util.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Interface extends Main{
	
	JList<Object> List_Shape = new JList<Object>(new Vector<Shapes>(Shape));
	
	public Interface() {
		
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		URL C_url = getClass().getResource("/Resource/Circle.jpg");
		URL R_url = getClass().getResource("/Resource/Rectangle.jpg");
		URL S_url = getClass().getResource("/Resource/Square.jpg");
		URL T_url = getClass().getResource("/Resource/Triangle.jpg");
		Image C_img = toolkit.getImage(C_url);
		Image R_img = toolkit.getImage(R_url);
		Image S_img = toolkit.getImage(S_url);
		Image T_img = toolkit.getImage(T_url);
		C_img = C_img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		R_img = R_img.getScaledInstance(200, 200,Image.SCALE_SMOOTH);
		S_img = S_img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		T_img = T_img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		ImageIcon C_icon = new ImageIcon(C_img);
		ImageIcon R_icon = new ImageIcon(R_img);
		ImageIcon S_icon = new ImageIcon(S_img);
		ImageIcon T_icon = new ImageIcon(T_img);
		
		
		JFrame Shaped = new JFrame("Shapes");
		Shaped.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Shaped.setMinimumSize(new Dimension(600, 260));
		Shaped.getContentPane().setLayout(new BorderLayout());
		
		JPanel panel_1 = new JPanel();
		Shaped.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setPreferredSize(new Dimension(125, 200));
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(125, 200));
		scrollPane.setViewportView(List_Shape);
		panel_1.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		panel_3.setPreferredSize(new Dimension(150, 200));
		Shaped.getContentPane().add(panel_3, BorderLayout.EAST);
		JEditorPane InfoPane = new JEditorPane();
		InfoPane.setPreferredSize(new Dimension((int)65, 200));
		panel_3.add(InfoPane);
		
		JPanel panel_4 = new JPanel();
		Shaped.getContentPane().add(panel_4, BorderLayout.CENTER);
		panel_4.setPreferredSize(new Dimension(300,300));
		
		List_Shape.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (renderer instanceof JLabel && value instanceof Shape) {
                    ((JLabel) renderer).setText(((Shapes) value).getType());
                }
                return renderer;
            }
		 });
		
		List_Shape.addListSelectionListener(new ListSelectionListener() {
		      public void valueChanged(ListSelectionEvent e) {
		        int idx = List_Shape.getSelectedIndex();
		        if (idx != -1) {
		        	panel_3.removeAll();
		        	panel_4.removeAll();
		        	
		        	InfoPane.setText(String.format("%s\n %s\n %s\n %s\n", Shape.get(idx).getId(), Shape.get(idx).getType(), Shape.get(idx).getColor(), Shape.get(idx).getInfo()));
		        	
		        	//if (Shape.get(idx).getType() == "circle") {
		        		JLabel images = new JLabel("", C_icon, JLabel.CENTER);
		        		panel_4.add(images, BorderLayout.CENTER);
		        	//}
		        	
		        	panel_3.add(InfoPane);
		        	
		        	panel_3.repaint();
		        	panel_4.repaint();
		        	panel_3.revalidate();
		        	panel_4.revalidate();
		        }
		      }
		    });
		
		Shaped.setVisible(true);
	}
}
