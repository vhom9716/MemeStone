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
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		gui = new BattleGUI(800,800);
		Thread go = new Thread(gui);
		go.start();
	
	}

}
