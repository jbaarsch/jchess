package swingChess;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class Square extends JPanel{
	
	private boolean occupied;
	Piece occupant;
	private final int row, col;
	private JLabel piecePlace;
	private boolean mouseIn;
	private boolean selected;
	private boolean threatened;
	private Color color;
	
	
	public Square(Color c, int row, int col) {
		color = c;
		this.row = row;
		this.col = col;
		setPreferredSize(new Dimension(75, 75));
		this.setBackground(color);	
		piecePlace = new JLabel();
		this.add(piecePlace);
		occupied = false;
		
	}
	
	public int[] getCoord() {
		int loc[] = {row, col};
		return loc;
	}
	
	public void takeSquare(Piece p) {
		occupant = p;
		if (p != null) {
			this.piecePlace.setIcon(p.getIcon());
			occupied = true;
		} else { 
			this.piecePlace.setIcon(null);
			occupied = false;
		}
		repaint();
	}
	
	public void setColor(Color c) {
		color = c;
		repaint();
	}
	
	public Piece getOccupant() {
		return occupant;
	}
	
	public void find() {
		System.out.println("I am a square");
		System.out.println("X: " + this.getX());
		System.out.println("Y: " + this.getY());
	}
	
	public boolean isOccupied() {
		return occupied;
	}
	
	public void select() {
		this.selected = true;
		repaint();
	}
	public void deSelect() {
		this.selected = false;
		repaint();
	}
	public void mouseIn() {
		this.mouseIn = true;
		repaint();
	}
	public void mouseOut() {
		this.mouseIn = false;
		repaint();
	}
	public void threaten() {
		threatened = true;
		repaint();
	}
	public void relieve() {
		threatened = false;
		repaint();
	}
	
	public void paintComponent (Graphics page)
	   {
	      super.paintComponent (page);
	      System.out.println("Row: " + row + "\tCol: " + col + "\tThreatened:" + threatened);

	      //page.setColor (Color.yellow);
	      if(selected && occupied)
	    	  this.setBackground(Color.GREEN);
	      else if (mouseIn)
	    	  this.setBackground(Color.yellow);
	      else if (threatened && occupied)
	    	  this.setBackground(Color.red);
	      else if (threatened)
	    	  this.setBackground(Color.pink);
	      else
	    	  this.setBackground(color);
	   }

	
}
