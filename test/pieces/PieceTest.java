package pieces;

import junit.framework.TestCase;

public class PieceTest extends TestCase {
	public void testCreate() {
		verifyCreation(Piece.createPawn(Piece.Color.WHITE), Piece.createPawn(Piece.Color.BLACK), Piece.Type.PAWN, Piece.PAWN_REPRESENTATION);
		verifyCreation(Piece.createRook(Piece.Color.WHITE), Piece.createRook(Piece.Color.BLACK), Piece.Type.ROOK, Piece.ROOK_REPRESENTATION);
		verifyCreation(Piece.createKnight(Piece.Color.WHITE), Piece.createKnight(Piece.Color.BLACK), Piece.Type.KNIGHT, Piece.KNIGHT_REPRESENTATION);
		verifyCreation(Piece.createBishop(Piece.Color.WHITE), Piece.createBishop(Piece.Color.BLACK), Piece.Type.BISHOP, Piece.BISHOP_REPRESENTATION);
		verifyCreation(Piece.createQueen(Piece.Color.WHITE), Piece.createQueen(Piece.Color.BLACK), Piece.Type.QUEEN, Piece.QUEEN_REPRESENTATION);
		verifyCreation(Piece.createKing(Piece.Color.WHITE), Piece.createKing(Piece.Color.BLACK), Piece.Type.KING, Piece.KING_REPRESENTATION);
		
		Piece blank = Piece.noPiece();
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
}
