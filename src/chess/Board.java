package chess;

import java.util.ArrayList;
import java.util.List;

import pieces.Piece;
import pieces.Piece.Color;

public class Board {
	private List<ArrayList<Piece>> rows;
	public Board() {
		initializeEmpty();
	}
	
	public boolean isEmpty() {
		Piece noPiece = Piece.createNoPiece();
		for (ArrayList<Piece> row : rows) {
			for (Piece piece : row)
				if (!piece.equals(noPiece))
					return false;
		}
		return true;
	}
	
	public int getCount(Piece other) {
		int count = 0;
		for (ArrayList<Piece> row : rows) {
			for (Piece piece : row) {
				if (piece.equals(other))
					count++;
			}
		}
		return count;
	}
	
	public double getScore(Color color) {
		double score = 0;
		for (ArrayList<Piece> row : rows) {
			for (Piece piece : row) {
				if (piece.getColor() == color)
					score += piece.getScore();
			}
		}
		score += countPawnBonus(color);
		return score;
	}
	
	public void setPiece(Piece piece, String position) {
		int x = Position.getX(position);
		int y = Position.getY(position);
		rows.get(y).set(x, piece);
	}

	//   a b c d e f g h
	// 8
	// 7
	// 6
	// 5
	// 4
	// 3
	// 2
	// 1
	public Piece getPiece(String position) {
		int x = Position.getX(position);
		int y = Position.getY(position);
		return rows.get(y).get(x);
	}
	
	public String getRow(int index) {
		StringBuilder rowInfo = new StringBuilder();
		ArrayList<Piece> row = rows.get(index);

		for (int i = 0; i < 8; i++) {
			rowInfo.append(row.get(i).getRepresentation());
		}

		return rowInfo.toString();
	}

	public void print() {
		StringBuilder sb = new StringBuilder();
		for (ArrayList<Piece> row : rows) {
			StringBuilder tempSb = new StringBuilder();
			for (Piece piece : row)
				tempSb.append(piece.getRepresentation());
			tempSb.append(System.lineSeparator());
			sb = tempSb.append(sb);
		}
		System.out.println(sb.toString());
	}
	
	public void initialize() {
		rows = new ArrayList<ArrayList<Piece>>();
		rows.add(createBlackRow());
		rows.add(createBlackPawnRow());
		String basePosition = "a3";
		for (int i=0; i<4; i++) {
			rows.add(createBlankRow(basePosition));
			basePosition = Position.increaseRow(basePosition);
		}
		rows.add(createWhitePawnRow());
		rows.add(createWhiteRow());
	}
	
	public void initializeEmpty() {
		rows = new ArrayList<ArrayList<Piece>>();
		String basePosition = "a1";
		for (int i=0; i<8; i++) {
			rows.add(createBlankRow(basePosition));
			basePosition = Position.increaseRow(basePosition);
		}
	}
	
	private ArrayList<Piece> createWhiteRow() {
		ArrayList<Piece> row = new ArrayList<Piece>(8);
		row.add(Piece.createRook(Color.WHITE).setPosition("a8"));
		row.add(Piece.createKnight(Color.WHITE).setPosition("b8"));
		row.add(Piece.createBishop(Color.WHITE).setPosition("c8"));
		row.add(Piece.createQueen(Color.WHITE).setPosition("d8"));
		row.add(Piece.createKing(Color.WHITE).setPosition("e8"));
		row.add(Piece.createBishop(Color.WHITE).setPosition("f8"));
		row.add(Piece.createKnight(Color.WHITE).setPosition("g8"));
		row.add(Piece.createRook(Color.WHITE).setPosition("h8"));
		return row;
	}
	
	private ArrayList<Piece> createBlackRow() {
		ArrayList<Piece> row = new ArrayList<Piece>(8);
		row.add(Piece.createRook(Color.BLACK).setPosition("a1"));
		row.add(Piece.createKnight(Color.BLACK).setPosition("b1"));
		row.add(Piece.createBishop(Color.BLACK).setPosition("c1"));
		row.add(Piece.createQueen(Color.BLACK).setPosition("d1"));
		row.add(Piece.createKing(Color.BLACK).setPosition("e1"));
		row.add(Piece.createBishop(Color.BLACK).setPosition("f1"));
		row.add(Piece.createKnight(Color.BLACK).setPosition("g1"));
		row.add(Piece.createRook(Color.BLACK).setPosition("h1"));
		return row;
	}

	private ArrayList<Piece> createBlackPawnRow() {
		ArrayList<Piece> row = new ArrayList<Piece>(8);
		row.add(Piece.createPawn(Color.BLACK).setPosition("a2"));
		row.add(Piece.createPawn(Color.BLACK).setPosition("b2"));
		row.add(Piece.createPawn(Color.BLACK).setPosition("c2"));
		row.add(Piece.createPawn(Color.BLACK).setPosition("d2"));
		row.add(Piece.createPawn(Color.BLACK).setPosition("e2"));
		row.add(Piece.createPawn(Color.BLACK).setPosition("f2"));
		row.add(Piece.createPawn(Color.BLACK).setPosition("g2"));
		row.add(Piece.createPawn(Color.BLACK).setPosition("h2"));
		return row;
	}	
	
	private ArrayList<Piece> createWhitePawnRow() {
		ArrayList<Piece> row = new ArrayList<Piece>(8);
		row.add(Piece.createPawn(Color.WHITE).setPosition("a7"));
		row.add(Piece.createPawn(Color.WHITE).setPosition("b7"));
		row.add(Piece.createPawn(Color.WHITE).setPosition("c7"));
		row.add(Piece.createPawn(Color.WHITE).setPosition("d7"));
		row.add(Piece.createPawn(Color.WHITE).setPosition("e7"));
		row.add(Piece.createPawn(Color.WHITE).setPosition("f7"));
		row.add(Piece.createPawn(Color.WHITE).setPosition("g7"));
		row.add(Piece.createPawn(Color.WHITE).setPosition("h7"));
		return row;
	}
	
	private ArrayList<Piece> createBlankRow(String basePosition) {
		ArrayList<Piece> row = new ArrayList<Piece>(8);
		for (int i=0; i<8; i++) {
			row.add(Piece.createNoPiece().setPosition(basePosition));
			basePosition = Position.increaseColumn(basePosition);
		}
		return row;
	}
	
	private double countPawnBonus(Piece.Color color) {
		final double minusRate = -0.5;
		double retBonus = 0.0;
		
		ArrayList<Integer> storage = new ArrayList<Integer>(8);
		for (int i=0; i<8; i++)
			storage.add(new Integer(0));
		
		// count pawn num by column
		final Piece pawn = Piece.createPawn(color);
		for (ArrayList<Piece> row : rows) {
			for (int i=0; i<row.size(); i++) {
				Piece piece = row.get(i);
				if (piece.equals(pawn)) {
					Integer count = storage.get(i);
					storage.set(i, new Integer(count+1));
				}
			}
		}
		
		// calculate bonus
		for (Integer count : storage)
			if (count >= 2)
				retBonus += (minusRate * count);
		
		return retBonus;
	}
}
