import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class MenuScreen extends FullFunctionScreen {

	
	
	public MenuScreen(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 0, getWidth(),getHeight(),"resources/TheSuperOfficialMenu.png"));
		Button open = new Button((getWidth()-100)/2,getHeight()-40,100,30,"Open",new Action() {
			
			@Override
			public void act() {
				Menu.menu.setScreen(Menu.//What do I put here?);
			}
		});
		viewObjects.add(open);
	}

}
