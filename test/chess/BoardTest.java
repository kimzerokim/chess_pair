package chess;

import pieces.Pawn;
import chess.Board;
import junit.framework.TestCase;

public class BoardTest extends TestCase {
	Board board;
	
	protected void setUp() throws Exception {
		board = new Board();
	}
	
	public void testCreate() {
		assertNotNull(board);
	}
	
	public void testAddPawns() {
		Pawn pawn1 = new Pawn();
		board.addPawn(pawn1);
		assertEquals(1, board.getPawnNumber());
		assertEquals(pawn1, board.getPawn(0));
	}
}
