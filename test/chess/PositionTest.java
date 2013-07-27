package chess;

import junit.framework.TestCase;

public class PositionTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testPosition() throws Exception {
		String pos = "a8";
		assertEquals(0, Position.getX(pos));
		assertEquals(7, Position.getY(pos));
	}
}
