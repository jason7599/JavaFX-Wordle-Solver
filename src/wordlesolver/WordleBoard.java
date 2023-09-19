package wordlesolver;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class WordleBoard extends BorderPane
{
	public static final int NUM_GUESSES = 5;
	
	public static final double TILE_GAP = 15;
	
	public WordleBoard()
	{
		EditPanel editPanel = new EditPanel();
		BorderPane.setMargin(editPanel, new Insets(25));
		super.setTop(editPanel);
		
		VBox guesses = new VBox(TILE_GAP);
		for (int i = 0; i < NUM_GUESSES; i++)
		{
			Guess guess = new Guess(i);
			guess.setSpacing(TILE_GAP);
			guesses.getChildren().add(guess);
		}
		
		super.setCenter(guesses);
		super.setPadding(new Insets(100));
		super.setOnKeyPressed(e -> Editor.onKeyPressed(e.getCode()));
	}
}
