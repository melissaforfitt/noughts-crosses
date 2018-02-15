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
	boolean end = false;

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

	public void checkWinnerO() {

		// Checks if there is a diagonal win
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (b[i][j].getText() == "O") {
					if (b[i + 1][j + 1].getText() == "O") {
						if (b[i + 2][j + 2].getText() == "O") {
							end = true;
						}
					}
				}
				// Checks if there is a horizontal win
				if (b[i + 1][j].getText() == "O") {
					if (b[i + 2][j].getText() == "O") {
						end = true;
					}
				}
				// Checks if there is a vertical win
				if (b[i][j + 1].getText() == "O") {
					if (b[i][j + 2].getText() == "O") {
						end = true;
					}
				}
			}
		}
	}

	public void checkWinnerX() {

		// Checks if there is a diagonal win
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (b[i][j].getText() == "X") {
					if (b[i + 1][j + 1].getText() == "X") {
						if (b[i + 2][j + 2].getText() == "X") {
							end = true;
						}
					}
				}
				// Checks if there is a horizontal win
				if (b[i + 1][j].getText() == "X") {
					if (b[i + 2][j].getText() == "X") {
						end = true;
					}
				}
				// Checks if there is a vertical win
				if (b[i][j + 1].getText() == "X") {
					if (b[i][j + 2].getText() == "X") {
						end = true;
					}
				}
			}
		}

	}

	public void markX() {

	}

	public void markO() {

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
						if (turnCounter <= 9) {
							if (turnCounter >= 5 & turnCounter <= 9) {
								// Check whether there is a winner
								checkWinnerO();
								checkWinnerX();
								if (end = true) {
									// Output end of game
								}
							}
							end = false;
							if (turnCounter % 2 == 0) {
								b[x][y].setText("X");
								turnCounter = turnCounter + 1;
							} else {
								b[x][y].setText("O");
								turnCounter = turnCounter + 1;
							}
							System.out.println(turnCounter);
						}
						end = true;
						System.out.println("Game is over");
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
