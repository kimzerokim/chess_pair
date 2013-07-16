package chess;

import chess.Pawn;
import junit.framework.TestCase;

public class PawnTest extends TestCase {
	public void testCreate(){
		Pawn pawn1 = new Pawn();
		pawn1.setColor("white");
		assertEquals(pawn1.PAWN_WHITE, pawn1.getColor());
		
		Pawn pawn2 = new Pawn();
		pawn2.setColor("black");
		assertEquals(pawn2.PAWN_BLACK, pawn2.getColor());
	}
}

