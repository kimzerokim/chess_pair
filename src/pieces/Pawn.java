package pieces;

public class Pawn {
	public static final String PAWN_BLANK = " ";
	public static final String PAWN_WHITE = "white";
	public static final String PAWN_BLACK = "black";
	
	private String color;
	
	public Pawn() {
		this.color = PAWN_WHITE;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}
	
	@Override
	public String toString() {
		switch (color) {
		case PAWN_WHITE:
			return "p";
			
		case PAWN_BLACK:
			return "P";
			
		case PAWN_BLANK:
		default:
			return ".";
		}
	}
}
