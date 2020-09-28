import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {

	// size
	public static final int SIZE = 5;
	// screen width
	public static final int WINDOW_WIDTH = 300;
	// screen height
	public static final int WINDOW_HEIGHT = 300;

	public void drawGrid() {
		// TODO: draw grid
	}

	// updates game and then draws cell
	public void runGame() {
//		world.update();
//		world.drawGame();
	}

	@Override
	public void start(Stage arg0) throws Exception {
		// TODO:
		World world = new World(WINDOW_WIDTH / SIZE, WINDOW_HEIGHT / SIZE);
		Group root = new Group();
		KeyFrame frame = new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		Timeline t = new Timeline(frame);
		t.setCycleCount(javafx.animation.Animation.INDEFINITE);
		// create keyframe and timeline,
		// call runGame() every x frames
	}

	public static void main(String[] args) {
		Application.launch();
	}

}
