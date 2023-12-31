package wordlesolver;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class CharTile extends StackPane
{
	private static final double SIZE = 100;
	private static final Font FONT = new Font("Arial Black", 50);
	
	private Text charText;
	private char myChar = ' ';
	private TileEvaluation evaluation;
	private GrowShrinkAnimation inputAnim;
	
	public CharTile()
	{
		this.setPrefSize(SIZE, SIZE);
		
		charText = new Text();
		charText.setFont(FONT);
		charText.setFill(Colors.TILE_FONT);
		
		this.getChildren().add(charText);
		
		inputAnim = new GrowShrinkAnimation(this, Duration.seconds(0.1), 0.125);
		
		setEvaluation(TileEvaluation.NONE);
		
		this.setOnMouseClicked(e -> Editor.onCharTileClicked(this));
	}
	
	public void setChar(char c)
	{
		charText.setText(String.valueOf(c));
		if (c == ' ')
			setEvaluation(TileEvaluation.NONE);
		else
			inputAnim.play();
		myChar = c;
	}
	
	public char getChar()
	{
		return myChar;
	}
	
	public void setEvaluation(TileEvaluation evaluation)
	{
		if (evaluation == this.evaluation)
			return;
		
		this.evaluation = evaluation;
		this.setBackground(evaluation.backgroundStyle);
		this.setBorder(evaluation.borderStyle);
		
		if (evaluation != TileEvaluation.NONE)
			inputAnim.play();
	}
	
	public TileEvaluation getEvaluation()
	{
		return evaluation;
	}
}
