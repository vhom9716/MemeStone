package cards;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.ClickableGraphic;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;
import menu.Menu;

public class ClickableGraphicEditor extends ClickableGraphic{

	public ClickableGraphicEditor(int x, int y, int w, int h, String imageLocation, int index) {
		super(x, y, w, h, imageLocation);
		
	}

	private Graphic graphic;
	private int cardIndex;
	
//	public ClickableGraphic(int x, int y, String location, int index) {
//		super(x, y, 250, 350, "", null);
//		// TODO Auto-generated constructor stub
//		setGraphic(location, index);
//	}
//	
	
	public void act() {
		EditorScreen.playerDeck.addCard(EditorScreen.page1[cardIndex]);
		Menu.screen4.updateDeck();
		Menu.screen4.createButton();
		Menu.screen4.changeText();
	}
	
	public void setGraphic(String location, int index, int w, int h) {
		//graphic = new Graphic(0,0,1.0,location);
		loadImages(location, w, h);
		cardIndex = index;
		update();
	}
	
}
