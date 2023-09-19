package wordlesolver;

import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.paint.Color;

public enum TileEvaluation 
{
	NONE(Background.fill(Color.rgb(18, 18, 19)), new Border(new BorderStroke(Color.DIMGRAY, BorderStrokeStyle.SOLID, null, new BorderWidths(2.5)))),
	CORRECT(Background.fill(Color.rgb(83, 141, 78)), null),
	WRONG_SPOT(Background.fill(Color.rgb(181, 159, 59)), null),
	WRONG(Background.fill(Color.rgb(58, 58, 60)), null);
	
	public final Background backgroundStyle;
	public final Border borderStyle;
	
	private TileEvaluation(Background backgroundStlye, Border borderStyle)
	{
		this.backgroundStyle = backgroundStlye;
		this.borderStyle = borderStyle;
	}
}
