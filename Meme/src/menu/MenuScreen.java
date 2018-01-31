package menu;

import java.awt.Color;
import java.util.List;

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
		viewObjects.add(new StretchGraphic(0, 0, getWidth(),getHeight(),"resources/OfficialMenu.png"));
		Button openShop = new Button(500,700,120,30,"Buy Cards Temp",new Action() {
			
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen2);
			}
		});
		viewObjects.add(openShop);
		Button openBattle = new Button(470, 270,300,60,"Playtemp",new Action() {
			
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen3);
			}
		});
		viewObjects.add(openBattle);
		Button openDeck = new Button(400, 340,400,60,"deckTemp",new Action() {
			
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen4);
			}
		});
		viewObjects.add(openDeck);
	}

}
