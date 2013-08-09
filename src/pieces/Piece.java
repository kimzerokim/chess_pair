package pieces;

import java.util.*;

public class Piece implements Comparable<Piece>{
	
	/**
	 * REPRESENTATION 의 경우, 모두 소문자로 만든 후 필요에 의해 대문자로 변경해준다. (toUpperCase)
	 */	
	public static final char BLANK_REPRESENTATION = '.';
	public static final char PAWN_REPRESENTATION = 'p';
	public static final char ROOK_REPRESENTATION = 'r';
	public static final char KNIGHT_REPRESENTATION = 'n';
	public static final char BISHOP_REPRESENTATION = 'b';
	public static final char QUEEN_REPRESENTATION = 'q';
	public static final char KING_REPRESENTATION = 'k';

	public enum Color {WHITE, BLACK, BLANK}
	public enum Type {
		KING, QUEEN, ROOK, BISHOP, KNIGHT, PAWN, NO_PIECE }
	
	public Map<Piece.Type, Double> pieces = null;
	// 초기 구현에서 Map을 사용하지 않았다. 
	/*
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
	
	*/
	
	private final Color color;
	private final Type type;
	private String position;
	
	protected Piece(Color color, Type type) {
		this.color = color;
		this.type = type;
	}
	
	protected Piece(Color color, Type type, String position) {
		this.color = color;
		this.type = type;
		this.position = position;
	}
	
	public Piece clone() {
		Piece retPiece = Piece.createKing(Color.WHITE);
		return retPiece;
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
		return new Queen(color);
	}
	
	public static Piece createKing(Color color) {
		return new King(color);
	}
	
	/*
	 * Main: Piece piece = Piece.createKing(White);
	 */
	
	public double getScore(Type type) {
		return getScores().get(type);
	}
	
	private Map<Piece.Type, Double> getScores() {
		if (pieces == null)
			loadPieceInfo();
		return pieces;
	}
	
	private void loadPieceInfo() {
		pieces = new EnumMap<Piece.Type, Double>(Piece.Type.class);
		pieces.put(Piece.Type.KING, 0.0);
		pieces.put(Piece.Type.QUEEN, 9.0);
		pieces.put(Piece.Type.ROOK, 5.0);
		pieces.put(Piece.Type.BISHOP, 3.0);
		pieces.put(Piece.Type.KNIGHT, 2.5);
		pieces.put(Piece.Type.PAWN, 1.0);
		pieces.put(Piece.Type.NO_PIECE, 0.0);		
	}
	
	public Color getColor() {
		return color;
	}
	
	public Type getType() {
		return type;
	}
	
	public String getPosition() {
		return position;
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
		
		if (color == Color.BLACK)
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

	public void getPossibleMoves() {
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

//	@Override
//	public int compareTo(Piece that) {
//		int compare = 
//				Integer.parseInt(String.valueOf(Math.round(
//						that.getScore(that.getType()) - this.getScore(this.getType()))));
//		return compare;
//	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public int compareTo(Piece o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
