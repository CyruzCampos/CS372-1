import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Shapes> Shape = new ArrayList<Shapes>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		add_shapes();
		Interface i = new Interface();
	}

	public static void add_shapes() {
		String type = null;
		String info = null;
		String id = null;
		String color = null;
		try (FileInputStream is = new FileInputStream ("src\\Resource\\shapes.txt")) {
				InputStreamReader ir = new InputStreamReader(is);
				BufferedReader rdr = new BufferedReader(ir);
				String line = rdr.readLine();
				while (line != null) {
					String[] parts = line.split(" ");
					for (String p : parts) {
						
						//adding type
						if (p.length() > 0 && p.startsWith("cir")){
							type = String.format("%s", p);
						}
						
						if (p.length() > 0 && p.startsWith("squ")){
							type = String.format("%s", p);
						}
						
						if (p.length() > 0 && p.startsWith("rec")){
							type = String.format("%s", p);
						}
						
						if (p.length() > 0 && p.startsWith("tri")){
							type = String.format("%s", p);
						}
						
						//adding id
						if (p.length() > 0 && p.matches("\\d{3}")) {
							id = String.format("%s", p);
						}
						
						if (p.length() > 0 && p.matches("\\d{2}")) {
							id = String.format("%s", p);
						}
						
						//adding color
						if (p.length() > 0 && p.startsWith("yel")){
							color = String.format("%s", p);
						}
						
						if (p.length() > 0 && p.startsWith("gre")){
							color = String.format("%s", p);
						}
						
						if (p.length() > 0 && p.startsWith("red")){
							color = String.format("%s", p);
						}
						
						if (p.length() > 0 && p.startsWith("bla")){
							color = String.format("%s", p);
						}
						
						if (p.length() > 0 && p.startsWith("blu")){
							color = String.format("%s", p);
						}
						
						//adding to a shape
						Shape.add(new Shapes(type, info, id, color));
						
					}
					line = rdr.readLine();
				}
				
			}
			catch (Exception ex) {
				System.out.printf ("Failed for %s\n", "shapes.txt");
			}
	}
	
}
