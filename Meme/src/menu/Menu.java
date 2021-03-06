
package menu;

import battle.BattleScreen;
import cards.EditorScreen;
import guiTeacher.GUIApplication;
import guiTeacher.userInterfaces.Screen;


public class Menu extends GUIApplication {
    public static MenuScreen screen1; 

    public static ShopScreen screen2;
    
    public static BattleScreen screen3; 
	
    public static EditorScreen screen4;
    
    public static BetterShopScreen screen5;
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
	 public int gold = 400;

	
	public static void main(String[] args){
		menu = new Menu(1440, 824);
		Thread go = new Thread(menu);
		go = new Thread(menu);
		go.start();
	}

	 
	@Override
	public void initScreen() {
		screen1 = new MenuScreen(getWidth(), getHeight());
		screen2 = new ShopScreen(getWidth(), getHeight());
		screen3 = new BattleScreen(1440, 824);
		screen4 = new EditorScreen(getWidth(), getHeight());
		screen5 = new BetterShopScreen(getWidth(), getHeight());
		setScreen(screen1);
	}
}