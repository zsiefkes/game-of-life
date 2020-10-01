import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {

	// size
	public static final int SIZE = 20;
	// screen width
	public static final int WINDOW_WIDTH = 1000;
	// screen height
	public static final int WINDOW_HEIGHT = 600;
	// rows and columns input
	int rowsInput = (int) (WINDOW_HEIGHT / SIZE);
	int colsInput = (int) (WINDOW_WIDTH / SIZE);
	// game animation is running boolean status
	boolean gameOn;
	boolean normalSpeed;
	World world;
	String seedName = "glidergun.txt";
	// info text for the game
	String helpText = "SPACE: pause game\n" + "UP: toggle 2.0 speed\n" + "DOWN: toggle 0.5 speed\n" + "R: reset world\n"
			+ "H: help box\n" + "L: load new seed\n" + "C: input custom seed";

	private void drawGrid(Group group) {
		for (int i = 0; i < WINDOW_HEIGHT; i += SIZE) {
			Line line1 = new Line(0, i, WINDOW_WIDTH, i);
			line1.setStroke(Color.BLACK);
			group.getChildren().addAll(line1);
		}
		for (int i = 0; i < WINDOW_WIDTH; i += SIZE) {
			Line line1 = new Line(i, 0, i, WINDOW_HEIGHT);
			line1.setStroke(Color.BLACK);
			group.getChildren().addAll(line1);
		}
	}

	// TODO: draw rectangles based on where the coordinates are
	private void drawWorld(World world, Group group) {
		// draw the rectangles
		for (int i = 0; i < world.getCoordinatesList().size(); i++) {
			int x = world.getCoordinatesList().get(i).getX();
			int y = world.getCoordinatesList().get(i).getY();
			Rectangle rect = new Rectangle(x * SIZE, y * SIZE, SIZE, SIZE);
			rect.setFill(Color.color(Math.random(), Math.random(), Math.random())); // random color, change this if
																					// necessary
			group.getChildren().add(rect);
		}

		// draw the grid
		drawGrid(group);

	}

	// ##### TODO: cycle of events every frame: #####
	// 1. clear group
	// 2. update world
	// 3. draw world
	public void runGame(World world, Group group) {
		group.getChildren().clear();
		world.update();
		drawWorld(world, group);
	}

	private void resetWorld() {
		world = new World(rowsInput, colsInput, seedName);
	}

	@Override
	public void start(Stage window) throws Exception {
		// TODO:
		world = new World(rowsInput, colsInput, seedName);
		Group root = new Group();
		drawWorld(world, root);
		KeyFrame frame = new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				runGame(world, root);
			}

		});

		Timeline t = new Timeline(frame);
		t.setCycleCount(javafx.animation.Animation.INDEFINITE);
		t.play();
		gameOn = true;
		normalSpeed = true;

		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		// adding keyboard functionality
		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			// pause game
			if (key.getCode() == KeyCode.SPACE) { // space
				if (gameOn) {
					t.stop();
					gameOn = false;
				} else {
					t.play();
					gameOn = true;
				}
			}
			// double speed
			else if (key.getCode() == KeyCode.UP)
				if (normalSpeed) {
					t.setRate(2);
					normalSpeed = false;
				} else {
					t.setRate(1);
					normalSpeed = true;
				}
			// half speed
			else if (key.getCode() == KeyCode.DOWN)
				if (normalSpeed) {
					t.setRate(0.5);
					normalSpeed = false;
				} else {
					t.setRate(1);
					normalSpeed = true;
				}
			// reset world
			else if (key.getCode() == KeyCode.R) {
				resetWorld();
			}
			// help box of keyboard codes
			else if (key.getCode() == KeyCode.H) {
				AlertBox.display("Information", helpText);
			}
			// load new seed
			else if (key.getCode() == KeyCode.L) {
				if (gameOn) {
					t.stop();
					gameOn = false;
				}
				seedName = LoadSeedBox.display();
				resetWorld();
				t.play();
				gameOn = true;
			}
			// create custom seed
		});

		window.setResizable(false);
		window.setScene(scene);
		window.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}

}
