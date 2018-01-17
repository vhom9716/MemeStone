package menu;

import guiTeacher.GUIApplication;
import guiTeacher.userInterfaces.Screen;


public class Menu extends GUIApplication {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2452328323352199392L;


	public Menu(int width, int height) {
		super(width, height);
		setVisible(true);
		// TODO Auto-generated constructor stub
	}
	
	 public static Menu menu;

	
	public static void main(String[] args){
		menu = new Menu(1200, 800);
		Thread go = new Thread(menu);
		go.start();
	}

    public static MenuScreen screen1;

    public static ShopScreen screen2;
	
	@Override
	public void initScreen() {
		screen1 = new MenuScreen(getWidth(), getHeight());
		screen2 = new ShopScreen(getWidth(), getHeight());
		setScreen(screen1);
	}
}