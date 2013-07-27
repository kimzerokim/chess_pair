package chess;

public class Position {
	//   a b c d e f g h
	// 8
	// 7
	// 6
	// 5
	// 4
	// 3
	// 2
	// 1
	public static int getX(String position) {
		int x = Character.toLowerCase(position.charAt(0)) - 'a';
		return x;
	}
	
	public static int getY(String position) {
		int y = Integer.parseInt(position.substring(1))-1;
		return y;
	}
}
