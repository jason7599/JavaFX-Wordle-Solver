package wordlesolver;

import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

public class EvaluationOption extends StackPane
{
	private static final double SIZE = 112.5;
	private static final Font FONT = Font.font("Arial", FontWeight.BOLD, 25);
	private static final Border DEFAULT_BORDER = new Border(new BorderStroke(Color.DIMGRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(2.5)));
	private static final Border SELECTED_BORDER = new Border(new BorderStroke(Color.CYAN, BorderStrokeStyle.SOLID, null, new BorderWidths(7.5)));
	
	public final TileEvaluation evaluation;
	
	private GrowShrinkAnimation selectAnim;
	
	public EvaluationOption(TileEvaluation evaluation)
	{
		this.evaluation = evaluation;
		
		this.setPrefSize(SIZE, SIZE);
		this.setBackground(evaluation.backgroundStyle);
		this.setBorder(DEFAULT_BORDER);
		
		Text descriptionText = new Text(evaluation.description);
		descriptionText.setFill(Colors.TILE_FONT);
		descriptionText.setWrappingWidth(SIZE);
		descriptionText.setFont(FONT);
		descriptionText.setTextAlignment(TextAlignment.CENTER);
		this.getChildren().add(descriptionText);
		
		selectAnim = new GrowShrinkAnimation(this, Duration.seconds(0.25), 0.25);
		
		this.setOnMouseClicked(e -> Editor.selectEvaluationOption(this));
	}
	
	public void onSelected()
	{
		this.setBorder(SELECTED_BORDER);
		selectAnim.play();
	}
	
	public void onDeselected()
	{
		this.setBorder(DEFAULT_BORDER);
	}
}
