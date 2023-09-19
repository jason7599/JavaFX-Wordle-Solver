package wordlesolver;

import javafx.scene.input.KeyCode;

public class Editor 
{
	private static EditMode editMode = EditMode.GUESSES;
	private static Guess focusedGuess;
		
	public static void setEditMode(EditMode _editMode)
	{
		if (_editMode == editMode)
			return;
		
		if (_editMode == EditMode.TILES)
		{
			if (focusedGuess != null)
				focusedGuess.onUnfocused();
			focusedGuess = null;
		}
		
		editMode = _editMode;
		System.out.println(editMode.name());
	}
	
	public static void onGuessClicked(Guess guess)
	{
		if (editMode != EditMode.GUESSES)
			return;
	
		if (guess == focusedGuess)
			return;
		
		if (focusedGuess != null)
			focusedGuess.onUnfocused();
		
		focusedGuess = guess;
		focusedGuess.onFocused();
	}
	
	public static void onKeyPressed(KeyCode keyCode)
	{
		if (editMode != EditMode.GUESSES)
			return;
		
		if (focusedGuess == null)
			return;
		
		
	}
}
