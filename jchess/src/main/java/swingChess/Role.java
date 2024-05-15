package swingChess;

import java.util.ArrayList;

public enum Role {
		PAWN(), 
		KNIGHT(), 
		BISHOP(), 
		ROOK(), 
		QUEEN(), 
		KING();
	
	
	final int[][] R_MOVES = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, 
	 		{2, 0}, {-2, 0}, {0, 2}, {0, -2},
	 		{3, 0}, {-3, 0}, {0, 3}, {0, -3},
	 		{4, 0}, {-4, 0}, {0, 4}, {0, -4},
	 		{5, 0}, {-5, 0}, {0, 5}, {0, -5},
	 		{6, 0}, {-6, 0}, {0, 6}, {0, -6},
	 		{7, 0}, {-7, 0}, {0, 7}, {0, -7},
	 		{8, 0}, {-8, 0}, {0, 8}, {0, -8}};
	final int[][] B_MOVES = {{1, 1}, {-1, -1}, {-1, 1}, {1, -1}, 
			 {2, 2}, {-2, -2}, {-2, 2}, {2, -2},
			 {3, 3}, {-3, -3}, {-3, 3}, {3, -3},
			 {4, 4}, {-4, -4}, {-4, 4}, {4, -4},
			 {5, 5}, {-5, -5}, {-5, 5}, {5, -5},
			 {6, 6}, {-6, -6}, {-6, 6}, {6, -6},
			 {7, 7}, {-7, -7}, {-7, 7}, {7, -7},
			 {8, 8}, {-8, -8}, {-8, 8}, {8, -8}};
	final int[][] KN_MOVES = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, -2}, {1, 2}, {-1, 2}, {-1, -2}};
	final int[][] Q_MOVES = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, 
	 		{2, 0}, {-2, 0}, {0, 2}, {0, -2},
	 		{3, 0}, {-3, 0}, {0, 3}, {0, -3},
	 		{4, 0}, {-4, 0}, {0, 4}, {0, -4},
	 		{5, 0}, {-5, 0}, {0, 5}, {0, -5},
	 		{6, 0}, {-6, 0}, {0, 6}, {0, -6},
	 		{7, 0}, {-7, 0}, {0, 7}, {0, -7},
	 		{8, 0}, {-8, 0}, {0, 8}, {0, -8},
	 		{1, 1}, {-1, -1}, {-1, 1}, {1, -1}, 
			 {2, 2}, {-2, -2}, {-2, 2}, {2, -2},
			 {3, 3}, {-3, -3}, {-3, 3}, {3, -3},
			 {4, 4}, {-4, -4}, {-4, 4}, {4, -4},
			 {5, 5}, {-5, -5}, {-5, 5}, {5, -5},
			 {6, 6}, {-6, -6}, {-6, 6}, {6, -6},
			 {7, 7}, {-7, -7}, {-7, 7}, {7, -7},
			 {8, 8}, {-8, -8}, {-8, 8}, {8, -8}};
	final int[][] K_MOVES = {{1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}, {-1, 0}, {-1, -1}, {-1, 0}};
	final int[][] P_MOVES = {{1, 0}, {2, 0}, {1, -1}, {1, 1}};
	
	
	private Role() {}
	
	public String toString() {
		switch(this) {
		case PAWN: return "pawn";
		case KNIGHT: return "knight";
		case BISHOP: return "bishop";
		case ROOK: return "rook";
		case QUEEN: return "queen";
		case KING: return "king";
		default: return "error";
		}
	}
	
	public int[][] getMoves() {
		
		switch(this) {
		case PAWN:
			return P_MOVES;
		case KNIGHT: 
			return KN_MOVES;
		case BISHOP:
			return B_MOVES;
		case ROOK: 
			return R_MOVES;
		case QUEEN:
			return Q_MOVES;
		case KING:
			return K_MOVES;
		default: 
			int[][] nomoves = {{0, 0}};
			return nomoves;
		}
	}
	
	
	
	
}
