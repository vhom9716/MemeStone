package battle;

import guiTeacher.GUIApplication;

public class BattleGUI extends GUIApplication {
	public static BattleGUI gui;
	public static BattleScreen battleScreen;
	
	public BattleGUI(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initScreen() {
		
		battleScreen = new BattleScreen(getWidth(), getHeight());
		setScreen(battleScreen);
	}

	public static void main(String[] args) {
		gui = new BattleGUI(1200,800);
		Thread go = new Thread(gui);
		go.start();
	
	}

}
