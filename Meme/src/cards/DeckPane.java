package cards;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;

import guiTeacher.components.*;
import guiTeacher.interfaces.FocusController;
import guiTeacher.interfaces.Visible;
import guiTeacher.userInterfaces.ComponentContainer;

public class DeckPane extends Pane {

	private Button cardButton;

	public DeckPane(FocusController focusController, int x, int y, int width, int height) {
		super(focusController, x, y, width, height);
		// TODO Auto-generated constructor stub
	}

	public DeckPane(FocusController focusController, int x, int y, int width, int height,
			ArrayList<Visible> initWithObjects) {
		super(focusController, x, y, width, height, initWithObjects);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void update(Graphics2D g){
		//customize the background
		g.setRenderingHint( RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
		g.drawRoundRect(100, 1000, getWidth()-1, getHeight()-1, 10, 10);
		//draw the objects
		super.drawObjects(g);
	}

	public void initAllObjects(List<Visible> viewObjects){
		int yValue = 100;
		for(Card c: Deck.deck) {
			cardButton= new Button(1000, yValue, 150,40,c.getName(), Color.white, removeCard(c, Deck.deck));
		}
		yValue -= 40;
	}

	private Action removeCard(Card c, ArrayList<Card> deck) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
