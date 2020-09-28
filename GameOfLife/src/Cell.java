import java.util.ArrayList;

import javafx.scene.paint.Color;

public class Cell {
	Cell left;
	Cell right;
	Cell up;
	Cell down;
	Cell upLeft;
	Cell upRight;
	Cell downLeft;
	Cell downRight;
	int x;
	int y;
	Boolean alive;
	Color colour; // new colour
	ArrayList<Cell> neighbourCells;

	public Cell() {
		x = 0;
		y = 0;
		alive = true;
	}
	
	public Cell(Cell origin, int x, int y) {
		this.x = x;
		this.y = y;
		if (origin.y < this.y) {
			Cell node = origin;
			while (node != null && node.y < this.y) {
				node = node.down;
			}
		}
	}

}
