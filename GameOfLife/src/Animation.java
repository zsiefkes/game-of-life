import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Animation extends Application {

	public static LinkedList<Cell> cells = new LinkedList<>();
	public ArrayList<Rectangle> rectangles = new ArrayList<>();
	// size
	public static final int SIZE = 5;
	// screen width
	public static final int WINDOW_WIDTH = 300;
	// screen height
	public static final int WINDOW_HEIGHT = 300;

	// return rectangles
	// FIXME: edit getCells to return a group
	public void getRectangles() {
		for (Cell cell : cells) {
			Rectangle rect = new Rectangle();
			rect.setX(cell.getX() * SIZE + (WINDOW_WIDTH / 2));
			rect.setY(cell.getY() * SIZE + (WINDOW_HEIGHT / 2));
			rect.setHeight(SIZE);
			rect.setWidth(SIZE);
			rectangles.add(rect);
		}
	}
	
	public void drawCells() {
		
	}

	public void drawGrid() {
		// TODO: draw grid
	}

	// update status of cells
	public void update() {
		/* 
		 * Rule #1: If the cell is alive in this generation, and it has 2 or 3 alive
		 * neighbours (in all 8 directions), then it should stay alive in the next
		 * generation.
		 */
		/*
		 * Rule #2: If the cell is dead in this generation, and it has 3 alive
		 * neighbours (in all 8 directions), then it should become alive in the next
		 * generation.
		 */
		/*
		 * Rule #3: Otherwise, the cell should be dead in the next generation.
		 */
		for (Cell cell : cells) {
			// rule #1: if cell is alive
			if (cell.isAlive()) {
				int cellNumber = returnLiveNeighbours(cell);
				if (cellNumber == 3 || cellNumber == 2)
					cell.makeAlive();
				else
					cell.makeDead(); // rule #3
			}
			// rule #2: if cell is dead
			else if (cell.isDead()) {
				int cellNumber = returnLiveNeighbours(cell);
				if (cellNumber == 3)
					cell.makeAlive();
				else
					cell.makeDead(); // rule #3
			}
		}
	}

	// return number of cells surrounding neighbour
	public int returnLiveNeighbours(Cell cell) {
		int counter = 0;
		for (Cell neighbourCell : cell.getNeighbourCells()) {
			if (neighbourCell.isAlive())
				counter++;
		}
		return counter;
	}

	// updates game and then draws cell
	public void runGame() {
		update();
		drawGrid();
		drawCells();	
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO:
		// create window & canvas

		// group.addChildren.addAll(rectangles);
		
		
		// create keyframe and timeline,
		// call runGame() every x frames
	}

	public static void main(String[] args) {
		Application.launch();
	}

}
