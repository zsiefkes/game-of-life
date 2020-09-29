import java.util.ArrayList;

public class World {

	private int rows, cols;
	// option 1: Cell object
	private ArrayList<Cell> cells;
	// option 2: 2D arraylist
	private boolean[][] values;
	private ArrayList<ArrayList<Boolean>> valuesList;

	public World(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		// initialize values list
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				values[i][j] = false;
				valuesList.get(j).add(i, false);
			}
		}
	}

	// custom classes
	// TODO: update for array of boolean values
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

	// TODO: edit to be place of boolean values
	public int returnLiveNeighbours(Cell inputCell) {
		int counter = 0;
		// check cell's neighbouring cells and return
		int x = inputCell.getX();
		int y = inputCell.getY();
		for (Cell cell : this.cells) {
			// check north
			// check south
			// check east
			// check west
			// check northeast
			// check northwest
			// check southeast
			// check southwest
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

	public ArrayList<Cell> getCells() {
		return cells;
	}

	public void setCells(ArrayList<Cell> cells) {
		this.cells = cells;
	}

}
