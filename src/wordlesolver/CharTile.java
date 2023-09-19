package wordlesolver;

import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class CharTile extends StackPane
{
	private static final double SIZE = 125;
	private static final Font FONT = new Font("Arial Black", 50);
	
	private Text charText;
	private char myChar;
	
	public CharTile()
	{
		super.setPrefSize(SIZE, SIZE);
		super.setBorder(Border.stroke(Color.BLACK));
		
		charText = new Text();
		charText.setFont(FONT);
		super.getChildren().add(charText);
	}
	
	public void setChar(char c)
	{
		charText.setText(String.valueOf(c));
		myChar = c;
	}
}
