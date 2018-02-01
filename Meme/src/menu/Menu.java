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
<<<<<<< HEAD
	public void initScreen() { 
		screen1 = new MenuScreen(getWidth(), getHeight());
=======
	public void initScreen() {
		screen1 = new MenuScreen(1200, 800);
>>>>>>> refs/heads/deckBuilderClass
		screen2 = new ShopScreen(getWidth(), getHeight());
<<<<<<< HEAD
		screen3 = new BattleScreen(1440, 824);
		screen4 = new EditorScreen(getWidth(), getHeight());
=======
		screen3 = new BattleScreen(getWidth(), getHeight());
		screen4 = new EditorScreen(1800, 1300);
>>>>>>> refs/heads/deckBuilderClass
		setScreen(screen1);
	}
}