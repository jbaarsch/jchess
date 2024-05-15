package swingChess;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.*;

public class BoardPanel extends JPanel{

	private final int WIDTH = 645, HEIGHT = 645;
	private Square[][] squares;
	private char boardPos[][];
    private Square selected;
	private Square mouseIn;
	private BoardPanel me;
	
	public BoardPanel() {
		me = this;
		this.setPreferredSize(new Dimension (WIDTH, HEIGHT));
		this.setBackground(Color.BLUE);
		squares =  new Square[8][8];
		for (int i = 0; i < 8; i++) {
			int color = i % 2;
			for (int j = 0; j < 8; j++ ) {
				Square square = new Square((color%2 == 1)? Color.gray : Color.white, i, j); 
				color++;
				squares[i][j] = square;
				this.add(square);
			}
		}
		MouseTracker mouseTracker = new MouseTracker();
		this.addMouseListener(mouseTracker);
		this.addMouseMotionListener(mouseTracker);
		
		initializeBoard();
		
		
			
		
		
	}
	
	private void initializeBoard() {
		
		
		boardPos = new char[8][8];
		for (int i = 0; i < 8; i++) {
			boardPos[0][i] = 'd';
			boardPos[1][i] = 'd';
			boardPos[2][i] = 'e';
			boardPos[3][i] = 'e';
			boardPos[4][i] = 'e';
			boardPos[5][i] = 'e';
			boardPos[6][i] = 'l';
			boardPos[7][i] = 'l';
		}
		
		
		
		Piece[] dPieces = new Piece[16];
		
		for (int i = 8; i < 16; i++) {
			Piece dPawn = new Piece(Role.PAWN, false);
			dPieces[i] = dPawn;
		}
		
		dPieces[0] = new Piece(Role.ROOK, false);
		dPieces[7] = new Piece(Role.ROOK, false);
		dPieces[1] = new Piece(Role.KNIGHT, false);
		dPieces[6] = new Piece(Role.KNIGHT, false);
		dPieces[2] = new Piece(Role.BISHOP, false);
		dPieces[5] = new Piece(Role.BISHOP, false);
		dPieces[3] = new Piece(Role.QUEEN, false);
		dPieces[4] = new Piece(Role.KING, false);
 		
		
			
		Piece[] lPieces = new Piece[16];
		
		for (int i = 8; i < 16; i++) {
			Piece lPawn = new Piece(Role.PAWN, true);
			lPieces[i] = lPawn;
		}
		
		Piece lRook1 = new Piece(Role.ROOK, true);
		Piece lRook2 = new Piece(Role.ROOK, true);
		lPieces[0] = lRook1;
		lPieces[7] = lRook2;
		Piece lKnight1 = new Piece(Role.KNIGHT, true);
		Piece lKnight2 = new Piece(Role.KNIGHT, true);
		lPieces[1] = lKnight1;
		lPieces[6] = lKnight2;
		Piece lBishop1 = new Piece(Role.BISHOP, true);
		Piece lBishop2 = new Piece(Role.BISHOP, true);
		lPieces[2] = lBishop1;
		lPieces[5] = lBishop2;
		Piece lQueen = new Piece(Role.QUEEN, true);
		Piece lKing = new Piece(Role.KING, true);
		lPieces[3] = lQueen;
		lPieces[4] = lKing;
		
		
		for (int i = 0; i < 8; i++) {
			squares[0][i].takeSquare(dPieces[i]);
			squares[1][i].takeSquare(dPieces[i+8]);
			squares[7][i].takeSquare(lPieces[i]);
			squares[6][i].takeSquare(lPieces[i+8]);
		}
		repaint();
			
		
		
	}
	
	public char[][] getBoardPos() {
		return boardPos;
	}
	
	private void movePiece(Square origin, Square destination) {
		Piece mover = origin.getOccupant();
		relieveEnemy(mover, origin.getCoord());
		origin.takeSquare(null);
		boardPos[origin.getCoord()[0]][origin.getCoord()[1]] = 'e';
		destination.takeSquare(mover);
		boardPos[destination.getCoord()[0]][destination.getCoord()[1]] = mover.isLight?'l':'d';
	}
	
	private Square getSquare(Point p) {
		int x = p.x;
		int y = p.y;
		x = x/80;
		y = y/80;
		if (y < 8 && x < 8) 
			return squares[y][x];
		else 
			return null;
	}
	
	private void threatenEnemy(Piece piece, int[] space) {
		ArrayList<Move> moves = MoveRules.getMoves(piece, space[0], space[1], boardPos);
		for (Move move : moves) {
			squares[move.getRow() + space[0]][move.getCol() + space[1]].threaten();
		}
		
	}
	
	private void relieveEnemy(Piece piece, int[] space) {
		ArrayList<Move> moves = MoveRules.getMoves(piece, space[0], space[1], boardPos);
		for (Move move : moves) {
			squares[move.getRow() + space[0]][move.getCol() + space[1]].relieve();
		}
	}
	
	private class MouseTracker implements MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {
//			Square square = getSquare(e.getPoint());
//			
//			if (square != null) {
//				if (selected != null) {
//					//System.out.println("I relieve you! " + square.getCoord()[0] + ", " + square.getCoord()[1]);
//					relieveEnemy(selected.occupant, selected.getCoord());
//					selected.deSelect();
//				}
//				if (square.isOccupied()) {
//					Icon icon = square.getOccupant().getIcon();
//					icon.paintIcon(me, getGraphics(), e.getPoint().x, e.getPoint().y);
//				}
//			}
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			Square square = getSquare(e.getPoint());
			if (square != null) {
				if (mouseIn != null)
					mouseIn.mouseOut();
				square.mouseIn();
				mouseIn = square;
			}
					
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
//			for (Square[] row : squares) {
//				for (Square square : row) {
//					System.out.println(square.getCoord()[0] + ", " + square.getCoord()[1]);
//					System.out.println(square.getY());
//					System.out.println(square.getX());
//				}
//			}
			if (e.getButton() == MouseEvent.BUTTON1) {
				//System.out.println("Mouse #1! ");
				Square square = getSquare(e.getPoint());
				//System.out.println("Board registered click: " + e.getPoint().x + ", " +  e.getPoint().y);
				if (square != null) {
					if (selected != null) {
						//System.out.println("I relieve you! " + square.getCoord()[0] + ", " + square.getCoord()[1]);
						relieveEnemy(selected.occupant, selected.getCoord());
						selected.deSelect();
					}
					square.select();
					selected = square;
					if (square.isOccupied())
						threatenEnemy(square.occupant, square.getCoord() );
				}
			} else if (e.getButton() == MouseEvent.BUTTON3) {
				//System.out.println("Mouse #3!");
				Square square = getSquare(e.getPoint());
				if (square != null && selected != null) {
					int selCoord[] = selected.getCoord();
					Move moveTrial = new Move(square.getCoord()[0] - selCoord[0], square.getCoord()[1] - selCoord[1]);
				    for (Move move : MoveRules.getMoves(selected.getOccupant(), selCoord[0], selCoord[1], boardPos) ) {
				    	if (move.equals(moveTrial)) {
				    		movePiece(selected, square);
				    	}
				    }
				}
				
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if (mouseIn != null)
				mouseIn.mouseOut();
			mouseIn = getSquare(e.getPoint());
			if (mouseIn != null)
				mouseIn.mouseIn();
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		
		
		
	}

}
