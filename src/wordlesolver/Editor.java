package wordlesolver;

import javafx.scene.input.KeyCode;

public class Editor 
{
	private static Guess focusedGuess;
		
	public static void focusGuess(Guess guess)
	{
		if (guess == focusedGuess)
			return;
		
		if (focusedGuess != null)
			focusedGuess.onUnfocused();
				
		focusedGuess = guess;
		focusedGuess.onFocused();
	}
	
	public static void onKeyPressed(KeyCode keyCode)
	{
		switch (keyCode)
		{
		case ENTER:
		case DOWN:
			if (focusedGuess.index + 1 != Constants.NUM_GUESSES)
				focusGuess(WordleBoard.instance().getGuess(focusedGuess.index + 1));
			break;
			
		case UP:
			if (focusedGuess.index != 0)
				focusGuess(WordleBoard.instance().getGuess(focusedGuess.index - 1));
			break;
			
		case BACK_SPACE:
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
			break;
			
		default:
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
			break;
		}
	}
	
	
}
