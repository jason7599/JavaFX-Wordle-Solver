package wordlesolver;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class EditPanel extends HBox
{
	public EditPanel()
	{
		this.setSpacing(20);
		this.setAlignment(Pos.CENTER);
		for (TileEvaluation evaluation : TileEvaluation.values())
		{
			EvaluationOption evaluationOption = new EvaluationOption(evaluation);
			this.getChildren().add(evaluationOption);
			
			if (evaluation == TileEvaluation.NONE)
				Editor.selectEvaluationOption(evaluationOption);
		}
	}

}
