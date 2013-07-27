package chess;

import junit.framework.TestCase;
import pieces.Piece;

public class BoardTest extends TestCase {
	private static final String WHITE_PAWN_ROW = "pppppppp";
	private static final String BLACK_PAWN_ROW = "PPPPPPPP";
	Board board;
	
	@Override
	protected void setUp() throws Exception {
		board = new Board();
		super.setUp();
	}
	
	public void testAddPawns() {
		//Pawn pawn1 = new Pawn();
		//board.addPawn(pawn1);
		//assertEquals(1, board.getPawnNumber());
		//assertEquals(pawn1, board.getPawn(0));
	}
	
	public void testRows() {
		assertEquals(BLACK_PAWN_ROW, board.getRow(1));
		assertEquals(WHITE_PAWN_ROW, board.getRow(6));
	}
	
	public void testPrintBoard() {
		String dot = "........";
		assertEquals("RNBQKBNR", board.getRow(0));
		assertEquals(BLACK_PAWN_ROW, board.getRow(1));
		assertEquals(dot, board.getRow(2));
		assertEquals(dot, board.getRow(3));
		assertEquals(dot, board.getRow(4));
		assertEquals(dot, board.getRow(5));
		assertEquals(WHITE_PAWN_ROW, board.getRow(6));
		assertEquals("rnbqkbnr", board.getRow(7));
		board.print();
	}
	
	public void testGetPiecesCount() throws Exception {
		Piece piece = Piece.createPawn(Piece.Color.BLACK);
		assertEquals(8, board.getCount(piece));
		Piece piece2 = Piece.createQueen(Piece.Color.WHITE);
		assertEquals(1, board.getCount(piece2));
	}
}
