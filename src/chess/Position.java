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
		int x = getCharX(position) - 'a';
		return x;
	}
	
	public static int getY(String position) {
		int y = getCharY(position) - '1';
		return y;
	}
	
	public static String increaseRow(String position) {
		char row = (char) (getCharY(position) + 1);
		String retString = getCharX(position) + String.valueOf(row);
		return retString;
	}
	
	public static String increaseColumn(String position) {
		char column = (char) (getCharX(position) + 1);
		String retString = String.valueOf(column) + getCharY(position);
		return retString;
	}
	
	private static char getCharX(String position) {
		return Character.toLowerCase(position.charAt(0));
	}
	
	private static char getCharY(String position) {
		return Character.toLowerCase(position.charAt(1));
	}
}
