
public class Cell {
	Cell left;
	Cell right;
	Cell up;
	Cell down;
	int x;
	int y;
	Boolean alive;

	public Cell() {
		x = 0;
		y = 0;
		alive = true;
	}
	
	public Cell(Cell origin, int x, int y) {
		this.x = x;
		this.y = y;
		if (origin.x == this.x) {
			if (this.y - origin.y == 1) {
				up = origin;
			} else if (this.y - origin.y == -1) {
				down = origin;
			}
		}
		else if (origin.y == this.y) {
			if (this.x - origin.x == 1) {
				left = origin;
			} else if (this.x - origin.x == -1) {
				right = origin;
			}
		}
	}

}
