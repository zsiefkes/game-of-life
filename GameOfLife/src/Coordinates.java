
public class Coordinates {
	int x, y;
	
	public Coordinates(int x, int y, World world) {
		super();
		this.x = x;
		this.y = y;
		world.getCoordinatesList().add(this);
	}

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
	
	
	
}
