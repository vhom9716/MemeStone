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
		cardIndex = index;
		this.graphic = graphic;
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
		if(EditorScreen.playerDeck.size() < 15) {
			if(EditorScreen.page1[cardIndex].getAmtUsed() < EditorScreen.page1[cardIndex].getAmt()) {
				EditorScreen.playerDeck.add(EditorScreen.page1[cardIndex]);
				EditorScreen.page1[cardIndex].usedOne();
				Menu.screen4.updateDeck();
				Menu.screen4.updateCardAmts();
			}
		//Menu.screen4.changeText();
		}
	}
	
	public void setGraphic(String location, int index, int w, int h) {
		//graphic = new Graphic(0,0,1.0,location);
		loadImages(location, w, h);
		cardIndex = index;
		update();
	}
	
}
