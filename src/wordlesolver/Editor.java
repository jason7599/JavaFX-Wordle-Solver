package wordlesolver;

import javafx.scene.input.KeyCode;

public class Editor 
{
	private static EditMode editMode = EditMode.GUESSES;
	private static Guess focusedGuess;
		
	public static void focusGuess(Guess guess)
	{
		if (guess == focusedGuess)
			return;
		
		if (focusedGuess != null)
			focusedGuess.onUnfocused();
		
		if (guess != null)
			guess.onFocused();
		
		focusedGuess = guess;
	}
	
	public static void setEditMode(EditMode _editMode)
	{
		if (_editMode == editMode)
			return;
		
		if (_editMode == EditMode.TILES)
		{
			focusGuess(null);
		}
		else if (_editMode == EditMode.GUESSES)
		{
			// upon transitioning from tile edit mode to guess edit mode,
			// automatically focus on the last non empty guess
			// if every guess is empty, focus on the first guess
			Guess newFocusGuess = null;
			for (int i = Constants.NUM_GUESSES - 1; i >= 0; i--)
			{
				if (!WordleBoard.instance().getGuess(i).getString().isBlank())
				{
					newFocusGuess = WordleBoard.instance().getGuess(i);
					break;
				}
			}
			focusGuess(newFocusGuess != null ? newFocusGuess : WordleBoard.instance().getGuess(0));
		}

		editMode = _editMode;
	}
	
	public static EditMode getEditMode()
	{
		return editMode;
	}
	
	public static void onKeyPressed(KeyCode keyCode)
	{
		if (editMode != EditMode.GUESSES)
			return;
		
		if (keyCode.isLetterKey())
		{
			// focusedGuess at max length, 
			if (focusedGuess.getString().length() == Constants.WORD_LENGTH)
			{
				// shift focus to the next guess if it exists
				if (focusedGuess.index + 1 != Constants.NUM_GUESSES)
					focusGuess(WordleBoard.instance().getGuess(focusedGuess.index + 1));
				else
					return;
			}
			if (focusedGuess.getString().length() != Constants.WORD_LENGTH)
				focusedGuess.appendChar((char)keyCode.getCode());
		}
		else if (keyCode == KeyCode.BACK_SPACE)
		{
			if (focusedGuess.getString().length() == 0)
			{
				if (focusedGuess.index != 0)
					focusGuess(WordleBoard.instance().getGuess(focusedGuess.index - 1));
				else
					return;
			}
			// Additional check
			if (focusedGuess.getString().length() != 0)
				focusedGuess.removeChar();
		}
		else if (keyCode == KeyCode.ENTER || keyCode == KeyCode.DOWN)
		{
			if (focusedGuess.index + 1 != Constants.NUM_GUESSES)
				focusGuess(WordleBoard.instance().getGuess(focusedGuess.index + 1));
		}
		else if (keyCode == KeyCode.UP)
		{
			if (focusedGuess.index != 0)
				focusGuess(WordleBoard.instance().getGuess(focusedGuess.index - 1));
		}
	}
	
	
}
