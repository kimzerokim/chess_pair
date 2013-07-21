package chess;

import java.util.ArrayList;

import pieces.Pawn;

public class Board {

	ArrayList<Pawn> pawns = new ArrayList<Pawn>();

	private ArrayList<ArrayList<Pawn>> rows = new ArrayList<ArrayList<Pawn>>();

	public Board() {
		for (int i = 0; i < 16; i++)
			addPawn(new Pawn());
		initialize();
	}

	public void addPawn(Pawn pawn) {
		pawns.add(pawn);
	}

	public int getPawnNumber() {
		return pawns.size();
	}

	public Pawn getPawn(int index) {
		return pawns.get(index);
	}

	public void initialize() {
		for (int j = 0; j < 8; j++) {
			ArrayList<Pawn> row = new ArrayList<Pawn>();
			if (j == 1) {
				for (int i = 0; i < 8; i++) {
					Pawn pawn = new Pawn();
					pawn.setColor(Pawn.PAWN_WHITE);
					row.add(pawn);
				}
			}
			else if (j == 6) {
				for (int i = 0; i < 8; i++) {
					Pawn pawn = new Pawn();
					pawn.setColor(Pawn.PAWN_BLACK);
					row.add(pawn);
				}
			}
			else {
				for (int i = 0; i < 8; i++) {
					Pawn pawn = new Pawn();
					pawn.setColor(Pawn.PAWN_BLANK);
					row.add(pawn);
				}
			}
			rows.add(row);
		}
	}

	public String getRow(int index) {
		StringBuilder rowInfo = new StringBuilder();

		for (int i = 0; i < 8; i++) {
			rowInfo.append(rows.get(index).get(i));
		}

		return rowInfo.toString();
	}

	public void print() {
		for (int i = 0; i < rows.size(); i++) {
			System.out.println(getRow(i));
		}
	}
}
