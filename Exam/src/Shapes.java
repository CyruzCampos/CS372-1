import java.util.*;

public class Shapes {

	private String type;
	private String info;
	private String id;
	private String color;
	@SuppressWarnings("unused")
	private ArrayList<Shapes> Shape = new ArrayList<Shapes>();
	
	public Shapes(String type, String info, String id, String color) {
		this.type = type;
		this.info = info;
		this.id = id;
		this.color = color;
	}
	
	public String getType() {
		return type;
	}
	
	public String getInfo() {
		return info;
	}
	
	public String getId() {
		return id;
	}
	
	public String getColor() {
		return color;
	}
}
