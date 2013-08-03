package pieces;

public abstract class Piece {
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
	
	protected final Color color;
	protected final Type type;
	protected final char representation;
	
	protected String position;
	
	protected Piece(Color color, Type type, char representation) {
		this.color = color;
		this.type = type;
		this.representation = representation;
	}
	
	public static Piece createNoPiece() {
		return new NoPiece(Color.BLANK, Type.NO_PIECE, BLANK_REPRESENTATION);
	}
	
	public static Piece createPawn(Color color) {
		return new Pawn(color, Type.PAWN, PAWN_REPRESENTATION);
	}
	
	public static Piece createRook(Color color) {
		return new Rook(color, Type.ROOK, ROOK_REPRESENTATION);
	}
	
	public static Piece createKnight(Color color) {
		return new Knight(color, Type.KNIGHT, KNIGHT_REPRESENTATION);
	}
	
	public static Piece createBishop(Color color) {
		return new Bishop(color, Type.BISHOP, BISHOP_REPRESENTATION);
	}
	
	public static Piece createQueen(Color color) {
		return new Queen(color, Type.QUEEN, QUEEN_REPRESENTATION);
	}
	
	public static Piece createKing(Color color) {
		return new King(color, Type.KING, KING_REPRESENTATION);
	}
	
	public Color getColor() {
		return color;
	}
	
	public Type getType() {
		return type;
	}
	
	public Piece setPosition(String position) {
		this.position = position;
		return this;
	}

	public String getPosition() {
		return position;
	}
	
	public char getRepresentation() {
		if (color == Color.WHITE)
			return Character.toUpperCase(representation);
		else
			return representation;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Piece other = (Piece) obj;
		if (color != other.color)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
}
