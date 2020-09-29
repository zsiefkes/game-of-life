import java.util.ArrayList;
import java.util.LinkedList;

public class World {

	private int rows, cols;
	private ArrayList<ArrayList<Boolean>> valuesList = new ArrayList<ArrayList<Boolean>>();

	public World(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		// initialize cells list
		for (int i = 0; i < rows; i++)
			for (int j = 0; j < cols; j++)
				new Cell(i, j, this);
	}

	// custom classes
	public void update() {
		for (Cell cell : this.cells) {

			int cellNumber = returnLiveNeighbours(cell);
			// rule #1: if cell is alive and has 2 or 3 surrounding live neighbours
			if (cell.isAlive() && (cellNumber == 3 || cellNumber == 2))
				cell.setAlive();
			// rule #2: if cell is dead but has 3 surrounding live neighbours
			else if (cell.isDead() && cellNumber == 3)
				cell.setAlive();
			// rule #3
			else
				cell.setDead(); 
		}
	}

	// take coordinates x, y and return number of live neighboring cells
	public int returnLiveNeighbours(int x, int y) {
		int counter = 0;
		// check north
		if (valuesList.get(x).get(y - 1)) {
			counter++;
		}
		// check south
		if (valuesList.get(x).get(y + 1)) {
			counter++;
		}
		// check east
		if (valuesList.get(x + 1).get(y)) {
			counter++;
		}
		// check west
		if (valuesList.get(x - 1).get(y)) {
			counter++;
		}
		// check northeast
		if (valuesList.get(x + 1).get(y - 1)) {
			counter++;
		}
		// check northwest
		if (valuesList.get(x - 1).get(y - 1)) {
			counter++;
		}
		// check southeast
		if (valuesList.get(x + 1).get(y + 1)) {
			counter++;
		}
		// check southwest
		if (valuesList.get(x - 1).get(y + 1)) {
			counter++;
		}
		
		return counter;
	}

	// getters and setters

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public LinkedList<Cell> getCells() {
		return cells;
	}

	public void setCells(LinkedList<Cell> cells) {
		this.cells = cells;
	}

}
