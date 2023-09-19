package wordlesolver;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
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
	private GrowShrinkAnimation inputAnim;
	
	public CharTile()
	{
		super.setPrefSize(SIZE, SIZE);
		super.setBorder(new Border(new BorderStroke(Color.DIMGRAY, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(3))));
		
		charText = new Text();
		charText.setFont(FONT);
		charText.setFill(Color.WHITE);
		super.getChildren().add(charText);
		
		inputAnim = new GrowShrinkAnimation(this, Duration.seconds(0.1), 0.125);
	}
	
	public void setChar(char c)
	{
		charText.setText(String.valueOf(c));
		myChar = c;
		if (myChar != ' ')
			inputAnim.play();
	}
}
