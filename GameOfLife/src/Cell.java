import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Cell {
	private Cell left;
	private Cell right;
	private Cell up;
	private Cell down;
	private Cell upLeft;
	private Cell upRight;
	private Cell downLeft;
	private Cell downRight;
	private int x;
	private int y;
	private boolean alive;
	private Color colour; // new colour
	private ArrayList<Cell> neighbourCells;

	// Head cell
	public Cell() {
		x = 0;
		y = 0;
		alive = true;
		// TODO: initialize the neighbouring cells
		initializeNeighboursArrayList();
	}

	// TODO: initialize the neighbouring cells
	public Cell(Cell origin, int x, int y) {
		this.x = x;
		this.y = y;
		if (origin.y < this.y) {
			Cell node = origin;
			while (node != null && node.y < this.y) {
				node = node.down;
			}
		}
		initializeNeighbours();
		initializeNeighboursArrayList();
	}

	// custom methods
	
	// TODO: finish adding all the initializing of neighbour cells
	// initialize Neighbour cells
	private void initializeNeighbours() {
		for (Cell cell : Animation.cells) {
			if (cell.getX() == this.getX() - 1 && cell.getY() == this.getY()) // LEFT
				this.left = cell;
			else if(cell.getX() == this.getX() + 1 && cell.getY() == this.getY()) // RIGHT
				this.right = cell;
		}
	}

	// initialize NeighboursArray, called in constructor
	private void initializeNeighboursArrayList() {
		this.neighbourCells.add(up);
		this.neighbourCells.add(down);
		this.neighbourCells.add(left);
		this.neighbourCells.add(right);
		this.neighbourCells.add(upLeft);
		this.neighbourCells.add(upRight);
		this.neighbourCells.add(downLeft);
		this.neighbourCells.add(downRight);
	}
	
	// change status of alive

	public void draw() {
		// javafx.drawRect(x, y)
	}
	
	public boolean isAlive() {
		return this.alive = true;
	}

	public boolean isDead() {
		return this.alive = false;
	}
	
	public void makeAlive() {
		this.alive = true;
	}
	
	public void makeDead() {
		this.alive = false;
	}
	
	// generic getters and setters

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Boolean getAlive() {
		return alive;
	}

	public void setAlive(Boolean alive) {
		this.alive = alive;
	}

	public Color getColour() {
		return colour;
	}

	public void setColour(Color colour) {
		this.colour = colour;
	}

	public ArrayList<Cell> getNeighbourCells() {
		return neighbourCells;
	}

	public void setNeighbourCells(ArrayList<Cell> neighbourCells) {
		this.neighbourCells = neighbourCells;
	}

}
