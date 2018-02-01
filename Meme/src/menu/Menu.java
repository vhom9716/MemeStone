package menu;

import battle.BattleScreen;
import cards.DeckBuilderScreen;
import cards.EditorScreen;
import guiTeacher.GUIApplication;
import guiTeacher.userInterfaces.Screen;


public class Menu extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2452328323352199392L;
	public static Thread go;

	public Menu(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}
	
	 public static Menu menu;

	
	public static void main(String[] args){
		menu = new Menu(1440, 824);
		go = new Thread(menu);
		go.start();
	}

    public static MenuScreen screen1; 

    public static ShopScreen screen2;
    
    public static BattleScreen screen3;
	
    public static EditorScreen screen4;
	 
	@Override
	public void initScreen() {
		screen1 = new MenuScreen(1440, 824);
		screen2 = new ShopScreen(getWidth(), getHeight());
		screen3 = new BattleScreen(1440, 824);
		screen4 = new EditorScreen(1800, 1300);
		setScreen(screen1);
	}
}