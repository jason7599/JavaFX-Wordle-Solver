package wordlesolver;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application 
{
	@Override
	public void start(Stage stage) 
	{
		stage.setScene(new Scene(WordleBoard.instance()));
		stage.getScene().setOnKeyPressed(e -> Editor.onKeyPressed(e.getCode()));
		stage.setResizable(false);
		stage.setTitle("Wordle Solver");
		stage.show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
