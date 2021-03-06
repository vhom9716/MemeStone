package battle;

import java.awt.Color;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;

public class CardButton extends ClickableGraphic {

	boolean hasCard;
	
	public CardButton(int x, int y, int w, int h, Action action, String address) {
		super(x, y, w, h, "");
		hasCard = false;
		// TODO Auto-generated constructor stub
	}

	public CardButton(int x, int y, int w, int h, String text, Action action) {
		super(x, y, w, h, text);
		// TODO Auto-generated constructor stub
	}
	
	//on hover add border
	public void changeCardImage(String location, int w, int h) {
		loadImages(location, w, h);
	}
	public void moveCard(int x) {
		int dx = getX();
		int dy = getY();
		setX(30+x*150);
		setY(614);
		move(dx, dy, 500);
	}
	public void setHasCard(boolean b) {
		hasCard = b;
	}
	
	public boolean getHasCard() {
		return hasCard;
	}

}
