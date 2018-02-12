import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.application.Application;

public class Noughts_Crosses extends Application {

	@Override
	public void start(Stage primaryStage) {

		GridPane grid = new GridPane();
		Button foo = new Button("");
		grid.add(foo, 0, 0);

		Scene scene = new Scene(grid, 250, 250);
		
		primaryStage.setTitle("Noughts and Crosses");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	
	
	public static void main(String[] args) {
		
		launch(args);
		
	}

}
