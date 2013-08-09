package pieces;

public class Queen extends Piece{
	enum Movable {
		N(0,1), NE(1,1), E(0,1), SE(1,-1), S(0,-1), SW(-1,-1), W(-1,0), NW(-1,1);
		
		private int x = 0;
		private int y = 0;
		
		Movable (int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		int getMovableX() {
			return x;
		}
		
		int getMovableY() {
			return y;
		}		
	}
	
	Queen (Color color) {
		super(color, Type.QUEEN);
	}
}
