package pieces;

public class Piece {
	public static final String BLANK = " ";
	
	public enum Color {WHITE, BLACK, BLANK}
	
	private final Color color;
	private final String name;
	
	private Piece(Color color, String name) {
		this.color = color;
		this.name = name;
	}
	
	public static Piece create(Color color, String name) {
		return new Piece(color, name);
	}
	
	public Color getColor() {
		return color;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isWhite() {
		return (color == Color.WHITE) ? true : false;
	}
	
	public boolean isBlack() {
		return (color == Color.BLACK) ? true : false;
	}
	
	@Override
	public String toString() {
		String retStr = ".";

		switch (name) {
		case "pawn": 	retStr = "p"; 	break;
		case "knight":	retStr = "n";	break;
		case "rook":	retStr = "r";	break;
		case "bishop":	retStr = "b";	break;
		case "queen":	retStr = "q";	break;
		case "king":	retStr = "k";	break;
		}
		
		switch (color) {
		case WHITE:
			return retStr.toUpperCase();
			
		case BLACK:
			return retStr.toLowerCase();
			
		case BLANK:
		default:
			return retStr;
		}
	}
}
