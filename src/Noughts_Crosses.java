import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
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

	public boolean winnerCheck1(String player) {

		// Check if there is a win on the first vertical column
		if (b[0][0].getText() == player) {
			if (b[0][1].getText() == player) {
				if (b[0][2].getText() == player) {
					end = true;
				}
			}
		}
		return end;
	}

	public boolean winnerCheck2(String player) {

		// Check if there is a win on the second vertical column
		if (b[1][0].getText() == player) {
			if (b[1][1].getText() == player) {
				if (b[1][2].getText() == player) {
					end = true;
				}
			}
		}
		return end;
	}

	public boolean winnerCheck3(String player) {

		// Check if there is a win on the third vertical column
		if (b[2][0].getText() == player) {
			if (b[2][1].getText() == player) {
				if (b[2][2].getText() == player) {
					end = true;
				}
			}
		}
		return end;
	}

	public boolean winnerCheck4(String player) {

		// Check if there is a win on the first horizontal row
		if (b[0][0].getText() == player) {
			if (b[1][0].getText() == player) {
				if (b[2][0].getText() == player) {
					end = true;
				}
			}
		}
		return end;
	}

	public boolean winnerCheck5(String player) {

		// Check if there is a win on the second horizontal row
		if (b[0][1].getText() == player) {
			if (b[1][1].getText() == player) {
				if (b[2][1].getText() == player) {
					end = true;
				}
			}
		}
		return end;
	}

	public boolean winnerCheck6(String player) {

		// Check if there is a win on the third horizontal row
		if (b[0][2].getText() == player) {
			if (b[1][2].getText() == player) {
				if (b[2][2].getText() == player) {
					end = true;
				}
			}
		}
		return end;
	}

	public boolean winnerCheck7(String player) {

		// Check if there is a diagonal win (downwards)
		if (b[0][0].getText() == player) {
			if (b[1][1].getText() == player) {
				if (b[2][2].getText() == player) {
					end = true;
				}
			}
		}
		return end;
	}

	public boolean winnerCheck8(String player) {

		// Check if there is a diagonal win (upwards)
		if (b[2][0].getText() == player) {
			if (b[1][1].getText() == player) {
				if (b[0][2].getText() == player) {
					end = true;
				}
			}
		}
		return end;
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
						String xPlayer = "X";
						String oPlayer = "O";
						String player = "";
						if (turnCounter % 2 == 0) {
							player = xPlayer;
						} else {
							player = oPlayer;
						}
						if (turnCounter <= 9) {
							b[x][y].setText(player);
							turnCounter = turnCounter + 1;
						}
						System.out.println(turnCounter);
						// Check whether there is a winner
						winnerCheck1(player);
						winnerCheck2();
						winnerCheck3();
						winnerCheck4();
						winnerCheck5();
						winnerCheck6();
						winnerCheck7();
						winnerCheck8();
						if (end == true) {
							System.out.println("Game is over. There is a winner.");
						}
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
