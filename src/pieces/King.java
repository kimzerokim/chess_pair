package pieces;

import chess.Position;

public class King extends Piece{
	King king;
	
	King(Color color) {
		super(color, Type.KING);
	}
	
	public boolean getPossibleMove(String src, String tar) {
		final int tarX = Position.getX(tar);
		final int tarY = Position.getY(tar);
		final int srcX = Position.getX(src);
		final int srcY = Position.getY(src);
		
		if (tarX-srcX > 1 || tarX-srcX < -1 || tarY-srcY > 1 || tarY-srcY > -1) {
			return false;
		}
		else 
			return true;
	}	
}
