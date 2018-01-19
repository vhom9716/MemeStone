package cards;

import guiTeacher.GUIApplication;
import guiTeacher.userInterfaces.Screen;

public class DeckEditorGUI extends GUIApplication {

	public DeckEditorGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		EditorScreen screen = new EditorScreen(getWidth(),getHeight());
		setScreen(screen);
	}

	public static void main(String[] args) {
		DeckEditorGUI sample = new DeckEditorGUI(1200, 800);
		Thread go = new Thread(sample);
		go.start();
	}
	
}
