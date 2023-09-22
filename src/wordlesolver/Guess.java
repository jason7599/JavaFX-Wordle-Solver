package wordlesolver;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Guess extends HBox
{
	public final int index;
	private CharTile[] charTiles;
	private String string = "";
	private GrowShrinkAnimation focusAnim;
	
	public Guess(int index)
	{
		this.index = index;
		
		charTiles = new CharTile[Constants.WORD_LENGTH];
		for (int i = 0; i < Constants.WORD_LENGTH; i++)
		{
			CharTile charTile = charTiles[i] = new CharTile();
			this.getChildren().add(charTile);
		}
		
		this.setPadding(new Insets(20));
		this.setAlignment(Pos.CENTER);
		
		focusAnim = new GrowShrinkAnimation(this, Duration.seconds(0.25), 0.125);
	}
	
	public void onFocused()
	{
		// TEMP
		this.setBorder(Border.stroke(Color.RED));
		focusAnim.play();
	}
	
	public void onUnfocused()
	{
		this.setBorder(null);
	}
	
	public String getString()
	{
		return string;
	}
	
	public void appendChar(char c)
	{
		charTiles[string.length()].setChar(c);
		string += c;
	}
	
	public void removeChar()
	{
		string = string.substring(0, string.length() - 1);
		charTiles[string.length()].setChar(' ');
	}
	
	/*
	 * Based on the current evaluations,
	 * check whether the given word matches the criteria
	 */
	public boolean testWord(String word)
	{
		for (int charIndex = 0; charIndex < Constants.WORD_LENGTH; charIndex++)
		{
			CharTile charTile = charTiles[charIndex];
			switch (charTile.getEvaluation())
			{
			case NONE: 
				break;
				
			case CORRECT:
				if (word.charAt(charIndex) != charTile.getChar())
					return false;
				break;
				
			case WRONG_SPOT:
				if (word.charAt(charIndex) == charTile.getChar())
					return false;
				if (!word.contains(String.valueOf(charTile.getChar())))
					return false;
				break;
				
			case WRONG:
				if (word.contains(String.valueOf(charTile.getChar())))
					return false;
			}
		}
		
		return true;
	}
	
	public void clear()
	{
		while (!string.isEmpty())
			removeChar();
	}
}
