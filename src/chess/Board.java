package chess;

import java.util.*;

import pieces.Piece;
import pieces.Piece.Color;

public class Board {
	private ArrayList<ArrayList<Piece>> rows;

	private List<Piece> orderedPieces_white = null;
	private List<Piece> orderedPieces_black = null;

	public Board() {
		initializeEmpty();
	}

	public boolean isEmpty() {
		Piece noPiece = Piece.noPiece();
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
					score += piece.getScore(piece.getType());
			}
		}
		score += countPawnBonus(color);
		return score;
	}

	public void setPiece(Piece piece, String position) {
		int x = Position.getX(position);
		int y = Position.getY(position);
		piece.setPosition(position);
		rows.get(y).set(x, piece);
	}

	// a b c d e f g h
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
		rows.add(createPawnRow(Color.BLACK));
		for (int i=0; i<4; i++)
			rows.add(createBlankRow());
		rows.add(createPawnRow(Color.WHITE));
		rows.add(createWhiteRow());
	}

	public void initializeEmpty() {
		rows = new ArrayList<ArrayList<Piece>>();
		
		for (int i=0; i<8; i++)
			rows.add(createBlankRow());
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
		for (int i = 0; i < 8; i++)
			arr.add(Piece.createPawn(color));
		return arr;
	}

	private ArrayList<Piece> createBlankRow() {
		ArrayList<Piece> arr = new ArrayList<Piece>(8);
		for (int i = 0; i < 8; i++)
			arr.add(Piece.noPiece());
		return arr;
	}

	/**
	 * 
	 * @param color
	 * @return 같은 줄에 폰이 있는지 확인하여 점수를 다르게 반환한다
	 */
	private double countPawnBonus(Piece.Color color) {
		final double minusRate = -0.5;
		double retBonus = 0.0;

		ArrayList<Integer> storage = new ArrayList<Integer>(8);
		for (int i = 0; i < 8; i++)
			storage.add(new Integer(0));

		// count pawn number by column
		final Piece pawn = Piece.createPawn(color);
		for (ArrayList<Piece> row : rows) {
			for (int i = 0; i < row.size(); i++) {
				Piece piece = row.get(i);
				if (piece.equals(pawn)) {
					Integer count = storage.get(i);
					storage.set(i, new Integer(count + 1));
				}
			}
		}

		// calculate
		for (Integer count : storage)
			if (count >= 2)
				retBonus += (minusRate * count);

		return retBonus;
	}


	public List<Piece> orderedPiece(Color color) {
		switch (color) {
		case WHITE:
			orderedPieces_white = new ArrayList<Piece>();
			orderedPieces_white = collectPieces(color);
			orderList(orderedPieces_white);
			return orderedPieces_white;
		case BLACK:
			orderedPieces_black = new ArrayList<Piece>();
			orderedPieces_black = collectPieces(color);
			orderList(orderedPieces_black);
			return orderedPieces_black;
		default : return null;
		}
	}

	public List<Piece> collectPieces(Color color) {
		ArrayList<Piece> retList = new ArrayList<Piece>();	
		Piece blankPiece = Piece.noPiece();
		for (ArrayList<Piece> row : rows) {
			for (Piece piece : row) {
				if(!piece.equals(blankPiece) && piece.getColor() == color) //아무것도 아닌 피스와 비교하여 유의미한 피스를 모두 리스트에 추가 
					retList.add(piece);
			}
		}
		return retList;
	}

	public void orderList(List<Piece> list) {
		Collections.sort(list);
	}
	
	public static Piece getOrderedPiece(List<Piece> list, int i) {
		return list.get(i);
	}
	
	public void movePiece(String source, String target) {
		Piece srcPiece = getPiece(source);
		Piece tarPiece = getPiece(target);
		Piece tempPiece = srcPiece.clone();
		
		srcPiece = tarPiece.clone();
		tarPiece = tempPiece;
		
		setPiece(srcPiece, target);
		setPiece(tarPiece, source);
	}
}
