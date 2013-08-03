package pieces;

public class Piece {
	public static final char BLANK_REPRESENTATION = '.';
	public static final char PAWN_REPRESENTATION = 'p';
	public static final char ROOK_REPRESENTATION = 'r';
	public static final char KNIGHT_REPRESENTATION = 'n';
	public static final char BISHOP_REPRESENTATION = 'b';
	public static final char QUEEN_REPRESENTATION = 'q';
	public static final char KING_REPRESENTATION = 'k';

	public enum Color {WHITE, BLACK, BLANK}
	public enum Type {
		ROOK(5.0), KNIGHT(2.5), BISHOP(3.0), QUEEN(9.0), KING(0.0), PAWN(1.0), NO_PIECE(0.0);
		
		private double score=0.0;
		
		Type(double score) {
			this.score = score;
		}
		
		double getScore() {
			return score;
		}
	}
	
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
	
	public double getScore() {
		return type.getScore();
	}
}
