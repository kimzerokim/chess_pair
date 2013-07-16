package Test;

import java.util.ArrayList;

public class Board {

	ArrayList<Pawn> pawns = new ArrayList<Pawn>();

	public void addPawn(Pawn pawn1) {
		pawns.add(pawn1);
	}

	public Object getPawnNumber() {
		return pawns.size();
	}

	public Pawn getPawn(int i) {
		return pawns.get(i);
	}

}
