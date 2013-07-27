package pieces;

public class Piece {
	public static final String BLANK = " ";
	
	public enum Color 	{WHITE, BLACK, BLANK}
	public enum Type 	{ROOK, KNIGHT, BISHOP, QUEEN, KING, PAWN, EMPTY}
	
	private final Color color;
	private final Type type;
	
	private Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
	}
	
	public static Piece create(Color color, Type type) {
		return new Piece(color, type);
	}
	
	public Color getColor() {
		return color;
	}
	
	public Type getType() {
		return type;
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

		switch (type) {
		case PAWN: 		retStr = "p"; 	break;
		case KNIGHT:	retStr = "n";	break;
		case ROOK:		retStr = "r";	break;
		case BISHOP:	retStr = "b";	break;
		case QUEEN:		retStr = "q";	break;
		case KING:		retStr = "k";	break;
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
