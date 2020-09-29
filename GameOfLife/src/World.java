import java.util.ArrayList;
public class World {

	private int rows, cols;
	private ArrayList<ArrayList<Boolean>> valuesList;

	public World(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		// initialize values list
		for (int i = 0; i < rows; i++) {
			valuesList.add(new ArrayList<Boolean>());
			for (int j = 0; j < cols; j++) {
				valuesList.get(i).add(j, false);
			}
		}
	}

	// custom classes
	public void update() {
		ArrayList<ArrayList<Boolean>> temp = new ArrayList<ArrayList<Boolean>>();
		for (int i = 0; i < valuesList.size(); i++) {
			temp.add(new ArrayList<Boolean>());
			for (int j = 0; j < valuesList.get(i).size(); j++) {
				int cellNumber = returnLiveNeighbours(i, j);
				boolean value = valuesList.get(i).get(j);
				// rule #1: if cell is alive and has 2 or 3 surrounding live neighbours
				if (value = true && (cellNumber == 3 || cellNumber == 2))
					temp.get(i).set(j, true);
				// rule #2: if cell is dead but has 3 surrounding live neighbours
				else if (value = false && cellNumber == 3)
					temp.get(i).set(j, true);
				// rule #3: if cell does not fulfill the conditions for survival
				else
					temp.get(i).set(j, false);
			}
		}
		valuesList = temp;
	}

	// TODO: edit to be place of boolean values
	// take coordinates x, y and return number of live neighboring cells
	public int returnLiveNeighbours(int x, int y) {
		int counter = 0;
		// check north
		// check south
		// check east
		// check west
		// check northeast
		// check northwest
		// check southeast
		// check southwest
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

	public ArrayList<ArrayList<Boolean>> getValuesList() {
		return valuesList;
	}

	public void setValuesList(ArrayList<ArrayList<Boolean>> valuesList) {
		this.valuesList = valuesList;
	}

}
