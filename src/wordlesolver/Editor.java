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
	}
	
	public static void focusGuess(Guess guess)
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
				
		if (keyCode.isLetterKey())
		{
			// focusedGuess at max length, 
			if (focusedGuess.getString().length() == Constants.WORD_LENGTH)
			{
				// shift focus to the next guess if it exists
				if (focusedGuess.index + 1 != WordleBoard.NUM_GUESSES)
					focusGuess(WordleBoard.instance().getGuess(focusedGuess.index + 1));
				else
					return;
			}
			focusedGuess.appendChar((char)keyCode.getCode());
		}
		else if (keyCode == KeyCode.BACK_SPACE)
		{
			
		}
		else if (keyCode == KeyCode.ENTER)
		{
			
		}
	}
}
