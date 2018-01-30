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
		Button shop = new Button((getWidth()-100)/2,getHeight()-40,100,30,"Buy Cards",new Action() {
			
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen2);
			}
		});	
		Button battle = new Button(300,100,450,100,"Buy Cards",new Action() {
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen3);
			}
		});
		Button deck = new Button((getWidth()-100)/2,getHeight()-40,100,30,"Buy Cards",new Action() {
				
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.screen4);
			}
		});	
		viewObjects.add(shop);
		viewObjects.add(deck);
		viewObjects.add(battle);
	}

}
