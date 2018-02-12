import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Noughts_Crosses extends Application {

	public void buildGrid() {

	}

	public boolean markedX() { 

		boolean x = true;

		return x;

	}

	public boolean markedY() {

		boolean y = true;

		return y;

	}

	public boolean end() {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if ()
				boolean end = true;
			} 
		} boolean end = false;

		

		return end;

	}

	@Override
	public void start(Stage primaryStage) {

		buildGrid();
		
		// Build grid
		GridPane grid = new GridPane();
		
		// Make 9 buttons
		Button[][] b = new Button[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				b[i][j] = new Button();
				b[i][j].setMinWidth(100);
				b[i][j].setMinHeight(100);
				grid.add(b[i][j], i, j);

			}
		}
		
		// Change button text when clicked
		b[i][j].setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				b[i][j].setText("X");
				markedX();
				b[i][j].setText("O");
				markedY();
			}
		}

	// Create scene
	Scene scene = new Scene(grid, 300, 300);

	primaryStage.setTitle("Noughts and Crosses");
	primaryStage.setScene(scene);
	primaryStage.show();

	}

	public static void main(String[] args) {

		// Show graphics
		launch(args);

	}

}
