package wordlesolver;

import javafx.geometry.Insets;
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
			super.getChildren().add(charTile);
		}
		
		super.setPadding(new Insets(20));
		focusAnim = new GrowShrinkAnimation(this, Duration.seconds(0.25), 0.125);
		super.setOnMouseClicked(e -> Editor.focusGuess(this));
	}
	
	public void onFocused()
	{
		super.setBorder(Border.stroke(Color.RED));
		focusAnim.play();
	}
	
	public void onUnfocused()
	{
		super.setBorder(null);
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
		charTiles[string.length()].setBlank();
	}
}
