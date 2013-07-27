package pieces;

import junit.framework.TestCase;

public class PieceTest extends TestCase {
	public void testCreate() {
		Piece pawn1 = Piece.create(Piece.Color.WHITE, "pawn");
		assertEquals(Piece.Color.WHITE, pawn1.getColor());
		assertEquals("P", pawn1.toString());
		assertEquals("pawn", pawn1.getName());

		Piece pawn2 = Piece.create(Piece.Color.BLACK, "pawn");
		assertEquals(Piece.Color.BLACK, pawn2.getColor());
		assertEquals("p", pawn2.toString());
		assertEquals("pawn", pawn2.getName());
	}

	public void testColor() throws Exception {
		Piece whitePawn = Piece.create(Piece.Color.WHITE, "pawn");
		assertTrue(whitePawn.isWhite());
		assertFalse(whitePawn.isBlack());

		Piece blackPawn = Piece.create(Piece.Color.BLACK, "pawn");
		assertTrue(blackPawn.isBlack());
		assertFalse(blackPawn.isWhite());
	}
}
