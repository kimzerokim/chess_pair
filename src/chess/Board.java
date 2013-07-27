package chess;

import java.util.ArrayList;

import pieces.Piece;
import pieces.Piece.Color;

public class Board {
	private ArrayList<ArrayList<Piece>> rows = new ArrayList<ArrayList<Piece>>();

	public Board() {
	}
	
	public boolean isEmpty() {
		for (ArrayList<Piece> row : rows) {
			if (!row.isEmpty())
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
		rows.add(createBlackRow());
		rows.add(createPawnRow(Color.BLACK));
		for (int i=0; i<4; i++)
			rows.add(createBlankRow());
		rows.add(createPawnRow(Color.WHITE));
		rows.add(createWhiteRow());
	}
	
	private ArrayList<Piece> createWhiteRow() {
		ArrayList<Piece> arr = new ArrayList<Piece>(8);
		Color color = Color.WHITE;
		arr.add(Piece.createRook(color));
		arr.add(Piece.createKnight(color));
		arr.add(Piece.createBishop(color));
		arr.add(Piece.createQueen(color));
		arr.add(Piece.createKing(color));
		arr.add(Piece.createBishop(color));
		arr.add(Piece.createKnight(color));
		arr.add(Piece.createRook(color));
		
		return arr;
	}
	
	private ArrayList<Piece> createBlackRow() {
		ArrayList<Piece> arr = new ArrayList<Piece>(8);
		Color color = Color.BLACK;
		arr.add(Piece.createRook(color));
		arr.add(Piece.createKnight(color));
		arr.add(Piece.createBishop(color));
		arr.add(Piece.createQueen(color));
		arr.add(Piece.createKing(color));
		arr.add(Piece.createBishop(color));
		arr.add(Piece.createKnight(color));
		arr.add(Piece.createRook(color));
		
		return arr;
	}
	
	private ArrayList<Piece> createPawnRow(Color color) {
		ArrayList<Piece> arr = new ArrayList<Piece>(8);
		for (int i=0; i<8; i++)
			arr.add(Piece.createPawn(color));
		return arr;
	}
	
	private ArrayList<Piece> createBlankRow() {
		ArrayList<Piece> arr = new ArrayList<Piece>(8);
		for (int i=0; i<8; i++)
			arr.add(Piece.noPiece());
		return arr;
	}
}
