package menu;

import java.awt.Color;
import java.util.List;

import battle.BattleScreen;
import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MenuScreen extends FullFunctionScreen {

	private static final long serialVersionUID = 258186143576427947L;
	AnimatedComponent mario;
 
	public MenuScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub 
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new StretchGraphic(0, 0, getWidth(),getHeight(),"resources/Menu1440_824.png"));
		Button openShop = new Button(630,670,210,170," ",new Action() {
			
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen2);
			}
		});
		viewObjects.add(openShop);
		Button openBattle = new Button(525, 270,400,65," ",new Action() {
			
			@Override
			public void act() {
				Menu.screen3 = new BattleScreen(1440, 824);
				Menu.menu.setScreen(Menu.screen3);
			}
		});
		viewObjects.add(openBattle);
		Button openDeck = new Button(500, 340,450,65," ",new Action() {
			
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen4);
			}
		});
		viewObjects.add(openDeck);
	}
}


