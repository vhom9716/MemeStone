package cards;

import java.util.List;

import guiPlayer.CustomPane;
import guiTeacher.components.Button;
import guiTeacher.components.TextArea;
import guiTeacher.components.TextField;
import guiTeacher.components.TextLabel;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class EditorScreen extends FullFunctionScreen {

	private Deck currentDeck;
	private DeckPane pane;
	private TextArea deckName;
	private int deckSize = Deck.deck.size();
	private String name = "LOL";
	private TextArea deckCapacity;
	private TextArea pageNumber;
	private Button pageLeft;
	private Button pageRight;
	
	public EditorScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		pane = new DeckPane(this, 1000, 100,150,600);
		pane.update();
		deckName = new TextArea(1000, 40, 150, 40, "LOL");
		deckCapacity = new TextArea(1000,700,150,40,deckSize+"/15");
		viewObjects.add(pane);
		viewObjects.add(deckName);
		viewObjects.add(deckCapacity);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
