package pieces;

import junit.framework.TestCase;

public class PieceTest extends TestCase {
	public void testCreate() {
		Piece pawn1 = Piece.create(Piece.Color.WHITE, Piece.Type.PAWN);
		assertEquals(Piece.Color.WHITE, pawn1.getColor());
		assertEquals("P", pawn1.toString());
		assertEquals(Piece.Type.PAWN, pawn1.getType());

		Piece pawn2 = Piece.create(Piece.Color.BLACK, Piece.Type.PAWN);
		assertEquals(Piece.Color.BLACK, pawn2.getColor());
		assertEquals("p", pawn2.toString());
		assertEquals(Piece.Type.PAWN, pawn2.getType());
	}

	public void testColor() throws Exception {
		Piece whitePawn = Piece.create(Piece.Color.WHITE, Piece.Type.PAWN);
		assertTrue(whitePawn.isWhite());
		assertFalse(whitePawn.isBlack());

		Piece blackPawn = Piece.create(Piece.Color.BLACK, Piece.Type.PAWN);
		assertTrue(blackPawn.isBlack());
		assertFalse(blackPawn.isWhite());
	}
}
