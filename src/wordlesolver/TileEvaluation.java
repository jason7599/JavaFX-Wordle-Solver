package wordlesolver;

import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;

public enum TileEvaluation 
{
	NONE(Background.fill(Colors.BACKGROUND), 
			new Border(new BorderStroke(Colors.TILE_BORDER, BorderStrokeStyle.SOLID, null, new BorderWidths(2.5))),
			"None"),
	
	CORRECT(Background.fill(Colors.CORRECT), 
			null,
			"Correct"),
	
	WRONG_SPOT(Background.fill(Colors.WRONG_SPOT),
			null,
			"Wrong Spot"),
	
	WRONG(Background.fill(Colors.WRONG), 
			null,
			"Wrong");
	
	public final Background backgroundStyle;
	public final Border borderStyle;
	public final String description;
	
	private TileEvaluation(Background backgroundStlye, Border borderStyle, String description)
	{
		this.backgroundStyle = backgroundStlye;
		this.borderStyle = borderStyle;
		this.description = description;
	}
}
