package battle;

import java.util.List;

import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.FullFunctionScreen;
import holiday.HolidayCard;

public class BattleScreen extends FullFunctionScreen {

	public static BattleScreen battle;
	public BattleScreen(int width, int height) {
		super(width, height);
		setVisible(true);
	}

	@Override
	public void initAllObjects(List<Visible> viewObjects) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		 battle= new BattleScreen(800, 500);
		Thread runner = new Thread(battle);
		runner.start();
	}

}
