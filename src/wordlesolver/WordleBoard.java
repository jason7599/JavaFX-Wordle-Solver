package wordlesolver;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class WordleBoard extends BorderPane
{
	private static WordleBoard _instance;
	public static WordleBoard instance()
	{
		if (_instance == null)
			_instance = new WordleBoard();
		return _instance;
	}
	
	public static final int NUM_GUESSES = 5;
	public static final double TILE_GAP = 15;
	
	private Guess[] guesses;
	
	private WordleBoard()
	{
		EditPanel editPanel = new EditPanel();
		BorderPane.setMargin(editPanel, new Insets(25));
		super.setTop(editPanel);
		
		guesses = new Guess[NUM_GUESSES];
		VBox guessesVB = new VBox(TILE_GAP);
		for (int i = 0; i < NUM_GUESSES; i++)
		{
			Guess guess = guesses[i] = new Guess(i);
			guess.setSpacing(TILE_GAP);
			guessesVB.getChildren().add(guess);
		}
		
		super.setCenter(guessesVB);
		super.setPadding(new Insets(100));
	}
	
	public Guess getGuess(int index)
	{
		return guesses[index];
	}
}
