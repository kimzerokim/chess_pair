package pieces;

public class Pawn {
	public static final String PAWN_BLANK = " ";
	public static final String PAWN_WHITE = "white";
	public static final String PAWN_BLACK = "black";
	
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
	
	@Override
	public String toString() {
		return color == PAWN_WHITE ? "p" : "P";
	}
}
