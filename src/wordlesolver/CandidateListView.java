package wordlesolver;

import javafx.scene.control.ListView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;

public class CandidateListView extends BorderPane
{
	public CandidateListView()
	{
		this.setBackground(Background.fill(Colors.BACKGROUND));
		
		ListView<String> listView = new ListView<>(WordsList.candidates());
		listView.setFocusTraversable(false);
		
		this.setCenter(listView);
	}
}
