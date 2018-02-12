import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Noughts_Crosses extends Application {

	// Build grid
	GridPane grid = new GridPane();

	// Make 9 buttons
	public void buildGrid() {
		final Button[][] b = new Button[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				b[i][j] = new Button();
				b[i][j].setMinWidth(50);
				b[i][j].setMinHeight(50);
				grid.add(b[i][j], i, j);
			}
		}
	}

	@Override
	public void start(Stage primaryStage) {

		buildGrid();

		// Change button text when clicked
		b.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				b.setText("X");
				b.setText("O");
			}
		});
		

		// Create scene
		Scene scene = new Scene(grid, 150, 150);

		primaryStage.setTitle("Noughts and Crosses");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {

		// Show graphics
		launch(args);

	}

}
