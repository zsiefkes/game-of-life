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
	public static final int WINDOW_WIDTH = 700;
	// screen height
	public static final int WINDOW_HEIGHT = 400;
	// game animation is running boolean status
	boolean gameOn;

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
			Rectangle rect = new Rectangle(x, y, SIZE, SIZE);
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

	@Override
	public void start(Stage window) throws Exception {
		// TODO:
		World world = new World((int) (WINDOW_HEIGHT / SIZE), (int) (WINDOW_WIDTH / SIZE));
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
		gameOn = true;
		t.play();

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
			// reset world
			} else if (key.getCode() == KeyCode.R) {
				
			}
		});

		window.setResizable(false);
		window.setScene(scene);
		window.show();
	}

	public static void main(String[] args) {
		Application.launch();
	}

}
