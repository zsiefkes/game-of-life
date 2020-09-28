
public class Cell {
	private int x, y;
	private boolean alive;

	public Cell(int x, int y, World world) {
		this.x = x;
		this.y = y;
		this.alive = false;
		world.getCells().add(this);
	}

	// custom methods
	// change status of alive

	public boolean isAlive() {
		return this.alive = true;
	}

	public boolean isDead() {
		return this.alive = false;
	}

	public void setAlive() {
		this.alive = true;
	}

	public void setDead() {
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
}
