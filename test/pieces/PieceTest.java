package pieces;

import junit.framework.TestCase;
import pieces.Piece.Color;
import chess.Board;

public class PieceTest extends TestCase {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testCreate() {
		verifyCreation(Piece.createPawn(Piece.Color.WHITE), Piece.createPawn(Piece.Color.BLACK), Piece.Type.PAWN, Piece.PAWN_REPRESENTATION);
		verifyCreation(Piece.createRook(Piece.Color.WHITE), Piece.createRook(Piece.Color.BLACK), Piece.Type.ROOK, Piece.ROOK_REPRESENTATION);
		verifyCreation(Piece.createKnight(Piece.Color.WHITE), Piece.createKnight(Piece.Color.BLACK), Piece.Type.KNIGHT, Piece.KNIGHT_REPRESENTATION);
		verifyCreation(Piece.createBishop(Piece.Color.WHITE), Piece.createBishop(Piece.Color.BLACK), Piece.Type.BISHOP, Piece.BISHOP_REPRESENTATION);
		verifyCreation(Piece.createQueen(Piece.Color.WHITE), Piece.createQueen(Piece.Color.BLACK), Piece.Type.QUEEN, Piece.QUEEN_REPRESENTATION);
		verifyCreation(Piece.createKing(Piece.Color.WHITE), Piece.createKing(Piece.Color.BLACK), Piece.Type.KING, Piece.KING_REPRESENTATION);
		
		Piece blank = Piece.createNoPiece();
		assertEquals('.', blank.getRepresentation());
		assertEquals(Piece.Type.NO_PIECE, blank.getType());
	}

	private void verifyCreation(Piece whitePiece, Piece blackPiece, Piece.Type type, char representation) {
		assertTrue(whitePiece.isWhite());
		assertEquals(type, whitePiece.getType());
		assertEquals(Character.toUpperCase(representation), whitePiece.getRepresentation());
		assertTrue(blackPiece.isBlack());
		assertEquals(type, blackPiece.getType());
		assertEquals(representation, blackPiece.getRepresentation());
	}
	
	public void testSetPosition() throws Exception {
		final String positionA5 = "a5";
		verifyPiecePosition(Piece.createBishop(Color.WHITE), Piece.createBishop(Color.BLACK), positionA5);
		verifyPiecePosition(Piece.createKing(Color.WHITE), Piece.createKing(Color.BLACK), positionA5);
		verifyPiecePosition(Piece.createKnight(Color.WHITE), Piece.createKnight(Color.BLACK), positionA5);
		verifyPiecePosition(Piece.createPawn(Color.WHITE), Piece.createPawn(Color.BLACK), positionA5);
		verifyPiecePosition(Piece.createQueen(Color.WHITE), Piece.createQueen(Color.BLACK), positionA5);
		verifyPiecePosition(Piece.createRook(Color.WHITE), Piece.createRook(Color.BLACK), positionA5);
	}
	
	private void verifyPiecePosition(Piece whitePiece, Piece blackPiece, String position) {
		whitePiece.setPosition(position);
		assertEquals(position, whitePiece.getPosition());
		blackPiece.setPosition(position);
		assertEquals(position, blackPiece.getPosition());
	}
}
