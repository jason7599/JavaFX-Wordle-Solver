package wordlesolver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class WordsList 
{
	private static final String WORDS_FILE_PATH = "src/res/words_alpha.txt";
	private static List<String> wordsAll;
	private static ObservableList<String> candidates;

	public static void init() throws Exception
	{
		if (wordsAll != null)
			return;
		
		BufferedReader reader = new BufferedReader(new FileReader(WORDS_FILE_PATH));
		wordsAll = new ArrayList<>();
		String word;
		while ((word = reader.readLine()) != null)
		{
			if (word.length() == Constants.WORD_LENGTH)
				wordsAll.add(word.toUpperCase());
		}
		reader.close();
		
		Collections.shuffle(wordsAll);
		candidates = FXCollections.observableArrayList(wordsAll);
	}
	
	public static void resetCandidates()
	{
		Collections.shuffle(wordsAll);
		candidates.setAll(wordsAll);
	}
	
	public static ObservableList<String> candidates()
	{
		return candidates;
	}
}
