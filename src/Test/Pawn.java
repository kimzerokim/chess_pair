package Test;

public class Pawn {
	final String PAWN_WHITE = "white";
	final String PAWN_BLACK = "black";
	
	private String color;
	
	public Pawn() {
		this.color = "white";
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
}
