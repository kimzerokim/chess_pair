package pieces;

public class Piece {
	public static final char BLANK_REPRESENTATION = '.';
	public static final char PAWN_REPRESENTATION = 'p';
	public static final char ROOK_REPRESENTATION = 'r';
	public static final char KNIGHT_REPRESENTATION = 'n';
	public static final char BISHOP_REPRESENTATION = 'b';
	public static final char QUEEN_REPRESENTATION = 'q';
	public static final char KING_REPRESENTATION = 'k';
	
	public enum Color 	{WHITE, BLACK, BLANK}
	public enum Type 	{ROOK, KNIGHT, BISHOP, QUEEN, KING, PAWN, NO_PIECE}
	
	private final Color color;
	private final Type type;
	
	private Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
	}
	
	public static Piece noPiece() {
		return new Piece(Color.BLANK, Type.NO_PIECE);
	}
	
	public static Piece createPawn(Color color) {
		return new Piece(color, Type.PAWN);
	}
	
	public static Piece createRook(Color color) {
		return new Piece(color, Type.ROOK);
	}
	
	public static Piece createKnight(Color color) {
		return new Piece(color, Type.KNIGHT);
	}
	
	public static Piece createBishop(Color color) {
		return new Piece(color, Type.BISHOP);
	}
	
	public static Piece createQueen(Color color) {
		return new Piece(color, Type.QUEEN);
	}
	
	public static Piece createKing(Color color) {
		return new Piece(color, Type.KING);
	}
	
	public Color getColor() {
		return color;
	}
	
	public Type getType() {
		return type;
	}
	
	public char getRepresentation() {
		char c = ' ';
		switch (type) {
		case PAWN: 		c = 'p'; 	break;
		case KNIGHT:	c = 'n';	break;
		case ROOK:		c = 'r';	break;
		case BISHOP:	c = 'b';	break;
		case QUEEN:		c = 'q';	break;
		case KING:		c = 'k';	break;
		default:		c = '.';	break;
		}
		
		if (color == Color.WHITE)
			return Character.toUpperCase(c);
		else
			return c;
	}
	
	public boolean isWhite() {
		return (color == Color.WHITE) ? true : false;
	}
	
	public boolean isBlack() {
		return (color == Color.BLACK) ? true : false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	public boolean equals(Piece piece) {
		if (this == piece)
			return true;
		if (piece == null)
			return false;
		if (getClass() != piece.getClass())
			return false;
		Piece other =  piece;
		if (color != other.color)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
