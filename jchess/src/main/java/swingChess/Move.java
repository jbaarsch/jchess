package swingChess;

public class Move {

	private int row;
	private int col;
	
	public Move(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public boolean equals(Move otherMove) {
		return (this.row == otherMove.getRow() && this.col == otherMove.getCol());
	}
	
	public boolean equals(int square[]) {
		return (this.row == square[0] && this.col == square[1]);
	}
	
	
}

