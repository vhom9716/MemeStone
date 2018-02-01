package battle;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;

public class CardButton extends Button {

	public CardButton(int x, int y, int w, int h, String text, Color color, Action action, String address) {
		super(x, y, w, h, text, color, action);
		// TODO Auto-generated constructor stub
	}

	public CardButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text, action);
		// TODO Auto-generated constructor stub
	}
	
	//on hover add border
	public void highlight() {
		
	}

}
