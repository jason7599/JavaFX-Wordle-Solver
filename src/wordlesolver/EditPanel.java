package wordlesolver;

import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class EditPanel extends HBox
{
	public EditPanel()
	{
		this.setSpacing(17.5);
		for (TileEvaluation evaluation : TileEvaluation.values())
		{
			EditOption editOption = new EditOption(evaluation);
			this.getChildren().add(editOption);
		}
	}
	
	static class EditOption extends StackPane
	{
		static final double SIZE = 150;
		static final Font FONT = Font.font("Arial", FontWeight.BOLD, 30);
		
		EditOption(TileEvaluation evaluation)
		{
			this.setPrefSize(SIZE, SIZE);
			this.setBackground(evaluation.backgroundStyle);
			this.setBorder(Border.stroke(Colors.TILE_BORDER));
			
			Text descriptionText = new Text(evaluation.description);
			descriptionText.setFill(Colors.TILE_FONT);
			descriptionText.setWrappingWidth(SIZE);
			descriptionText.setFont(FONT);
			descriptionText.setTextAlignment(TextAlignment.CENTER);
			this.getChildren().add(descriptionText);
		}
	}
}
