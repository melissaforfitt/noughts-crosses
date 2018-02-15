import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Noughts_Crosses extends Application {

	Button b[][] = new Button[3][3];
	GridPane grid = new GridPane();
	int turnCounter = 0;

	public void buildGrid() {

		// Make 9 buttons
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				b[i][j] = new Button();
				b[i][j].setMinWidth(100);
				b[i][j].setMinHeight(100);
				grid.add(b[i][j], i, j);

			}
		}
	}

	public void checkWinner() {

	}

	@Override
	public void start(Stage primaryStage) {

		buildGrid();

		// Make buttons clickable for X and O to appear on relevant turn

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int x = i;
				int y = j;

				b[i][j].setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						if (turnCounter >= 5) {
							// Check whether there is a winner
						}
						if (turnCounter % 2 == 0) {
							b[x][y].setText("X");
							turnCounter = turnCounter + 1;
						} else {
							b[x][y].setText("O");
							turnCounter = turnCounter + 1;
						}
						System.out.println(turnCounter);
					}
				});
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
