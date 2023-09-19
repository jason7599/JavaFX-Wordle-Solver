package wordlesolver;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class CharTile extends StackPane
{
	private static final double SIZE = 125;
	private static final Font FONT = new Font("Arial Black", 50);
	
	private Text charText;
	private char myChar;
	private TileEvaluation evaluation;
	private GrowShrinkAnimation inputAnim;
	
	public CharTile()
	{
		this.setPrefSize(SIZE, SIZE);
		
		charText = new Text();
		charText.setFont(FONT);
		charText.setFill(Color.WHITE);
		
		this.getChildren().add(charText);
		
		inputAnim = new GrowShrinkAnimation(this, Duration.seconds(0.1), 0.125);
		
		setEvaluation(TileEvaluation.NONE);
		
		this.setOnMouseClicked(e -> setEvaluation(TileEvaluation.WRONG));
	}
	
	public void setChar(char c)
	{
		charText.setText(String.valueOf(c));
		myChar = c;
		if (myChar != ' ')
			inputAnim.play();
	}
	
	public void setEvaluation(TileEvaluation evaluation)
	{
		this.evaluation = evaluation;
		this.setBackground(evaluation.backgroundStyle);
		this.setBorder(evaluation.borderStyle);
	}
	
	public TileEvaluation getEvaluation()
	{
		return evaluation;
	}
}
