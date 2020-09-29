import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
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

	public void drawGrid(World world, Group group) {
		// TODO: draw grid
		int rowNum = world.getRows();

		for (int i = 0; i < rowNum; i += SIZE) {
			Line line1 = new Line(i, 0, i, rowNum);
			line1.setStroke(Color.BLACK);
			Line line2 = new Line(0, i, rowNum, i);
			line2.setStroke(Color.BLACK);
			group.getChildren().addAll(line1, line2);
		}
	}

	// updates game and then draws cell
	public void runGame(World world) {
		world.update();
//		drawWorld();
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
