package chess;

import junit.framework.TestCase;
import pieces.Piece;
import pieces.Piece.Color;

public class BoardTest extends TestCase {
	private static final String WHITE_PAWN_ROW = "PPPPPPPP";
	private static final String BLACK_PAWN_ROW = "pppppppp";
	Board board;
	
	@Override
	protected void setUp() throws Exception {
		board = new Board();
		board.initialize();
		super.setUp();
	}
	
	public void testCreate() throws Exception {
		Board board = new Board();
		assertTrue(board.isEmpty());
	}
	
	public void testSetPiece() throws Exception {
		Piece knight = Piece.createKnight(Color.WHITE);
		board.setPiece(knight, "b6");
		assertEquals(knight, board.getPiece("b6"));
	}
	
	public void testRows() {
		assertEquals(BLACK_PAWN_ROW, board.getRow(1));
		assertEquals(WHITE_PAWN_ROW, board.getRow(6));
	}
	
	public void testPrintBoard() {
		String dot = "........";
		assertEquals("rnbqkbnr", board.getRow(0));
		assertEquals(BLACK_PAWN_ROW, board.getRow(1));
		assertEquals(dot, board.getRow(2));
		assertEquals(dot, board.getRow(3));
		assertEquals(dot, board.getRow(4));
		assertEquals(dot, board.getRow(5));
		assertEquals(WHITE_PAWN_ROW, board.getRow(6));
		assertEquals("RNBQKBNR", board.getRow(7));
//		board.print();
	}
	
	public void testGetPiecesCount() throws Exception {
		Piece piece = Piece.createPawn(Piece.Color.BLACK);
		assertEquals(8, board.getCount(piece));
		Piece piece2 = Piece.createQueen(Piece.Color.WHITE);
		assertEquals(1, board.getCount(piece2));
	}
	
	public void testGetPiece() throws Exception {
		String pos = "a8";
		assertTrue(Piece.createRook(Color.WHITE).equals(board.getPiece(pos)));
		String pos2 = "h1";
		assertTrue(Piece.createRook(Color.BLACK).equals(board.getPiece(pos2)));
	}
	
	public void testPawnBonus() throws Exception {
		Board board = new Board();
		Piece whitePawn = Piece.createPawn(Color.WHITE);
		board.setPiece(whitePawn, "a8");
		board.setPiece(whitePawn, "a7");
		board.setPiece(whitePawn, "a6");
		board.setPiece(whitePawn, "a5");
		
		assertEquals(4.0, board.getScore(Color.WHITE), 0.05);
	}
	
	public void testCountScore() throws Exception {
		final double TOLERANCE = 0.05;
		Board board = new Board();
		board.setPiece(Piece.createKing(Color.WHITE), "b8");
		board.setPiece(Piece.createRook(Color.WHITE), "c8");
		board.setPiece(Piece.createPawn(Color.WHITE), "a7");
		board.setPiece(Piece.createPawn(Color.WHITE), "c7");
		board.setPiece(Piece.createBishop(Color.WHITE), "d7");
		board.setPiece(Piece.createPawn(Color.WHITE), "b6");
		board.setPiece(Piece.createQueen(Color.WHITE), "e6");
		assertEquals(18.5, board.getScore(Color.WHITE), TOLERANCE);
		
		board.setPiece(Piece.createKnight(Color.BLACK), "f4");
		board.setPiece(Piece.createQueen(Color.BLACK), "g4");
		board.setPiece(Piece.createPawn(Color.BLACK), "f3");
		board.setPiece(Piece.createPawn(Color.BLACK), "h3");
		board.setPiece(Piece.createPawn(Color.BLACK), "f2");
		board.setPiece(Piece.createPawn(Color.BLACK), "g2");
		board.setPiece(Piece.createRook(Color.BLACK), "e1");
		board.setPiece(Piece.createKing(Color.BLACK), "f1");
		assertEquals(19.5, board.getScore(Color.BLACK), TOLERANCE);
	}
}
