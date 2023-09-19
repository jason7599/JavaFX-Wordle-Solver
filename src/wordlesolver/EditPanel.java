package wordlesolver;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class EditPanel extends HBox
{
	
	public EditPanel()
	{
		EditButton editGuessesButton = new EditButton("Edit Guesses", EditMode.GUESSES);
		EditButton editTilesButton = new EditButton("Edit Tiles", EditMode.TILES);
		super.getChildren().addAll(editGuessesButton, editTilesButton);
	}
	
	private static class EditButton extends Button
	{
		static final double HEIGHT = 100;
		EditButton(String text, EditMode editMode)
		{
			super(text);
			HBox.setHgrow(this, Priority.ALWAYS);
			super.setMaxWidth(Double.MAX_VALUE);
			super.setPrefHeight(HEIGHT);
			super.setOnAction(e -> Editor.setEditMode(editMode));
			super.setFocusTraversable(false);
		}
	}
}
