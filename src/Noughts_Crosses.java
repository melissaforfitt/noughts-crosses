import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Noughts_Crosses extends Application {

	Button b[][] = new Button[3][3];
	GridPane grid = new GridPane();
	int turnCounter = 0;
	boolean end = false;
	boolean used[][] = new boolean[3][3];

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
						boolean played = false;
						String xPlayer = "X";
						String oPlayer = "O";
						String player = "";

						// User's turn
						if (turnCounter % 2 == 0) {
							while (played == false) {
								if (used[x][y] == true) {
									Text error = new Text("Space taken");
									grid.add(error, 0, 155);
									played = false;
								}
								player = xPlayer;
								b[x][y].setText(player);
								used[x][y] = true;
								played = true;
							}
							turnCounter = turnCounter + 1;
						}
						// Computer's turn
						player = oPlayer;
						played = false;
						while (played == false) {
							Random r = new Random();
							int c = r.nextInt(2) + 1;
							int d = r.nextInt(2) + 1;
							if (used[c][d] == true) {
								c = r.nextInt(2) + 0;
								d = r.nextInt(2) + 0;
							} else {
								b[c][d].setText(player);
								used[c][d] = true;
								played = true;
							}
						}
						turnCounter = turnCounter + 1;

						System.out.println(turnCounter);

						// Check whether there is a winner
						winnerCheck1(player);
						winnerCheck2(player);
						winnerCheck3(player);
						winnerCheck4(player);
						winnerCheck5(player);
						winnerCheck6(player);
						winnerCheck7(player);
						winnerCheck8(player);
						if (end == true) {
							Text text1 = new Text("Game over.");
							grid.add(text1, 0, 155);
							Text text2 = new Text(player + " is the winner.");
							grid.add(text2, 0, 165);
							System.out.println("Game over. " + player + " is the winner.");
						}

					}
				});

				// Set up a refresh button for a new game
				Button newGame = new Button("New Game");
				grid.add(newGame, 0, 175);
				newGame.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent e) {
						// Code for clearing grid
						for (int i = 0; i < 3; i++) {
							for (int j = 0; j < 3; j++) {
								b[i][j].setText(" ");
								turnCounter = 0;
							}
						}
					}
				});
			}
		}

		// Create scene
		Scene scene = new Scene(grid, 300, 360);

		primaryStage.setTitle("Noughts and Crosses");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {

		// Show graphics
		launch(args);

	}
}
