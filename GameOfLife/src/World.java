import java.util.ArrayList;

public class World {

	private int rows, cols;
	private ArrayList<ArrayList<Boolean>> valuesList;

	public World(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		// initialize values list
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				valuesList.get(j).add(i, false);
			}
		}
	}

	// custom classes
	public void update() {
		for (int i = 0; i < valuesList.size(); i++) {
			for (int j = 0; j < valuesList.get(i).size(); j++) {
				int cellNumber = returnLiveNeighbours(i, j);
				boolean value = valuesList.get(i).get(i);
				// rule #1: if cell is alive and has 2 or 3 surrounding live neighbours
				if (value = true && (cellNumber == 3 || cellNumber == 2))
					value = true;
				// rule #2: if cell is dead but has 3 surrounding live neighbours
				else if (value = false && cellNumber == 3)
					value = true;
				// rule #3: if cell does not fulfill the conditions for survival
				else
					value = false;
			}
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

	public ArrayList<ArrayList<Boolean>> getValuesList() {
		return valuesList;
	}

	public void setValuesList(ArrayList<ArrayList<Boolean>> valuesList) {
		this.valuesList = valuesList;
	}

}
