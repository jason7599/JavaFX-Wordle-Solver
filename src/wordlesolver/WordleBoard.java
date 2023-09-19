package wordlesolver;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class WordleBoard extends BorderPane
{
	private static WordleBoard _instance;
	public static WordleBoard instance()
	{
		if (_instance == null)
			_instance = new WordleBoard();
		return _instance;
	}
	
	public static final double TILE_GAP = 15;
	
	private Guess[] guesses;
	
	private WordleBoard()
	{
		this.setBackground(Background.fill(Color.rgb(18, 18, 19)));
		this.setPadding(new Insets(100));
		
		EditPanel editPanel = new EditPanel();
		BorderPane.setMargin(editPanel, new Insets(25));
		this.setTop(editPanel);
		
		guesses = new Guess[Constants.NUM_GUESSES];
		VBox guessesVB = new VBox(TILE_GAP);
		for (int i = 0; i < Constants.NUM_GUESSES; i++)
		{
			Guess guess = guesses[i] = new Guess(i);
			guess.setSpacing(TILE_GAP);
			guessesVB.getChildren().add(guess);
		}
		
		this.setCenter(guessesVB);
		
		Editor.focusGuess(guesses[0]);
	}
	
	public Guess getGuess(int index)
	{
		return guesses[index];
	}
}
