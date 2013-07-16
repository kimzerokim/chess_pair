package chess;

import java.util.ArrayList;

public class Board {

	ArrayList<Pawn> pawns = new ArrayList<Pawn>();

	public void addPawn(Pawn pawn) {
		pawns.add(pawn);
	}

	public int getPawnNumber() {
		return pawns.size();
	}

	public Pawn getPawn(int index) {
		return pawns.get(index);
	}
}
