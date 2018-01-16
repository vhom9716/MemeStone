package menu;

import java.util.List;

import battle.BattleScreen;
import cards.DeckBuilderScreen;
import guiTeacher.GUIApplication;
import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import holiday.HolidayCard;
import holiday.Snowflake;

public class MenuScreen extends GUIApplication{
	
public MenuScreen(int width, int height) {
		super(width, height);
		setVisible(true);
	}

public static MenuScreen menu;

public static void main(String[] args){
	menu = new MenuScreen(1200, 800);
	Thread runner = new Thread(menu);
	runner.start();
}

public static MenuScreen screen1;




@Override

public void initScreen() {

screen1 = new MenuScreen(getWidth(), getHeight());
setScreen(MenuScreen);
}

public void initAllObjects(List<Visible> viewObjects) {
	viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/winterscape.jpg"));
	Button open = new Button((getWidth()-100)/2,getHeight()-40,100,30,"Open",new Action() {
		
		@Override
		public void act() {
			MenuScreen.menu.setScreen(MenuScreen.inside);
		}
	});
	for(int i = 0; i < 28; i++){
		viewObjects.add(new Snowflake(getWidth(), getHeight()));
	}
	viewObjects.add(open);
}

}