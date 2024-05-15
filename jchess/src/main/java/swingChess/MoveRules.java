package swingChess;

import java.util.ArrayList;

public class MoveRules {
	
	public static ArrayList<Move> getMoves(Piece p, int row, int col, char board[][]) {
		// {{1, 0}, {2, 0}, {1, -1}, {1, 1}};
		ArrayList<Move> moves = new ArrayList();
		if (p != null) {
		switch (p.getRole()) {
	
		// Pawns move one direction if they are light, and the other direction if they are dark.
		case PAWN: if (p.isLight) {    
			if (!isFriendly(p.isLight, row -1, col, board))
				moves.add(new Move(-1, 0));
			if (row == 6 && isFree(5, col, board) && !isFriendly(p.isLight, 4, col, board ))
				moves.add(new Move(-2, 0));
			if (isEnemy(p.isLight, row -1, col - 1, board))
				moves.add(new Move(-1, -1));
			if (isEnemy(p.isLight, row -1, col + 1, board))
				moves.add(new Move(-1, 1));
			} else {
				if (!isFriendly(p.isLight, row + 1, col, board))
					moves.add(new Move(1, 0));
				if (row == 1 && isFree(2, col, board) && !isFriendly(p.isLight, 3, col, board ))
					moves.add(new Move(2, 0));
				if (isEnemy(p.isLight, row + 1, col - 1, board))
					moves.add(new Move(1, -1));
				if (isEnemy(p.isLight, row + 1, col + 1, board))
					moves.add(new Move(1, 1));
			} break;
		case KNIGHT: 
			// {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, -2}, {1, 2}, {-1, 2}, {-1, -2}};
		{
			int knightMoves[][] = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, -2}, {1, 2}, {-1, 2}, {-1, -2}};
			for (int kmoves[] : knightMoves) {
				if (!isFriendly(p.isLight, row + kmoves[0], col + kmoves[1], board) && isOnBoard(row+ kmoves[0], col+kmoves[1]))
					moves.add(new Move(kmoves[0], kmoves[1]));
			}
			break;
		}
		case BISHOP:
			moves.addAll(getBishopMoves(p, row, col, board));
			break;
		case ROOK:
			moves.addAll(getRookMoves(p, row, col, board));
			break;
		case QUEEN:
			moves.addAll(getRookMoves(p, row, col, board));
			moves.addAll(getBishopMoves(p, row, col, board));
			break;
		case KING:
			for (int dir = -1; dir <=1; dir++) {
				if (!isFriendly(p.isLight, row + dir, col + dir, board) && isOnBoard(row + dir, col + dir))
					moves.add(new Move(dir, dir));
				if (!isFriendly(p.isLight, row, col + dir, board) && isOnBoard(row, col + dir))
					moves.add(new Move(0, dir));
				if (!isFriendly(p.isLight, row + dir, col, board) && isOnBoard(row + dir, col))
					moves.add(new Move(dir, 0));
				if (!isFriendly(p.isLight, row + dir, col - dir, board) && isOnBoard(row + dir, col - dir))
					moves.add(new Move(row + dir, row - dir));
			}
			break;
		}
		}
		
		return moves;
		
	}
	
		
	
	private static boolean isFree(int row, int col, char[][] board) {
		if (!isOnBoard(row, col))
			return false;
		else 
			return (board[row][col] == 'e');
	}

	private static boolean isFriendly(boolean isLight, int row, int col, char[][] board) {
		if (!isOnBoard(row, col))
			return false;
		else 
			return ((isLight && board[row][col] == 'l') || (! isLight && board[row][col] == 'd'));
	}
	
	private static boolean isEnemy(boolean isLight, int row, int col, char[][] board) {
		if (!isOnBoard(row, col))
			return false;
		else 
			return ((isLight && board[row][col] == 'd') || (! isLight && board[row][col] == 'l'));
	}
	
	private static boolean isOnBoard(int row, int col) {
		return !(row < 0 || row > 7 || col < 0 || col > 7);
	}
		
	private static ArrayList<Move> getRookMoves(Piece p, int row, int col, char board[][]) {
		ArrayList<Move> moves = new ArrayList();
		for (int dir = 0; dir < 4; dir++) {
			spaceLoop:
			for (int space = 1; space < 8; space++) {
				int rspace = 0, cspace = 0;
				switch (dir) {
				case 0: 
					rspace = space;
					cspace = 0;
					break;
				case 1:
					rspace = (-1 * space);
					cspace = 0;
					break;
				case 2: 
					rspace = 0;
					cspace = (-1 * space);
					break;
				case 3: 
					rspace = 0;
					cspace = space;
				}
				if (!isOnBoard(row + rspace, col + cspace))
					break spaceLoop;
				if (isFriendly(p.isLight, row + rspace, col + cspace, board))
					break spaceLoop;
				if (isEnemy(p.isLight, row + rspace, col + cspace, board)) {
					moves.add(new Move(rspace, cspace));
					break spaceLoop;
				}
				moves.add(new Move(rspace, cspace));
			}
		}
		return moves;
	}
	
	private static ArrayList<Move> getBishopMoves(Piece p, int row, int col, char board[][]) {
		ArrayList<Move> moves = new ArrayList();
		for (int dir = 0; dir < 4; dir++) {
			spaceLoop:
			for (int space = 1; space < 8; space++) {
				int rspace = 0, cspace = 0;
			
				switch (dir) {
				case 0: 
					rspace = space;
					cspace = space;
					break;
				case 1:
					rspace = -1 * space;
					cspace = space;
					break;
				case 2: 
					rspace = -1 * space;
					cspace = -1 * space;
					break;
				case 3: 
					rspace = space;
					cspace = -1 * space;
				}
				if (!isOnBoard(row + rspace, col + cspace))
					break spaceLoop;
				if (isFriendly(p.isLight, row + rspace, col + cspace, board))
					break spaceLoop;
				if (isEnemy(p.isLight, row + rspace, col + cspace, board)) {
					moves.add(new Move(rspace, cspace));
					break spaceLoop;
				}
				moves.add(new Move(rspace, cspace));
			}
			
		}
		return moves;
	}
		
}
	
