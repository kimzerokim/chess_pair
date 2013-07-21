package chess;

import pieces.Pawn;
import chess.Board;
import junit.framework.TestCase;

public class BoardTest extends TestCase {
	Board board;
	
	@Override
	protected void setUp() throws Exception {
		board = new Board();
		super.setUp();
	}
	
	public void testCreate() {
		assertNotNull(board);
		assertEquals(16, board.getPawnNumber());
	}
	
	public void testAddPawns() {
		//Pawn pawn1 = new Pawn();
		//board.addPawn(pawn1);
		//assertEquals(1, board.getPawnNumber());
		//assertEquals(pawn1, board.getPawn(0));
	}
	
	public void testPawnsNumber() {
		assertEquals(16, board.getPawnNumber());
	}
	
	public void testRows() {
		assertEquals("pppppppp", board.getRow(1));
		assertEquals("PPPPPPPP", board.getRow(6));
	}
	
	public void testPrintBoard() {
		String dot = "........";
		String white = "pppppppp";
		String black = "PPPPPPPP";
		assertEquals(dot, board.getRow(0));
		assertEquals(white, board.getRow(1));
		assertEquals(dot, board.getRow(2));
		assertEquals(dot, board.getRow(3));
		assertEquals(dot, board.getRow(4));
		assertEquals(dot, board.getRow(5));
		assertEquals(black, board.getRow(6));
		assertEquals(dot, board.getRow(7));
		board.print();
	}
}
