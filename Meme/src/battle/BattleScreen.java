package battle;

import java.util.List;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Graphic;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;

public class BattleScreen extends FullFunctionScreen {

	public static BattleScreen battle;
	public BattleScreen(int width, int height) {
		super(width, height);
		
	}
  
	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		viewObjects.add(new Graphic(0, 20, getWidth(),getHeight(),"resources/background.jpg"));
		viewObjects.add(new Graphic(820,800,350,250,"resources/player.png"));
		viewObjects.add(new Graphic(820, 25, 350,250, "resources/cpu.png"));
		viewObjects.add(new Graphic(1650,70, 90, 80, "resources/quitButton.png"));
		viewObjects.add(new Button(1650,50, 80, 70, "", new Action() {

			@Override
			public void act() {
				BattleGUI.closeWindow();
			}
		}));
	}
}
<<<<<<< HEAD
   
=======
 
>>>>>>> refs/heads/battleBranch
