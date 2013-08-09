package chess;

import java.util.List;

import junit.framework.TestCase;
import pieces.Piece;
import pieces.Piece.Color;

public class BoardTest extends TestCase {
	private static final String WHITE_PAWN_ROW = "pppppppp";
	private static final String BLACK_PAWN_ROW = "PPPPPPPP";
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
		assertEquals("RNBQKBNR", board.getRow(0));
		assertEquals(BLACK_PAWN_ROW, board.getRow(1));
		assertEquals(dot, board.getRow(2));
		assertEquals(dot, board.getRow(3));
		assertEquals(dot, board.getRow(4));
		assertEquals(dot, board.getRow(5));
		assertEquals(WHITE_PAWN_ROW, board.getRow(6));
		assertEquals("rnbqkbnr", board.getRow(7));
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
		
		assertEquals(2.0, board.getScore(Color.WHITE), 0.05);
	}
	
	
	/*
	 *  연습문제 5-4를 위한 테스트 
	 */
	public void testCountPieces() {
		Board board = new Board();
		Piece blackPawn = Piece.createPawn(Color.BLACK);
		
		// 연습문제에서 검은 졸의 갯수를 물어보고 있으므로 흰 말은 추가하지 않았다.		
		board.setPiece(Piece.createKing(Color.BLACK), "b8");
		board.setPiece(Piece.createRook(Color.BLACK), "c8");
		board.setPiece(Piece.createPawn(Color.BLACK), "a7");
		board.setPiece(Piece.createPawn(Color.BLACK), "c7");
		board.setPiece(Piece.createBishop(Color.BLACK), "d7");
		board.setPiece(Piece.createPawn(Color.BLACK), "b6");
		board.setPiece(Piece.createQueen(Color.BLACK), "e6");
		assertEquals(3, board.getCount(blackPawn));
	}
	
	/*
	 *  연습문제 5-5를 위한 테스트 
	 */
	public void testGenerateBoardEmpty () {
		Board board = new Board();
		// setUp에서는 initialize를 해주고 있으므로, new Board를 새로 만들어 Empty인 것을 확인한다.
		
		Piece WhiteKing = Piece.createKing(Color.WHITE);		
		Piece WhiteQueen = Piece.createQueen(Color.WHITE);
		Piece WhiteRook = Piece.createRook(Color.WHITE);
		Piece WhiteBishop = Piece.createBishop(Color.WHITE);
		Piece WhiteKnight = Piece.createKnight(Color.WHITE);
		Piece WhitePawn = Piece.createPawn(Color.WHITE);
		Piece BlackKing = Piece.createKing(Color.BLACK);
		Piece BlackQueen = Piece.createQueen(Color.BLACK);
		Piece BlackRook = Piece.createRook(Color.BLACK);
		Piece BlackBishop = Piece.createBishop(Color.BLACK);
		Piece BlackKnight = Piece.createKnight(Color.BLACK);
		Piece BlackPawn = Piece.createPawn(Color.BLACK);
		
		assertEquals(0, board.getCount(WhiteKing));
		assertEquals(0, board.getCount(WhiteQueen));
		assertEquals(0, board.getCount(WhiteRook));
		assertEquals(0, board.getCount(WhiteBishop));
		assertEquals(0, board.getCount(WhiteKnight));
		assertEquals(0, board.getCount(WhitePawn));
		assertEquals(0, board.getCount(BlackKing));
		assertEquals(0, board.getCount(BlackQueen));
		assertEquals(0, board.getCount(BlackRook));
		assertEquals(0, board.getCount(BlackBishop));
		assertEquals(0, board.getCount(BlackKnight));
		assertEquals(0, board.getCount(BlackPawn));
		
	}
	
	/*
	 *  연습문제 5-7을 위한 테스트 
	 */
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
		assertEquals(20.0, board.getScore(Color.WHITE), TOLERANCE);
		
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
	
	/*
	 *  연습문제 5-8을 위한 테스트
	 */
	public void testOrderPieces() {
		Board board = new Board();
	
		List<Piece> orderedPiece_White = null;
		List<Piece> orderedPiece_Black = null;
		
		Piece WhiteKing = Piece.createKing(Color.WHITE);		
		Piece WhiteQueen = Piece.createQueen(Color.WHITE);
		Piece WhiteRook = Piece.createRook(Color.WHITE);
		Piece WhiteBishop = Piece.createBishop(Color.WHITE);
		//Piece WhiteKnight = Piece.createKnight(Color.WHITE);
		Piece WhitePawn = Piece.createPawn(Color.WHITE);
		Piece BlackKing = Piece.createKing(Color.BLACK);
		Piece BlackQueen = Piece.createQueen(Color.BLACK);
		Piece BlackRook = Piece.createRook(Color.BLACK);
		//Piece BlackBishop = Piece.createBishop(Color.BLACK);
		Piece BlackKnight = Piece.createKnight(Color.BLACK);
		Piece BlackPawn = Piece.createPawn(Color.BLACK);
		
		board.setPiece(Piece.createKing(Color.WHITE), "b8");
		board.setPiece(Piece.createRook(Color.WHITE), "c8");
		board.setPiece(Piece.createPawn(Color.WHITE), "a7");
		board.setPiece(Piece.createPawn(Color.WHITE), "c7");
		board.setPiece(Piece.createBishop(Color.WHITE), "d7");
		board.setPiece(Piece.createPawn(Color.WHITE), "b6");
		board.setPiece(Piece.createQueen(Color.WHITE), "e6");		
		
		board.setPiece(Piece.createKnight(Color.BLACK), "f4");
		board.setPiece(Piece.createQueen(Color.BLACK), "g4");
		board.setPiece(Piece.createPawn(Color.BLACK), "f3");
		board.setPiece(Piece.createPawn(Color.BLACK), "h3");
		board.setPiece(Piece.createPawn(Color.BLACK), "f2");
		board.setPiece(Piece.createPawn(Color.BLACK), "g2");
		board.setPiece(Piece.createRook(Color.BLACK), "e1");
		board.setPiece(Piece.createKing(Color.BLACK), "f1");
		
		orderedPiece_White = board.orderedPiece(Piece.Color.WHITE);
		orderedPiece_Black = board.orderedPiece(Piece.Color.BLACK);
		
		assertTrue(WhiteQueen.equals(Board.getOrderedPiece(orderedPiece_White, 0)));
	}
	
	public void testMovePiece() throws Exception {
		Board board = new Board();
		Piece king = Piece.createKing(Color.WHITE);
		board.setPiece(king, "a1");
		board.movePiece("a1", "a2");
		
		Piece target = board.getPiece("a2");
		assertTrue(Piece.createKing(Color.WHITE).equals(target));
	}
}
