package Test;

import junit.framework.TestCase;

public class PawnTest extends TestCase {
	public void testCreate(){
		final String white = "white";
		final String black = "black";
		
		Pawn pawn1 = new Pawn();
		pawn1.setColor(white);
		assertEquals(white, pawn1.getColor());
		
		Pawn pawn2 = new Pawn();
		pawn2.setColor(black);
		assertEquals(black, pawn2.getColor());
	}
}
