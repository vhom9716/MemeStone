package cards;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import guiTeacher.components.Action;
import guiTeacher.components.Button;
import guiTeacher.components.Component;
import guiTeacher.components.Graphic;
import menu.Menu;

public class ClickableGraphic extends Button{

	private Graphic graphic;
	private int cardIndex;
	
	public ClickableGraphic(int x, int y, String location, int index) {
		super(x, y, 250, 350, "", null);
		// TODO Auto-generated constructor stub
		setGraphic(location, index);
	}
	
	
	public void act() {
		Deck.userDeck.add(EditorScreen.page1[cardIndex]);
		//for starting on the editor screen
		//DeckEditorGUI.screen2.updateDeck();
		
		//for starting on the main menu
		Menu.screen4.updateDeck();
	}
	
	@Override
	public void drawButton(Graphics2D g, boolean hovered) {
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(graphic != null && graphic.getImage() != null) {
			g.drawImage(graphic.getImage(), 0, 0, getWidth(), getHeight(), 0, 0, graphic.getWidth(), graphic.getHeight(), null);
		}
		if(hovered) {
			g.setColor(new Color(255,255,255,100));
			g.fillRect(0, 0, getWidth(), getHeight());
		}
	}

	public void setGraphic(String location, int index) {
		graphic = new Graphic(0,0,1.0,location);
		cardIndex = index;
		update();
	}
	
}
