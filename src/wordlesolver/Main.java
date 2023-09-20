package wordlesolver;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;

public class Main extends Application 
{
	@Override
	public void start(Stage stage) 
	{
		try
		{
			WordsList.init();
		}
		catch (Exception e)
		{
			System.err.println("Failed to initialize Wordle Dictionary!");
			System.exit(-1);
		}
		
		Parent root = new HBox(WordleBoard.instance(), new CandidateListView());
		stage.setScene(new Scene(root));
		stage.getScene().setOnKeyPressed(e -> Editor.onKeyPressed(e.getCode()));
		stage.setTitle("Wordle Solver");
		stage.setResizable(false);
		stage.show();
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
}
