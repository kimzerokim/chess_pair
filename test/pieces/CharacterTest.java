package pieces;

import junit.framework.TestCase;

public class CharacterTest extends TestCase {
	public void testWhiteSpace() throws Exception {
		assertTrue(Character.isWhitespace('\n'));
		assertTrue(Character.isWhitespace('\t'));
		assertTrue(Character.isWhitespace(' '));
	}
}
