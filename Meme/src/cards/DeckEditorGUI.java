package cards;

import java.awt.Window;

import guiTeacher.GUIApplication;
import guiTeacher.userInterfaces.Screen;
import menu.MenuScreen;

public class DeckEditorGUI extends GUIApplication {
	
	public static MenuScreen screen1;
	public static EditorScreen screen2;

	public DeckEditorGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		screen2 = new EditorScreen(getWidth(),getHeight());
		setScreen(screen2);
	}

	public static void main(String[] args) {
		DeckEditorGUI sample = new DeckEditorGUI(1440, 824);
		Thread go = new Thread(sample);
		go.start();
		
	}
} 
 