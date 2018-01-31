package cards;

import java.awt.Window;

import guiTeacher.GUIApplication;
import guiTeacher.userInterfaces.Screen;
import menu.MenuScreen;

public class DeckEditorGUI extends GUIApplication {

	public static DeckEditorGUI sample;
	
	public static MenuScreen screen1;


	
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
		sample = new DeckEditorGUI(1800, 1300);
		Thread go = new Thread(sample);
		go.start();
		
	}
}
