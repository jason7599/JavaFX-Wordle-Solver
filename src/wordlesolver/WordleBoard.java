package wordlesolver;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
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
	
	private static final double TILE_GAP = 15;
	
	private Guess[] guesses;
	
	private WordleBoard()
	{
		this.setBackground(Background.fill(Colors.BACKGROUND));
		this.setPadding(new Insets(75));
		
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
		
		Button clearButton = new Button("Reset");
		clearButton.setFocusTraversable(false);
		clearButton.setOnAction(e -> clear());
		clearButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		HBox.setHgrow(clearButton, Priority.ALWAYS);
		
		Region spacer = new Region();
		spacer.setMaxWidth(30);
		HBox.setHgrow(spacer, Priority.ALWAYS);
		
		Button solveButton = new Button("Solve");
		solveButton.setFocusTraversable(false);
		HBox.setHgrow(solveButton, Priority.ALWAYS);
		solveButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		solveButton.setOnAction(e -> solve());
		
		HBox buttonsHB = new HBox(clearButton, spacer, solveButton);
		buttonsHB.setAlignment(Pos.CENTER);
		buttonsHB.setPrefHeight(100);
		BorderPane.setAlignment(buttonsHB, Pos.CENTER);
		BorderPane.setMargin(buttonsHB, new Insets(25));
		
		this.setBottom(buttonsHB);
	}
	
	public Guess getGuess(int index)
	{
		return guesses[index];
	}
	
	private void clear()
	{
		WordsList.resetCandidates();
		for (Guess guess : guesses)
			guess.clear();
		Editor.focusGuess(guesses[0]);
	}
	
	private void solve()
	{
		WordsList.resetCandidates();
		WordsList.candidates().removeIf(word ->
		{
			for (Guess guess : guesses)
			{
				if (!guess.testWord(word))
					return true;
			}
			return false;
		});
//		WordsList.candidates().filtered(word ->
//		{
//			return false;
//		});
	}
}
